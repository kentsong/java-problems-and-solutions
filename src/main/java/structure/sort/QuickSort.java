package structure.sort;

public class QuickSort {

    /**
     * 快速排序
     * https://www.jianshu.com/p/4167ecfd23cb
     * @param args
     */

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 50};
        quickSort(a);
        System.err.println("排好序的数组：");
        for (int e : a) {
            System.out.print(e + " ");
        }
    }

    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int position = partition(arr, l, r);
        quickSort(arr, l, position - 1);
        quickSort(arr, position + 1, r);
    }

    /*
     * 对arr[l...r]部分进行partition操作
     * 返回position,是的arr[l...p-1]<arr[p],arr[p+1...r]>arr[p]
     * */
    public static int partition(int[] arr, int left, int right) {

        int value = arr[left];

        int position = left;
        //这里的right值是最右边的值 arr[right]是有效的
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < value) {
                /*
                 * 相关的操作
                 * 1.比初始位置大的数都放在初始位置的右边一个,放一个position的位置增加一
                 * */
                swap(arr, i, ++position);
            }
        }

        //走到这一步的时候  arr[l]存放的是分解值,arr[position]存放的是小于分界值
        swap(arr, left, position);
        return position;

    }

    private static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

}
