/**
 * 题目信息：在N个乱序的数组中找第K大的数，不希望把全部数组进行排序
 * 实现思想：利用部分快排的思想，完成程序的实现
 * 时间复杂度：O(n)
 */
public class Quick_find {

    /**
     * 快速排序查找索引值
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] arr, int low, int high){
        int left = low;
        int right = high;
        int tmp = arr[left];
        while (left < right) {
            while (left < right && arr[right] <= tmp) {
                right--;
            }
            arr[left] = arr[right];

            while (left < right && arr[left] >= tmp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[right] = tmp;
        //返回的right值就是index的数值
        return right;
    }

    public static void find_k(int k, int[] arr, int low, int high) {
        if (k <= 0 || k > arr.length){
//            System.exit(-1);
            throw new RuntimeException("K的数值不符合范围");
        }
        //利用快排的思想，分割数据并找到index值
        int index = partition(arr, low, high);
        if (index == k - 1) {
            System.out.println("第" + k + "大的数是：" + arr[index]);
        } else if (index > k - 1) {
            //index的数值大于k的数值,因此去较小的部分
            find_k(k, arr, low, index - 1);
        } else {
            //index的数值小于k的数值,因此去较小的部分
            find_k(k, arr, index + 1, high);
        }
    }

    public static  void main(String[] args) throws Exception{
        int[] arr = {3,1,2,4,5,6,7};
        //找到第K大的元素
        find_k(0, arr, 0, arr.length - 1);

    }
}
