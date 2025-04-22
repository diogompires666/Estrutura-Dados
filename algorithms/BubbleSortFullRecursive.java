package sorting.bubblesort;

import java.util.Scanner;
import java.util.Arrays;

public class BubbleSortFullRecursive{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] seq = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(seq));
        recRec(seq, 0, 0);
        System.out.println(Arrays.toString(seq));
        sc.close();
    }


    private static void recRec(int[] seq, int idx, int innerIdx){
        if(idx >= seq.length) return;
        if(innerIdx < seq.length){
            if(seq[idx] < seq[innerIdx]){
                int temp = seq[idx];
                seq[idx] = seq[innerIdx];
                seq[innerIdx] = temp;
            }
            recRec(seq, idx, innerIdx + 1);
        }
        recRec(seq, idx + 1, 0);
    }
}