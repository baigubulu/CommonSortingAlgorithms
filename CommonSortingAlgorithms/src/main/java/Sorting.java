import java.util.Arrays;

/**
 * 从小到大进行排序
 */
public class Sorting {

    //堆排序 -- 产生大根堆 -- 从大到小排序
    public void maxHeapDown(int[] array, int start, int end) {
        int tmp = array[start];
        for (int i = start * 2; i <= end; i++) {

            if (i < end && array[i] < array[i + 1]) {
                i++;  //右边的大
            }

            if (array[i] <= tmp) {
                break;
            } else {
                array[start] = array[i];
                start = i;
            }
    }
    array[start] = tmp;
}
    //堆排序 -- 主函数
    public void heapSortMax(int[] a) {
        int length = a.length - 1;
        int i, tmp;
        //建立大根堆
        for (i = length / 2; i > 0; i--) {
            maxHeapDown(a, i, length);
        }
        //完成堆排序
        for (i = length; i > 1; i--) {
            //交换数据的值,第一个节点和最后一个节点交换顺序
            tmp = a[0];
            a[0] = a[i];
            a[0] = tmp;
            //交换数据完成之后，每次都需要进行整理大根堆
            maxHeapDown(a, 0, i);
        }
        System.out.println(Arrays.toString(a));
    }


    //-- 从小到大排序
    public static void minHeapDown(int[] array, int start, int end) {
        int tmp = array[start];

        for (int i = start * 2; i <= end; i++) {
            if (i < end && array[i] > array[i + 1]) {
                i++;
            }

            if (array[i] >= tmp) {
                break;
            } else {
                array[start] = array[i];
                start = i;
            }
        }
        array[start] = tmp;
    }
    //堆排序实现主函数
    public void heapSortMin(int[] array) {
        int length = array.length - 1;
        int i, temp;
        for(i = length / 2; i > 0; i--) {
            minHeapDown(array, i, length);
        }

        for (i = length; i > 1; i--) {
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            minHeapDown(array, 0, i);
        }
    }

    /**
     * 快速排序，拆分成两个数组，完成排序
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {
        int left = start;
        int right = end;

        int tmp = array[left];
        while (left < right) {
            while (left < right && array[right] >= tmp) {
                right--;
            }
            array[left] = array[right];

            while (left < right && array[left] <= tmp) {
                left++;
            }
            array[right] = array[left];

        }

        array[left] = tmp;
        return left;
    }

    //快速排序 -- 递归调用
    public void quickSort(int[] array, int start, int end) {
        if (end > start) {
            //求出终端点的数据
            int index = partition(array, start, end);
            quickSort(array, start, index - 1);
            quickSort(array, index + 1, end);
        }
    }

    //Array.Sort()函数使用的就是快速排序完成排序功能
    public void quickSortByArray(int arrays[]){
        Arrays.sort(arrays);
        //打印数据
        System.out.print(Arrays.toString(arrays));
    }

    //插入排序算法 -- 适用于部分有序的数组，将数据插入到有序的数组中
    public void insertSort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = i; j > 0; j--) {
                //降序排列
                if (arrays[j] < arrays[j - 1]) {
                    //交换两个数组的位置
                    int tmp = arrays[j - 1];
                    arrays[j - 1] = arrays[j];
                    arrays[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arrays));
    }

    //冒泡排序
    public static int[] bubbleSort(int[] arrays) {
        int length = arrays.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                //j和i的数据进行比较
                if (arrays[j] < arrays[i]) {
                    //交换两个数据的顺序
                    int tmp = arrays[j];
                    arrays[j] = arrays[i];
                    arrays[i] = tmp;
                }
            }
        }
        return arrays;
    }

    //选择排序
    public int[] selectSort(int[] arrays) {
        int length = arrays.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (arrays[min] > arrays[j]) {
                    min = j;
                }
            }

            if (min != i) {
                //交换两个元素的位置
                int tmp = arrays[i];
                arrays[i] = arrays[min];
                arrays[min] = tmp;
            }
        }
        return arrays;
    }

    //希尔排序，需要找到grap的数值
    public void shellSort(int array[]) {
        int j;
        //grap每次减半，得到数据
        for (int grap = array.length / 2; grap > 0; grap /= 2) {
            for (int i = grap; i < array.length; i++) {
                int tmp = array[i];
                //间距为grap的两个数值交换数据
                for (j = i; j >= grap && tmp < array[j - grap]; j -= grap) {
                    array[j] = array[j - grap];
                }
                array[j] = tmp;
            }
        }
    }

    //测试函数
    public static void main(String[] args) {
        int array[] = {2, 1, 4, 3, 5};
        Sorting sorting = new Sorting();
        //插入排序算法
//        sorting.insertionSort(arry);
        sorting.heapSortMax(array);   //输出的结果：[5, 4, 3, 2, 1]
        sorting.heapSortMin(array);   //输出的结果：[5, 4, 3, 2, 1]
//        sorting.quickSort(array, 0, array.length - 1);
//        sorting.bubbleSort(array);
//        sorting.shellSort(array);
//        sorting.selectSort(array);
//        sorting.insertSort(array);

        System.out.println(Arrays.toString(array));
    }
}
