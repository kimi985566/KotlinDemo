package Sort;

/**
 * Title: 插入排序中的折半插入排序，依赖于初始序列
 * Description: 折半搜索出插入位置，并直接插入;与直接插入搜索的区别是，后者的搜索要快于顺序搜索
 * 时间复杂度：折半插入排序比直接插入排序明显减少了关键字之间的比较次数，但是移动次数是没有改变。所以，
 * 折半插入排序和插入排序的时间复杂度相同都是O（N^2），在减少了比较次数方面它确实相当优秀，所以该算法仍然比直接插入排序好。
 * 空间复杂度：O(1)
 * 稳    定   性：稳定
 * 内部排序(在排序过程中数据元素完全在内存)
 */

public class BinaryInsertSort {

    public static int[] binaryInsertSort(int[] target) {
        if (target != null && target.length != 1) {
            for (int i = 1; i < target.length; i++) {
                int left = 0;
                int right = i - 1;
                int mid;
                int temp = target[i];
                if (temp < target[right]) {
                    while (left <= right) {
                        mid = (left + right) / 2;
                        if (target[mid] < temp) {
                            left = mid + 1;
                        } else if (target[mid] > temp) {
                            right = mid - 1;
                        } else {
                            left = left + 1;
                        }
                    }

                    for (int j = i; j > 0; j--) {
                        target[j] = target[j - 1];
                    }
                    target[left] = temp;
                }
            }
        }
        return target;
    }
}
