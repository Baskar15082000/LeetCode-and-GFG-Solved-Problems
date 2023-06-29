class SnapshotArray {
    HashMap<Integer,Integer>[] arr;
    int snapid;

    public SnapshotArray(int length) {
        arr=new HashMap[length];
        snapid=0;
    }
    
    public void set(int index, int val) {
        if(arr[index]==null){
            arr[index]=new HashMap<>();
        }
        arr[index].put(snapid,val);
    }
    
    public int snap() {
        int snap=snapid;
        snapid++;
        return snap;
    }
    
    public int get(int index, int snap_id) {
        if(arr[index]==null)return 0;
        while(snap_id>=0 && arr[index].containsKey(snap_id)==false){
            snap_id--;
        }
        if(snap_id==-1) return 0;
        return arr[index].get(snap_id);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */