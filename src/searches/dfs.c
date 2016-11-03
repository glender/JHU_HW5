 #include <stdio.h>
 #include "adjacency_list.h"

 void dfs_internal_run_recursively (vertex_node *graph_root, vertex_node *current_vnode) {
     vertex_node *vnode = NULL;
     edge_node *enode = NULL;

     if (!current_vnode) {
         return;
     }

     /* Start DFS */
     printf("[%s] DFS: Working on Vertex: %c \n", __FUNCTION__, current_vnode->val);
     for (enode = current_vnode->list_enode; enode != NULL; enode = enode->next_enode) {
         vnode = (vertex_node *)enode->parent_vnode; /* Get the vertex node pointer. */
         if (vnode->color == COLOR_WHITE) {
             vnode->color = COLOR_GRAY;
             dfs_internal_run_recursively(graph_root, vnode);
         }
     }

     /* We are done with this node. */
     current_vnode->color = COLOR_BLACK;
     printf("[%s] Done with the node (%c)\n", __FUNCTION__, current_vnode->val);
     adjlist_print(graph_root);
 }

 void dfs_run (vertex_node *graph_root) {
     vertex_node *vnode = NULL;

     if (!graph_root) {
         return;
     }

     /* First, color all the vertices white. */
     printf("\n[%s] Starting DFS. Color all Vertices as White\n", __FUNCTION__);
     for (vnode = graph_root; vnode != NULL; vnode = vnode->next_vnode) {
         vnode->color = COLOR_WHITE;
     }
     adjlist_print(graph_root);

     /* Start by making the current node gray. */
     graph_root->color = COLOR_GRAY;
     dfs_internal_run_recursively(graph_root, graph_root);
     printf("\n[%s] DFS Done\n", __FUNCTION__); 
 }

 int main () {
     vertex_node *graph_root = NULL; /* Root of the graph */
     int vertices[] = {'a', 'b', 'c', 'd', 'e'};
     int edges[][2] = {{'a', 'b'}, {'a', 'c'}, {'a', 'd'}, {'b', 'c'}, {'b', 'c'}, {'b', 'd'}, {'c', 'd'}, {'c', 'e'}};
     int len_vertices, len_edges, i;

     /* Add the vertices. */
     len_vertices = sizeof(vertices)/sizeof(vertices[0]);
     for (i = 0; i < len_vertices; i++) {
         adjlist_add_vertex(&graph_root, vertices[i], NULL); 
     }

     /* Add the edges. */
     len_edges = sizeof(edges)/sizeof(edges[0]);
     for (i = 0; i < len_edges; i++) {
        /* The third argument is the weight of the edge -- we keep it as 0 */
        adjlist_add_edge(graph_root, edges[i][0], edges[i][1], 0); 
     }

     /* Run DFS on this */
     dfs_run(graph_root);

     /* Done with the Adjacency List. Free it */
     adjlist_free(&graph_root);
 }
