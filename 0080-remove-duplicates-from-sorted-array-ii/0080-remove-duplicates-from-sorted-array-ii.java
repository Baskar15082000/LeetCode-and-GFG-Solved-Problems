class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
    
    if (n <= 2) {
        return n;
    }
    
    int j = 2;  
    int i=2;
    while(i < n) {
       
        if (nums[i] != nums[j - 2]) {
            nums[j] = nums[i]; 
            j++;
        }
        i++;
    }
    
    return j;
    }
}

        
