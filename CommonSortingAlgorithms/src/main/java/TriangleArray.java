import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角的相关问题
 */
public class TriangleArray {
    /**
     * 本程序实现杨辉三角
     */
    public static void getRow(int rowIndex){
        ArrayList<Integer> res = new ArrayList<Integer>(rowIndex);

        if (rowIndex < 0){
            return;
        }

        /**
         * 生成的数据和行数是强管理的关系
         * 每次都会重新生成之前已经走过行数
         */
        for (int i = 0; i <= rowIndex; i++) {
            res.add(1);
            for (int j = i - 1; j > 0; j--) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }

    //打印杨辉三角,面试的时候，以改程序为主
    public static void programing(int rows){
        for (int i = 0; i < rows; i++) {
            //初始值
            int num = 1;
            //打印出空字符串
//            System.out.format("%" + (rows - i) * 2 + "s","");
            for (int j = 0; j <= i; j++) {
                System.out.format("%4d", num);
                //实现公式 -- 必须记住
                num = num * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

// getRow函数测试程序
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        for (int i = 0; i < a; i++) {
//            getRow(i);
//            System.out.println("\n");
//        }

//测试程序
//        String str = "123";
//        Map<Character, Integer> map = new HashMap<Character, Integer>();
//
//        for (char ch : str.toCharArray()){
//            if (map.containsKey(ch)){
//                map.put(ch, map.get(ch) + 1);
//            } else{
//                map.put(ch, 1);
//            }
//        }
        int rows = 10;
//        programing(rows);
        TriangleArray triangleArray = new TriangleArray();
        triangleArray.getRowMethodII(rows);

    }


    /**
     * 杨辉三角的实现 这其实是一道动态规划的问题
     * @param numRows ： 行数
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList();
        if (numRows == 0) {
            return triangle;
        }

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        // 从第一行开始遍历
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            // prevRow ： 上一行
            List<Integer> prevRow = triangle.get(rowNum - 1);
            // 最新一行
            List<Integer> row = new ArrayList<>();

            row.add(1);

            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    /**
     * 只需要保存上一层的数据，就可以很好的解决问题了
     * 还是满足杨辉三角的规则，收尾都是为1
     * @param rowIndex
     * @return
     */
    public List<Integer> getRowII(int rowIndex) {
        List<Integer> pre = new ArrayList();
        List<Integer> cur = new ArrayList<>();

        if (rowIndex == 0) {
            return cur;
        }
        for (int i = 0; i <= rowIndex; i++) {
            cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    // 上一行的前一个 + 当前行的相同位置
                    cur.add(pre.get(j - 1) + pre.get(i));
                }
            }
            pre = cur;
        }
        return cur;
    }

    /**
     * 上面这种实现方式还是存在一定弊端的，每一次需要反复的进行创建数据
     * 该种解法是在当前list的基础上完成一个新数据的生成，每次添加数据的时候，都需要取前一个数据进行计算
     * 解决方法，将cur当成pre，但是更新j的时候，需要把当前j的信息覆盖掉，更新j+1的时候，有需要之前j的信息，所以在更新前，需要一个变量把之前j的信息保存起来
     */
    public List<Integer> getRowMethodII(int rowIndex) {
        int pre = 1;
        List<Integer> cur = new ArrayList<>();  // 当前行数组
        cur.add(1);
        // 计算中间的数据值,注意这里面等号问题
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 1; j < i; j++) {
                int tmp = cur.get(j);
                cur.set(j, pre + cur.get(j));
                pre = tmp;
            }
            cur.add(1);
        }
        return cur;
    }

}
