 #include "stdio.h"
 #include "stdbool.h"
 #include "queue.h"
 #include "adjacency_list.h"

 vertex_node *graph_root = NULL; /* Root of the graph */

 void bfs_print_queue (queue *sq) {
     queue_elem *elem = NULL; 

     //printf("Printing Queue (size: %d): ", queue_get_size(sq));
     //for (elem = sq->head; elem != NULL; elem = elem->next) { 
     //    printf("%d  ", *(int *)(elem->data));
     //}   
     //printf("\n");
 }

 void bfs_run (vertex_node *source_node) {
     vertex_node *vnode = NULL, *internal_vnode = NULL;
     edge_node *enode = NULL;
     queue q;
     int err;

     /* Initialize the queue */
     queue_init(&q);

     /* First, color all the vertices white. */
     for (vnode = source_node; vnode != NULL; vnode = vnode->next_vnode) { 
         vnode->color = COLOR_WHITE;
     }

     vnode = source_node;
     vnode->color = COLOR_GRAY;
     queue_enqueue(&q, vnode);
     while (true) {
         bfs_print_queue(&q); 
         adjlist_print(graph_root);
         vnode = (vertex_node *)queue_dequeue(&q, &err);
         if (!vnode) {
             printf("\n[%s] BFS Done\n", __FUNCTION__); 
             return;
         }
         /* Run through all the edges for this node. */
         printf("\n[%s] BFS: current Vertex: %c \n", __FUNCTION__, vnode->val);
         for (enode = vnode->list_enode; enode != NULL; enode = enode->next_enode) { 
             internal_vnode = (vertex_node *)enode->parent_vnode;
             if (internal_vnode->color == COLOR_WHITE) {
                 internal_vnode->color = COLOR_GRAY;
                 queue_enqueue(&q, internal_vnode);
             }
         }
         /* This node is done. */
         vnode->color = COLOR_BLACK;
     }
 }

 int main () {
     int vertices[] = {'a', 'b', 'c', 'd', 'e'};
     int edges[][2] = {{'a', 'b'}, {'a', 'c'}, {'a', 'd'}, {'a', 'e'}, {'b', 'c'}, {'b', 'c'}, {'b', 'd'}, {'b', 'e'}, {'c', 'd'}, {'c', 'e'}};
     int len_vertices, len_edges, i; 

     /* Add the vertices. */
     len_vertices = sizeof(vertices)/sizeof(vertices[0]);
     for (i = 0; i < len_vertices; i++) {
         adjlist_add_vertex(&graph_root, vertices[i], NULL); 
     }

     /* Add the edges. */
     len_edges = sizeof(edges)/sizeof(edges[0]);
     for (i = 0; i < len_edges; i++) {
         adjlist_add_edge(graph_root, edges[i][0], edges[i][1], 0);
     }

     /* Run BFS on this */
     bfs_run(graph_root);

     /* Done with the Adjacency List. Free it */
     adjlist_free(&graph_root);
 }
