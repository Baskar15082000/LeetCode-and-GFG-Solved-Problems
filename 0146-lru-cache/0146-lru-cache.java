class LRUCache {
    int cap;
    LinkedHashMap<Integer,Integer> cache;

    public LRUCache(int capacity) {
        this.cap=capacity;
        cache=new LinkedHashMap<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        int val=cache.get(key);
        cache.remove(key);
        cache.put(key,val);
        return val;
       
    }
    
    public void put(int key, int value) {
         if(cache.containsKey(key)){
             cache.remove(key);
             cache.put(key,value);
             return ;
         }
         if(cache.size()>=cap){
             int deletekey=cache.keySet().iterator().next();
             cache.remove(deletekey);
         }
        cache.put(key,value);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */