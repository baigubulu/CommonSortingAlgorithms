/**
 * 此程序完成查找第二小的数据，时间复杂度:o(n)
 * 实现方法：遍历实现
 */
public class secondSmallest {

    public static void getSecondSmallest(int[] arrays) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MIN_VALUE;
        for (int array : arrays) {
            if (array < firstMin) {
                secondMin = firstMin;
                firstMin = array;
                //array数字小于第二小的数字并且和第一小的数值不相等
            } else if (array < secondMin && array != firstMin) {
                secondMin = array;
            }
        }
        System.out.println("第二小的数：" + secondMin);
    }

    public static void main(String[] args){
        int array[] = {5,2,3,1,0};
        getSecondSmallest(array);
    }
}
