package leetcode.Duplicate;

public class Duplicate {

    /**
     * 以数组{2,3,1,0,2,5,3}为例来分析找到重复数字的步骤。
     * 数组的第 0 个数字（从 0 开始计数，和数组的下标保持一致）是 2，与它的下标不相等，于是把它和下标为 2 的数字 1 交换。交换之后的数组是{1.3.2.0.2.5.3}。
     * 此时第 0 个数字是 1，仍然与它的下标不相等，继续把它和下标为 1 的数字 3 交换，得到数组{3,1,2,0,2,5,3}.接下来继续交换第 0 个数字 3 和第 3 个数字 0，得到数组{0,1,2,3,2,5,3}。
     * 此时第 0 个数字的数值为 0，接着扫描下一个数字。在接下来的几个数字中，下标为 1，2，3 的三个数字分别为 1，2，3 它们的下标和数值都分别相等，因此不需要做任何操作。接下来扫描到下标为 4 的数字 2。
     * 由于它的数值与它的下标不相等，再比较它和下标为 2 的数字。注意到此时数组中下标为 2 的数字也是 2，也就是数字在下标为 2 和下标为 4 的两个位置都出现了，因此找到一个重复的数字。
     * 相比较于hash算法(时间复杂度为o(n), 空间复杂度为(n))，该种算法的空间复杂度为o(n),时间复杂度为o(1)
     * @param numbers
     * @return
     */
    public static int duplicate(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            return -1;
        }

        for (int number : numbers) {
            if (number < 0 || number >= numbers.length) {
                return -1;
            }
        }

        for (int  i = 0; i < numbers.length; i++) {
            while(numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    return numbers[i];
                } else {
                    swap(numbers, i, numbers[i]);
                }
            }
        }
        return -1;
    }

    private static void swap(int[] data, int x, int y) {
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }

    public static void main(String[] args) {
        int[] num1 = {2, 1, 3, 1, 4};
        System.out.println(duplicate(num1));
    }
}
