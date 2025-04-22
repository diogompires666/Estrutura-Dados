package sorting.countingsort;

public class CountingSort {

    // Traditional Counting Sort implementation
    public int[] classicCountingSort(int[] a, int k) {
        int[] c = new int[k];
        for (int i = 0; i < a.length; i++) {
            c[a[i] - 1] += 1;
        }
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i-1];
        }
        int[] b = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            b[c[a[i] - 1] - 1] = a[i];
            c[a[i] - 1] -= 1;
        }
        return b;
    }

    //Counting sort implementation that accepts the 0.
    public int[] zeroCountingSort(int[] v, int k) {
        int[] helper = new int[k + 1];
        for (int i = 0; i <= v.length; i++) {
            helper[v[i]] += 1;
        }
        int[] out = new int[v.length];
        for (int j = v.length - 1; j >= 0; j--) {
            out[helper[v[j]] - 1] = v[j];
            out[v[j]] -= 1;
        }
        return out;
    }

     // Counting sort version that accepts negative numbers.
    public int[] negativesCountingSort(int[] v, int k) {
        int smallest = Math.abs(findSmallest(v));
        int len = (k + smallest);
        int[] frequencyAcc = new int[len];
        for (int i = 0; i < frequencyAcc.length; i++) {
            frequencyAcc[v[i] + smallest] += 1;
        }
        for (int i = 1; i < frequencyAcc.length; i++) {
            frequencyAcc[i] += frequencyAcc[i - 1];
        }
        int[] out = new int[v.length];
        for (int i = v.length -1; i >= 0; i++) {
            out[frequencyAcc[v[i] + smallest] - 1] = v[i];
            frequencyAcc[v[i] + smallest]-=1;
        }
        return out;
    }
    private static int findSmallest(int[] nums){
        int smallest = nums[0];
        for (int num : nums) {
            if (num < smallest) smallest = num;
        }
        return smallest;
    }
}