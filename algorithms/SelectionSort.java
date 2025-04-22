import java.util.Arrays;

public class SelectionSort {
    private static int[] nums = PiecesOfCodeIMayNeed.nums;

    public static void main(String[] args) {
        int[] seq = new int[]{4, 3, 2, 5, 6, 7, 8, 100, 1000, 0, -2, 3, 22, -4, 9, 10};
        System.out.println("The original Array is: " + Arrays.toString(seq));
        forImplementationSelectionSort(seq);

        whileLoopImplementationSelectionSort(seq);
        System.out.println("The original Array still is: " + Arrays.toString(seq));
    }

    private static void forImplementationSelectionSort(int[] nums){
        int[] temp = nums.clone();
        for (int i = 0; i < temp.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < temp.length; j++) {
                if (temp[minIndex] > temp[j]) {
                    minIndex = j;
                }
            }
            int aux = temp[i];
            temp[i] = temp[minIndex];
            temp[minIndex] = aux;
        }
        System.out.println("The For Loop implemenation:\n" + Arrays.toString(temp) + "\n");
    }

    private static void whileLoopImplementationSelectionSort(int[] nums){
        int[] temp = nums.clone();

        int i = 0;
        while (i < temp.length) {
            int j = i + 1;
            int minIndex = i;
            while (j < temp.length) {
                if (temp[minIndex] > temp[j]) {
                    minIndex = j;
                }
                j++;
            }
            int aux = temp[i];
            temp[i] = temp[minIndex];
            temp[minIndex] = aux;
            i++;
        }
        System.out.println("\nThe While Loop implementation:\n" + Arrays.toString(temp) + "\n");
    }
}