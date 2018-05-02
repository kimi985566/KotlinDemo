package Sort;

/**
 * Title: 交换排序中的快速排序，目前应用最为广泛的排序算法，是一个递归算法，依赖于初始序列
 * Description:快速排序包括两个过程：划分 和 快排
 * "划分"是指将原序列按基准元素划分两个子序列
 * "快排"是指分别对子序列进行快排
 * <p>
 * 就平均计算时间而言，快速排序是所有内部排序方法中最好的一个
 * <p>
 * 对大规模数据排序时，快排是快的；对小规模数据排序时，快排是慢的，甚至慢于简单选择排序等简单排序方法
 * <p>
 * 快速排序依赖于原始序列，因此其时间复杂度从O(nlgn)到O(n^2)不等
 * 时间复杂度：最好情形O(nlgn)，平均情形O(nlgn)，最差情形O(n^2)
 * <p>
 * 递归所消耗的栈空间
 * 空间复杂度：O(lgn)
 * <p>
 * 可选任一元素作为基准元素
 * 稳 定 性：不稳定
 * <p>
 * <p>
 * 内部排序(在排序过程中数据元素完全在内存)
 */

public class QuickSort {

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        //进行第一轮排序获取分割点
        int index = partition(array, left, right);
        //排序前半部分
        quickSort(array, left, index - 1);
        //排序后半部分
        quickSort(array, index + 1, right);
    }

    /**
     * 一次快速排序
     *
     * @param array 数组
     * @param left  数组的前下标
     * @param right 数组的后下标
     * @return key的下标index，也就是分片的间隔点
     */
    public static int partition(int[] array, int left, int right) {
        /** 固定的切分方式 */
        int key = array[left];//选取了基准点
        while (left < right) {
            //从后半部分向前扫描
            while (array[right] >= key && right > left) {
                right--;
            }
            array[left] = array[right];
            //从前半部分向后扫描
            while (array[left] <= key && right > left) {
                left++;
            }
            array[right] = array[left];
        }
        array[right] = key;//最后把基准存入

        return right;
    }
}
