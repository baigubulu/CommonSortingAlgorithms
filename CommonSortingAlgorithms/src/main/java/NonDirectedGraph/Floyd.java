package NonDirectedGraph;

/**
 * 最小路径问题 -- 数据结构：图
 */
public class Floyd {
    /**
     * 时间复杂度为：O(n^3)
     * 使用二位数据实现
     * @param graph : 图的邻接矩阵
     * @param n ： 顶点的个数
     * @return
     */
   public int[][] floyd(int[][] graph, int n){
       //创建二维数据，临时存放数据，不改变之前的数据形式
       int[][] edge = new int[n][n];
       for (int i = 0; i < n; i++){
           for (int j = 0; j < n; j++){
               edge[i][j] = graph[i][j];
           }
       }

       //按照floyd的实现实现，查找最短路径
       //k代表中间转接的端点，存在中间节点的时候，路径会减少
       for (int k = 0; k < n; k++) {
           for (int i = 0; i < n; i++) {
               for (int j = 0; j < n; j++) {
                   if (edge[i][j] > edge[i][k] + edge[k][j]) {
                       edge[i][j] = edge[i][k] + edge[k][j];
                   }
               }
           }
       }
       return edge;
   }
}
