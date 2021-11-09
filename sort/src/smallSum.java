import java.util.Arrays;

public class smallSum {
    public static void main(String[] args) {
//        int[] arr = newarr(20, 20);
//        printarr(arr);
//        int smallsum = smallsum(arr);
//        System.out.println(smallsum);

        boolean result = true;
        int size = 500;
        int value = 200;
        for (int a = 0; a < 50000; a++) {
            int[] arr = newarr(size, value);
            int SmallSum = smallsum(arr);       //验证的递归归并解题
            int Nomal = nomal(arr);             //绝对正确的解
            if (SmallSum != Nomal) {
                System.out.println("异常结果");
                printarr(arr);
                System.out.println("SmallSum  " + SmallSum);
                System.out.println("Nomal  " + Nomal);
                result = false;
                break;
            }

        }
        System.out.println(result ? "Nice" : "Error");
    }

    public static int smallsum(int[] arr) {
        if (arr == null && arr.length < 2) {
            return 0;
        }
        //复制数组保证原数组不会受到影响
        int[] a=new int[arr.length];
        for (int i=0;i<arr.length;i++){
            a[i]=arr[i];
        }
        return mergesort(a, 0, a.length - 1);
    }

    public static int mergesort(int[] arr, int L, int R) {
        if (R == L || L > R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return mergesort(arr, L, mid)
                + mergesort(arr, mid + 1, R)
                + merge(arr, L, mid, R);
    }

    public static int merge(int[] arr, int L, int mid, int R) {
        int p1 = L;
        int p2 = mid + 1;
        int i = 0;
        int[] temp = new int[R - L + 1];
        int res = 0;
        while (p1 <= mid && p2 <= R) {
            res += arr[p1] < arr[p2] ? arr[p1] * (R - p2 + 1) : 0;
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }
        for (i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
        return res;
    }

    public static int nomal(int[] arr) {
        int res = 0;
        for (int b = arr.length - 1; b > 0; b--) {
            for (int j = 0; j < b; j++) {
                res += arr[j] < arr[b] ? arr[j] : 0;
            }
        }
        return res;
    }

    //随机数组生成器
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
