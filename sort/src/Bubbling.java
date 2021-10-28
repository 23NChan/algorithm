import java.util.Random;

public class Bubbling {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random(1);

        //随机初始化数组的值
        for (int i = 0; i < 10; i++) {
            arr[i] = r.nextInt(500);
        }

        //排序前数组的值
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();

        //执行冒泡排序
        Bubbing(arr);

        //排序后数组的值
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();

    }

    public static void Bubbing(int[] a) {
        int k;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if(a[j]>a[j+1]){
                    k =a[j];
                    a[j]=a[j+1];
                    a[j+1] = k;
                }
            }
        }
    }

}
