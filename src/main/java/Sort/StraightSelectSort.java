package Sort;

/**
 * Title: 选择排序中的直接选择排序，依赖于初始序列
 * Description: 每一趟 (例如第i趟，i = 0,1,...)在后面第n-i个待排序元素中选出最小元素作为有序序列的第i个元素
 * 时间复杂度：最好情形O(n^2)，平均情形O(n^2)，最差情形O(n^2)
 * 空间复杂度：O(1)
 * 稳    定   性：不稳定
 * 内部排序(在排序过程中数据元素完全在内存)
 */

public class StraightSelectSort {

    public static int[] selectSort(int[] target) {
        if (target != null && target.length != 1) {
            for (int i = 0; i < target.length; i++) {
                int min_index = i;
                for (int j = i + 1; j < target.length; j++) {
                    if (target[min_index] > target[j]) {
                        min_index = j;
                    }
                }
                if (target[min_index] != target[i]) {
                    swap(target, min_index, i);
                }
            }
        }
        return target;
    }

    private static void swap(int[] target, int min_index, int i) {
        int temp = target[min_index];
        target[min_index] = target[i];
        target[i] = temp;
    }
}
