package com.ysdrzp.binary;

/**
 * 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++){
            array[i] = i;
        }
    }

    /**
     * 循环实现
     * @param a
     * @param val
     * @return
     */
    /*private static int binarySearch(int[] a, int val){
        int start = 0, end = a.length-1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (a[mid] > val){
                end = mid - 1;
            }else if (a[mid] < val){
                start = mid + 1;
            }else {
                return mid;
            }
        }

        return -1;
    }*/



    /**
     * 递归实现
     * @param a
     * @param val
     * @return
     */
    public int binarySearch(int[] a, int val){
        return bSear(a, val, 0, a.length);
    }

    /**
     * 在 start - end 区间内搜索元素 val
     * @param a
     * @param val
     * @param start
     * @param end
     * @return
     */
    private int bSear(int[] a, int val, int start, int end) {
        if(start > end)
            return -1;

        int mid = start + (end - start) / 2;
        if(a[mid] == val)
            return mid;
        else if(a[mid] > val)
            end = mid - 1;
        else start = mid + 1;

        return bSear(a, val, start, end);
    }


    /**
     * 查找第一个值等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != value)) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 查找最后一个值等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 查找第一个大于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearch3(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearch4(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] > value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

}
