import java.util.ArrayList;


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
        programing(rows);
    }
}
