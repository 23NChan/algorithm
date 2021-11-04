public class InsertSort {
    public static void main(String[] args) {
        //随机生成整数数组
        int[] arr = newarr(100, 500);
        printarr(arr);
        insertSort(arr);
        printarr(arr);

    }


    //随机整数数组生成器
    public static int[] newarr(int size, int value) {
        int[] arr = new int[(int) ((size + 1) * Math.random())];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random()) - (int) ((value + 1) * Math.random());
        }
        return arr;
    }


    //打印数组
    public static void printarr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
        System.out.println();
        System.out.println("随机生成的数组长度为" + arr.length);
    }


    //插入排序  最坏情况 O(N^2)
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; (j > 0) && (arr[j] < arr[j - 1]); j--) {
                arr[j] = arr[j] ^ arr[j - 1];
                arr[j - 1] = arr[j] ^ arr[j - 1];
                arr[j] = arr[j] ^ arr[j - 1];
            }
        }
    }
}
