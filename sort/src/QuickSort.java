public class QuickSort {
    public static void main(String[] args) {
        int size = 50;
        int value = 500;
        for (int i = 0; i < 50000; i++) {
            int[] arr = newarr(size, value);
            quicksort(arr);
        }

        int[] arr = newarr(20, 400);
        printarr(arr);
        quicksort(arr);
        printarr(arr);
    }

    public static void quicksort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quicksort(arr, 0, arr.length - 1);
    }

    public static void quicksort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) ((R - L) * Math.random()), R);
            int[] p = partition(arr, L, R);
            quicksort(arr, L, p[0] - 1);
            quicksort(arr, p[1] + 1, R);
        }

    }

    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //随机整数数组生成器
    public static int[] newarr(int size, int value) {
        int[] arr = new int[(int) ((size + 1) * Math.random())];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random());
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
