package Sort;

/**
 * Title: 插入排序中的希尔排序，依赖于初始序列
 * Description: 分别对间隔为gap的gap个子序列进行直接插入排序，不断缩小gap,直至为 1
 * <p>
 * 刚开始时，gap较大，每个子序列元素较少，排序速度较快；
 * 待到排序后期，gap变小，每个子序列元素较多，但大部分元素基本有序，所以排序速度仍较快。
 * <p>
 * 时间复杂度：O(n) ~ O(n^2)
 * 空间复杂度：O(1)
 * 稳    定   性：不稳定
 * 内部排序(在排序过程中数据元素完全在内存)
 */

public class ShellSort {

    public static void shellSort(int[] target) {
        if (target != null && target.length != 1) {
            int gap = target.length;
            while (gap > 1) {
                gap = gap / 3 + 1;
                for (int i = gap; i < target.length; i++) {
                    int j = i - gap;
                    while (j >= 0) {
                        if (target[j + gap] < target[j]) {
                            swap(target, j, j + gap);
                            j -= gap;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void swap(int[] target, int i, int j) {
        int temp = target[i];
        target[i] = target[j];
        target[j] = temp;
    }
}
