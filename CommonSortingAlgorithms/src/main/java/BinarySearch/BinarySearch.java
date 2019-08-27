package BinarySearch;

/**
 * 使用两种方式实现数组的二分查找
 * 该序列必须已经排好顺序的
 */
public class BinarySearch {

    //使用循环法实现二分查找
    public static int binSearchLoop(int[] array, int data) {
        int length = array.length;
        int low = 0;
        int high = length - 1;
        //找到中间接节点
        int middle;

        while (low < high) {
            middle = (low + high) / 2;
            if (array[middle] == data) {
                return middle + 1;
            } else if (array[middle] < data) {
                low = middle + 1;
            } else {
                //array[middle] > data
                high = middle - 1;
            }
        }
        return -1;
    }

    //递归方式实现二分查找  -- 时间复杂度为O(logn)
    public static int binSearchInterator(int[] array, int data, int low, int high) {
        int middle;

        if (low < high) {
            middle = (low + high) / 2;
            if (array[middle] == data) {
                return middle + 1;
            } else if (array[middle] < data) {
                //当中位数小于data
                return binSearchInterator(array, data, middle + 1, high);
            } else {
                //当中位数大于data
                return binSearchInterator(array, data, low, middle - 1);
            }
        }
        //如果没有查询到数据，则返回-1
        return -1;
    }

    /**
     * 查找元素第一次出现的位置
     * 相当于输出low的数值
     * @param array
     * @param data
     * @return
     */
    public static int findFirstLocation(int[] array, int data){
        int low = 0;
        int high = array.length - 1;
        int middle;

        while (low < high) {
            middle = (low + high) / 2;
            if (array[middle] < data) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        if (array[low] != data) {
            return -1;
        } else {
            return low;
        }
    }

    /**
     * 查找元素第后次出现的位置
     * 相当于数据high的数值
     * @param array
     * @param data
     * @return
     */
    public static int findLastLocation(int[] array, int data){
        int low = 0;
        int high = array.length - 1;
        int middle;
        while (low < high) {
            middle = (low + high) / 2;
            if (array[middle] < data) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        if (array[high] != data) {
            return -1;
        } else {
            return high;
        }
    }

}
