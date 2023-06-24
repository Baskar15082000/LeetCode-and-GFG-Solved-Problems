class LRUCache {
    int capacity;
    HashMap<Integer,Node>cache;
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    

    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache=new HashMap<>();
        head.next=tail;
        tail.pre=head;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node=cache.get(key);
            remove(node);
            insert(node);
            return node.data;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
          remove(cache.get(key));
          
        }
        if(capacity==cache.size()){
            remove(tail.pre);
        }
          
            Node newnode =new Node(key,value);
           
        insert(newnode);
    }
    public void insert(Node newnode){
        Node next=head.next;
        head.next=newnode;
        newnode.pre=head;
        newnode.next=next;
        next.pre=newnode;
        cache.put(newnode.key,newnode);
        
    }
     public void remove(Node newnode){
         
            newnode.pre.next=newnode.next;
            newnode.next.pre=newnode.pre;
            cache.remove(newnode.key);
    }
    class Node{
        Node next;
        Node pre;
        int key;
        int data;
        Node(int key,int data){
            this.key=key;
            this.data=data;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */