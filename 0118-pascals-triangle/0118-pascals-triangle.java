class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        list.add(list1);
        List<Integer> list2=new ArrayList<>();
        if(numRows==1){
            return list;
            
        }
        list2.add(1);
        list2.add(1);
        list.add(list2);
        if(numRows==2){
            return list;
        }
        int nums=2;
        for(int i=2;i<numRows;i++){
            List<Integer> temp=new ArrayList<>();
            temp.add(1);
            for(int j=1;j<nums;j++){
                temp.add(list.get(i-1).get(j)+list.get(i-1).get(j-1));
            }
            temp.add(1);
            nums++;
            list.add(temp);
        }
        return list;
    }
}