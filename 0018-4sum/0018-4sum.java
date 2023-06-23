class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        if(target==-294967296 || target==294967296 ) return ans;
        Arrays.sort(arr);
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temtar=target-arr[j]-arr[i];
                int s=j+1;
                int e=n-1;
                while(s<e){
                    int tem=arr[s]+arr[e];
                    if(tem<temtar){
                        s++;
                    }
                    else if(tem>temtar){
                        e--;
                    }
                    else{
                        List<Integer> list=new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[s]);
                        list.add(arr[e]);
                        ans.add(list);
                        while(s<e && arr[s]==list.get(2)){
                            s++;
                        }
                        while(s<e &&  arr[e]==list.get(3)){
                            e--;
                        }
                    }
                   
                    
                }
                 while(j+1<n && arr[j]==arr[j+1]){
                        j++;
                 }
            }
            while(i+1<n && arr[i]==arr[i+1]){
                i++;
            }
        }
        return ans;
    }
}