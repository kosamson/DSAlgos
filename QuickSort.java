public class QuickSort {
    public void sort(int[] nums) {
        subSort(nums, 0, nums.length - 1);
    }

    private void subSort(int[] nums, int lowIdx, int highIdx) {
        if (lowIdx < highIdx) {
            int partitionIdx = partition(nums, lowIdx, highIdx);

            subSort(nums, lowIdx, partitionIdx - 1);
            subSort(nums, partitionIdx + 1, highIdx);
        } 
    } 

    private int partition(int[] nums, int lowIdx, int highIdx) {
        int pivotIdx = (int) ( Math.random() * (highIdx - lowIdx) + lowIdx );
        swap(nums, lowIdx, pivotIdx);

        pivotIdx = lowIdx;
        lowIdx++;

        while (lowIdx <= highIdx) {
            if (nums[lowIdx] >= nums[pivotIdx]) {
                swap(nums, lowIdx, highIdx);
                highIdx--;
            }

            else {
                lowIdx++;
            }
        }

        swap(nums, pivotIdx, highIdx);
        
        return highIdx;
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}
