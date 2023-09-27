class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        int r=mat.length;
		int c=mat[0].length;
		int row1=0;
		int row2=r-1;
		int col1=c-1;
		int col2=0;
		int num=0;
        List<Integer>ans=new ArrayList<>();
		while(row1<=row2 && col2<=col1){
			for(int i=row1;i<=col1;i++){
			ans.add(mat[row1][i]);
			num=1;
		}
		if(num==1){
		for(int i=row1+1;i<=row2;i++){
			ans.add(mat[i][col1]);
			num=2;
		}
			
			
		}
		if(num==2){
		for(int i=col1-1;i>=col2;i--){
			ans.add(mat[row2][i]);
		
			num=3;
		}}
		if(num==3){
		for(int i=row2-1;i>row1;i--){
			ans.add(mat[i][col2]);
		}}
		
			
			row1++;
			row2--;
			col1--;
			col2++;
		}
       return ans;
		
		
         
     
    }
}