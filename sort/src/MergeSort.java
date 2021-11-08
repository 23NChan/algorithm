public class MergeSort {
    public static void main(String[] args) {
        int[] arr = newarr(20, 500);
        printarr(arr);
        mergesort(arr);
        printarr(arr);
    }

    public static void mergesort(int[] arr) {
        if (arr == null && arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }


    public static void sortProcess(int[] arr, int L, int R) {
        ;
        if (L == R) {
            return;
        }
        int mid = (L + R) / 2;
        sortProcess(arr, L, mid);
        sortProcess(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }


    public static void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= r) {
            temp[i++] = arr[p2++];
        }
        for (i = 0;  i< temp.length; i++) {
            arr[l + i] = temp[i];
        }
    }

    //随机数组生成器
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
}
