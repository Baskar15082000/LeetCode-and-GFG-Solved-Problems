class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        // Step 1: Find the first element from the right such that nums[i] < nums[i+1]
        int i = n - 2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        // Step 2: If no such element is found, reverse the array and return
        if (i == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        // Step 3: Find the smallest element to the right of i that is greater than nums[i]
        int j = n - 1;
        while (nums[j] <= nums[i]) {
            j--;
        }
        // Step 4: Swap nums[i] with nums[j]
        swap(nums, i, j);
         // Step 5: Reverse the subarray to the right of i
        reverse(nums, i + 1, n - 1);
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
   private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    } 
    
}