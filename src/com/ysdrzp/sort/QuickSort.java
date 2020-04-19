package com.ysdrzp.sort;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {6,5,3,7,8,1,2,0,4,9};
        quickSortC(a, 0, a.length-1);
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    /**
     * 快排
     * @param a
     * @param p
     * @param r
     */
    private static void quickSortC(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition(a, p, r);
        quickSortC(a, p, q - 1);
        quickSortC(a, q + 1, r);
    }

    /**
     * 分区
     * @param a
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] a, int start, int end) {
        // 基准元素
        int pivot = a[end];
        // 游标元素 i
        int i = start;
        for (int j = start; j < end; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i = i + 1;
            }
        }
        swap(a, i, end);
        return i;
    }

    /**
     * 元素交换
     * @param a
     * @param i
     * @param j
     */
    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
