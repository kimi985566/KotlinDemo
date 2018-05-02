package Sort;

import java.util.Arrays;

/**
 * Title: 交换排序中的冒泡排序 ，一般情形下指的是优化后的冒泡排序，最多进行n-1次比较，依赖于初始序列
 * Description:因为越大的元素会经由交换慢慢"浮"到数列的顶端(最后位置)，最大的数最后才确定下来，所以称为冒泡排序
 * 时间复杂度：最好情形O(n)，平均情形O(n^2)，最差情形O(n^2)
 * 空间复杂度：O(1)
 * 稳 定 性：稳定
 * 内部排序(在排序过程中数据元素完全在内存)
 */

public class BubbleSort {

    public static int[] bubbleSort(int[] target) {
        if (target != null && target.length != 1) {
            for (int i = 0; i < target.length; i++) {
                for (int j = target.length - 1; j > i; j--) {
                    if (target[j] < target[j - 1]) {
                        swap(target, j, j - 1);
                    }
                }
            }
        }
        return target;
    }

    public static int[] optimizeBubbleSort(int[] target) {
        int n = target.length;
        if (target != null && n != 1) {
            // 最多需要进行n-1躺，每一趟将比较小的元素移到前面，比较大的元素自然就逐渐沉到最后面了，这就是冒泡
            for (int i = 0; i < n - 1; i++) {
                boolean exchange = false;
                for (int j = n - 1; j > i; j--) {
                    if (target[j] < target[j - 1]) {
                        swap(target, j, j - 1);
                        exchange = true;
                    }
                }
                System.out.println(Arrays.toString(target));
                if (!exchange) {    // 若 i 到 n-1 这部分元素已经有序，则直接返回
                    return target;
                }
            }
        }
        return target;
    }

    public static void swap(int[] target, int i, int j) {
        int temp = target[i];
        target[i] = target[j];
        target[j] = temp;
    }
}
