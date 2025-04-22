import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] seq = new int[]{4, 3, 2, 5, 6, 7, 8, 100, 1000, 0, -2, 3, 22, -4, 9, 10};
        System.out.println("The original Array is: " + Arrays.toString(seq));
        forLoopImplementationInsertionSort(seq);
        System.out.println("\nThe original Array is: " + Arrays.toString(seq) + "\nAs you can see, it didn't change at all.\n");
        insertionSort(seq, 1, 1);
        System.out.println("After running the Recursive Insertion Sort... This one changes the Original Array:");
        System.out.println(Arrays.toString(seq));

    }

    private static void forLoopImplementationInsertionSort(int[] nums){
        int[] temp = nums.clone();
        for (int i = 1; i < temp.length; i++) {
            for (int j = i; j > 0; j--) {
                if (temp[j] > temp[j - 1]) { // Modifying the sign from > to < orders it in reverse
                    break;
                } PiecesOfCodeIMayNeed.swap(temp, j, j - 1);
            }
        }
        System.out.println("\nFor Loop Implementation: " + Arrays.toString(temp) + "\nThis method doesn't change the original array.\n");
    }

    private static void insertionSort(int[] seq, int idx, int innerIdx) {
        if (idx >= seq.length) return;
        if (innerIdx > 0) {
            if (seq[innerIdx] <= seq[innerIdx - 1]) {
                PiecesOfCodeIMayNeed.swap(seq, innerIdx, innerIdx - 1);
            }
        } idx++;
        insertionSort(seq, idx, idx);
    }
}