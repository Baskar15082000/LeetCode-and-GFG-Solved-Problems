class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> list=new ArrayList<>();
		int fact=1;
		for(int i=1;i<n;i++){
			fact=fact*i;
			list.add(i);
		}
        list.add(n);
		String str="";
		k=k-1;
	
		while(true){
			str=str+(list.get(k/fact));
			System.out.print(5%6);
			list.remove(k/fact);
			if(list.size()==0){
				break;
			}
			k=k%fact;
			fact=fact/list.size();
		}
		return str;
    }
}