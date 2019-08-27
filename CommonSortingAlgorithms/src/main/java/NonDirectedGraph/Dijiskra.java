package NonDirectedGraph;

//最小路径文图
public class Dijiskra {

    /**
     * 实现思想：每次找到离源点最近的一个顶点，然后以该顶点为中心进行扩展，最终得到源点到其余所有点的最短路径
     * @param edge : 默认该二维数组中已经填写好了数值
     * @return
     */
    public int[] dijiskra(int[][] edge){
        //得到顶点个数
        int vartex = edge.length;
        //标记位
        int flag = 0;
        //记录某个顶点没有被访问到
        int[] mark = new int[vartex];

        //求第一个顶点到其他顶点的最短距离
        mark[0] = 1;
        int[] distance = new int[vartex];
        //最一开始该一维数组中都是边的值，这里传进来就得事先做好处理，比如两个顶点之间不可达，那么就应该复制一个很大的数
        for (int i = 0; i < vartex; i++){
            distance[i] = edge[0][i];
        }

        //核心代码
        for (int i = 1; i < vartex; i++){
            //设定的初始值 -- 该值理想为无穷大
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < vartex; j++){
                //从原点到j顶点的路径距离最小
                if (mark[j] == 0 && distance[j] < min){
                    min = distance[j];
                    flag = j;
                }
            }
            mark[flag] = 1;
            //距离更新的过程
            for (int k = 0; k < vartex; k++){
                //通过借助第三点找到数据
                if (distance[k] > distance[k] + edge[flag][k]){
                    distance[k] = distance[k] + edge[flag][k];
                }
            }
        }
        return distance;
    }
}
