class Solution {
    public int canCompleteCircuit(int[] A, int[] B) {
        int n=A.length;
        int gasfil=0;
		int gascost=0;
        for(int i=0;i<n;i++){
			gasfil+=A[i];
			gascost+=B[i];
		}
		if(gasfil<gascost)return -1;
		int st=-1;
		int tank=0;
		for(int i=0;i<n;i++){
			tank+=A[i];
			tank-=B[i];
			if(tank<0){
                st=-1;
				tank=0;
			}
			else if(st==-1){
				st=i;
			}
		}
		return st;
    }
}