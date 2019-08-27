package NonDirectedGraph;

/**
 * 利用动态规划的思想解决问题
 * 借鉴文档:http://www.cnblogs.com/lixing-nlp/p/7688549.html
 */
public class DynamicProgramming {

    public static int[][] dynamic(int[][] array){
        //二维数组，列，行 进行校验
        if (array == null || array.length <= 0 || array[0].length == 0){
            return null;
        }
        //初始化数据的过程
        int[][] flag = new int[array.length][array[0].length];

        flag[0][0] = array[0][0];
        //对flag数组进行初始化,先对列初始化，在对行初始化
        for (int i = 0; i < array[0].length; i++){
            flag[0][i] = flag[0][i] + array[0][i];
        }

        for (int i = 0; i < array.length; i++){
            flag[i][0] = flag[i][0] + array[i][0];
        }

        //对flag初始化完成之后，进行核心数据处理,将整个单元格填满
        for (int i = 1; i < array.length; i++){
            for (int j = 1; j < array[0].length; j++){
                if (flag[i - 1][j] > flag[i][j - 1]){
                    flag[i][j] = array[i][j] + flag[i][j - 1];
                } else {
                    flag[i][j] = array[i][j] + flag[i - 1][j];
                }
            }
        }
        return flag;
    }
}
