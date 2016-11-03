 #include <stdio.h>
 #include <stdlib.h>
 #include <strings.h>
 #include "queue.h"

 /* Initializes the Queue. */
 void queue_init (queue *sq) {
     bzero((void *)sq, sizeof(queue));
     return;
 }

 /* Return the size of the Queue. */
 int queue_get_size (const queue *sq) {
     if (!sq) {
         return -1; 
     } else {
         return (sq->size); 
     }   
 }

 /* Adds to the tail. */
 void queue_enqueue (queue *sq, void *data) {
     queue_elem *elem = NULL;

     /* Build the element that needs to be inserted */
     elem = (queue_elem *) malloc(sizeof(queue_elem));
     if (!elem) {
         fprintf(stderr, "Malloc failed.\n");
         return;
     }
     elem->data = data;
     elem->next = NULL;

     /* Move the tail to point to this element */
     if (sq->tail) {
         sq->tail->next = elem;
     }
     sq->tail = elem;

     /* If this elem is the first one, then make the head point to it */
     if (!sq->head) {
         sq->head = elem;
     }

     /* Increase the size. */
     sq->size += 1;
 }

 /* Removes from the head. */
 void *queue_dequeue (queue *sq, int *err) {
     queue_elem *hd = NULL;
     void *retData;

     if (!sq || !sq->head) {
         /* Queue is NULL or head points to NULL. Nothing to return */
         *err = QUEUE_ERRNO_EMPTY;
         return NULL;
     }

     /* This is the head and we need to return data associated with that */
     hd = sq->head;
     retData = hd->data;

     /* Move the head to the next element */
     sq->head = sq->head->next;

     /* Update the tail if all elements are gone */
     if (!sq->head) { 
         sq->tail = NULL;
     }

     /* Free the previous head */
     free(hd);

     /* Decrease the size. */
     sq->size -= 1;

     *err = QUEUE_ERRNO_SUCCESS;
     return retData;
 }
