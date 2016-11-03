 #ifndef __QUEUE_H__
 #define __QUEUE_H__

 #define QUEUE_ERRNO_SUCCESS   1
 #define QUEUE_ERRNO_EMPTY    -1

 typedef struct queue_elem_ {
     struct queue_elem_ *next;
     void               *data; /* Holds the data */
 } queue_elem;

 /* Representation of the Queue */
 typedef struct queue_ {
     struct queue_elem_ *head;
     struct queue_elem_ *tail;
     int size;
 } queue;

 /* Initializes the Queue. */
 void queue_init(queue *sq); 

 /* Adds to the tail. */
 void queue_enqueue(queue *sq, void *data); 

 /* Removes from the head. If err is QUEUE_ERRNO_EMPTY, then queue is empty. */
 void *queue_dequeue(queue *sq, int *err);

 /* Returns the size of the Queue. */
 int queue_get_size(const queue *sq); 

 #endif /* __QUEUE_H__ */
