package Sort;

/**
 * Title: 堆排序(选择排序)，升序排序(最大堆)，依赖于初始序列
 * Description: 现将给定序列调整为最大堆，然后每次将堆顶元素与堆尾元素交换并缩小堆的范围，直到将堆缩小至1
 * 时间复杂度：O(nlgn)
 * 空间复杂度：O(1)
 * 稳 定 性：不稳定
 * 内部排序(在排序过程中数据元素完全在内存)
 */

public class HeapSort {

    public static int[] heapSort(int[] arr) {
        if (arr != null && arr.length != 1) {
            //1.构建大顶堆
            for (int i = arr.length / 2 - 1; i >= 0; i--) {
                //从第一个非叶子结点从下至上，从右至左调整结构
                sift(arr, i, arr.length);
            }
            //2.调整堆结构+交换堆顶元素与末尾元素
            for (int j = arr.length - 1; j > 0; j--) {
                swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
                sift(arr, 0, j);//重新对堆进行调整
            }
        }
        return arr;
    }

    private static void sift(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    public static void swap(int[] target, int i, int j) {
        int temp = target[i];
        target[i] = target[j];
        target[j] = temp;
    }
}
