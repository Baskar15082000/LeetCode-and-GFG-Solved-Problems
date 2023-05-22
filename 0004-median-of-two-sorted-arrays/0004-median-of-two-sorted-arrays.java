class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            list.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            list.add(nums2[i]);
        }
       Collections.sort(list);
       int length=(list.size()/2);
      double median=0;
       if(list.size()%2==0){
           median=(float)(list.get(Math.abs(length-1))+list.get(length))/2;

       }
       else{
           median=list.get(length);
       }
       return median;
    }
}