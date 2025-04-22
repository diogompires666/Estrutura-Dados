import java.util.Arrays;
import java.util.Scanner;

public class MergeSort{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
        sc.close();
    }

    private static void mergeSort(int[] array){
        int length = array.length;
        if (length <= 1) return;
        // Dividing arrays in half
        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        // Populating both right and left arrays
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (i < middle) {
                leftArray[i] = array[i];
            } else {
                rightArray[j++] = array[i];
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array){
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0;
        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                array[i++] = leftArray[l++];
            }
            else {
                array[i++] = rightArray[r++];
            }
        }
        while (l < leftSize) {
            array[i++] = leftArray[l++];
        }
        while (r < rightSize) {
            array[i++] = rightArray[r++];
        }
    }
}