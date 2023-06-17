class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int index=0;
         ArrayList<Integer>list =new ArrayList<>();
        Deque<Integer> dq=new ArrayDeque<>();
        int arr[]=new int[n-k+1];
        for(int i=0;i<n;i++){
            if(dq.size()>0 && dq.getFirst()<=i-k){
                dq.removeFirst();
            }
            while(dq.size()>0 && nums[dq.getLast()] <nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                arr[index]=nums[dq.getFirst()];
                index++;
            }
        }
        return arr;
    }
}