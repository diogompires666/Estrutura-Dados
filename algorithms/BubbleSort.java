package sorting.bubblesort;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] seq = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Original Array: " + Arrays.toString(seq) + "\n");
        forLoopImplementationBubbleSort(seq);
        whileLoopImplmentationBubbleSort(seq);
        System.out.println("\nOriginal Array: " + Arrays.toString(seq));
        System.out.println(
                "As you can notice that original array remains the same, beacuse this time I did not want to work with collateral effect");
        sc.close();
    }

    private static void forLoopImplementationBubbleSort(int[] nums) {
        int[] temp = nums.clone();

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length - i - 1; j++) {
                if (temp[j] > temp[j + 1]) {
                    int aux = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = aux;
                }
            }
        }
        System.out.println("\nThe For Loop Implementation of the Bubble Sort: " + Arrays.toString(temp) + "\n");
    }

    private static void whileLoopImplmentationBubbleSort(int[] nums) {
        int[] temp = nums.clone();

        int i = 0;
        while (i < temp.length) {
            int j = 0;
            while (j < temp.length - i - 1) {
                if (temp[j] > temp[j + 1]) {
                    int aux = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = aux;
                }
                j++;
            }
            i++;
        }
        System.out.println("\nThe While Loop Implementation of the Bubble Sort: " + Arrays.toString(temp) + "\n");
    }
}