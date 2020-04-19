package com.ysdrzp.sort;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {6,5,3,7,8,1,2,0,4,9};
        mergeSortUp2Down(a, 0, a.length-1);
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    public static void mergeSortUp2Down(int[] a, int start, int end){

        if (start >= end)
            return;

        int mid = start + (end - start) / 2;

        // 对左边序列归并排序
        mergeSortUp2Down(a, start, mid);
        // 对右边序列归并排序
        mergeSortUp2Down(a, mid + 1, end);
        // 合并排过序的两个序列
        merge(a, start, mid, end);
    }

    private static void merge(int[] a, int start, int mid, int end){
        int i = start;
        int j = mid + 1;
        int k = 0;

        int[] temp = new int[end - start + 1];
        while (i <= mid && j <= end){
            if (a[i] <= a[j]){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }

        while (i <= mid){
            temp[k++] = a[i++];
        }

        while (j <= end){
            temp[k++] = a[j++];
        }

        for (int m = 0; m < temp.length; m++){
            a[m + start] = temp[m];
        }
    }

}
