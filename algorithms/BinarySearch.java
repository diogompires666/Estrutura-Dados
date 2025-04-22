package binarysearch;

public class BinarySearch {
    private static int[] orderedNums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) {
        System.out.println("Binary search algorithm.\nIt returns the index of the element in the collection\n");
        System.out.println(String.format("The recursive approach: %d\nThe for loop approach: %d\nThe while loop approach: %d\nNotice that it's just different ways of doing the same thing so it will always return the same number.", recursiveApproach(orderedNums, 0, orderedNums.length - 1, 7), forLoopApproach(orderedNums, 7), whileLoopApproach(orderedNums, 7)));
    }

    private static int recursiveApproach(int[] nums, int start, int end, int wantedNum){
        if (start <= end) {
            int middle = ((end + start) / 2);

            if (nums[middle] == wantedNum) {
                return middle;
            }

            if (wantedNum < nums[middle]) {
                return recursiveApproach(nums, start, middle - 1, wantedNum);
            }
            else return recursiveApproach(nums, middle + 1, end, wantedNum);
        }

        return -1;
    }

    private static int forLoopApproach(int[] nums, int wantedNum){
        int start = 0, end = nums.length - 1;

        for (int i = 0; i < end; i++) {
            int middle = ((start + end) / 2);
            int index = nums[middle];

            if (index == wantedNum) {
                return middle;
            }

            if (index < wantedNum) {
                start = (middle + 1);
            } else {
                end = (middle - 1);
            }
        }
        return -1;
    }

    private static int whileLoopApproach(int[] nums, int wantedNum){
        int start = 0, end = (nums.length - 1);

        while (start <= end) {
            int middle = ((start + end) / 2);

            if (nums[middle] == wantedNum) {
                return middle;
            }

            if (nums[middle] < wantedNum) {
                start = (middle + 1);
            } else {
                end = (middle - 1);
            }
        }
        return - 1;
    }
}