import java.util.Arrays;

/**
 * 题目：将两个有序数据合并成一个有序数据集合
 * 实现思想：创建两个指针
 */

public class MergeList {

    /**
     * 需要借助于第三个数组
     * @param array1
     * @param array2
     * @return
     */
    public int[] mergeList(int array1[], int array2[]){
        int length1 = array1.length;
        int length2 = array2.length;
        //最后的结果集合
        int[] result = new int[length1 + length2];
        //定义三个指针变量
        int i = 0, j = 0, k = 0;

        //这块使用For循环也是可以解决问题的，Math.max(i.length,j.length)
        while (i < length1 && j < length2) {
            if (array1[i] < array2[j]) {
                result[k++] = array1[i++];
                //去重逻辑
            } else if (array1[i] == array2[j]) {
                //如果重复，将array1中的数据放入新的数组中
                result[k++] = array1[i];
                i++;
                j++;
            } else {
                result[k++] = array2[j++];
            }
        }

        /**
         * 当上面的while循环结束之后，一定存在一个数组已经被完全merage到result集合当中
         * 因为有序，剩余数据放入到新集合当中
         */
        while (i < length1) {
            result[k++] = array1[i++];
        }
        while (j < length2) {
            result[k++] = array2[j++];
        }
        return result;
    }

    public static void main(String[] args){
        MergeList mergeList = new MergeList();
        int array1[] = {1,2,3};
        int array2[] = {2,3,5};
        int result[] = mergeList.mergeList(array1,array2);
        System.out.println(Arrays.toString(result));
    }

}
