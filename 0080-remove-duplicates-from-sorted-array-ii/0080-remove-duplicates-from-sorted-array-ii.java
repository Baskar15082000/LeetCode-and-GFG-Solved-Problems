class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
    
    if (n <= 2) {
        return n;
    }
    
    int k = 2;  
    
    int j = k;  
    
    for (int i=k; i < n; i++) {
       
        if (nums[i] != nums[j - k]) {
            nums[j] = nums[i]; 
            j++;
        }
    }
    
    return j;
    }
}

        
