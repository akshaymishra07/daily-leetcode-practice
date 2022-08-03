class Dll{
    int key;
    int val;
    Dll prev;
    Dll next;
    
    Dll(int key, int val){
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
    
    Dll(){
        
    }
}
class LRUCache {

    public void addNode(Dll node){
        
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;   
    }
    
    public void removeNode(Dll node){
        Dll pre = node.prev;
        Dll nxt = node.next;
        
        pre.next = nxt;
        nxt.prev = pre;
    }
    
    public void moveToHead(Dll node){
        removeNode(node);
        addNode(node);
    }
    
    public Dll popTail(){
        
        Dll temp = tail.prev;
        removeNode(temp);
        return temp;
    }
    
    HashMap<Integer, Dll> map;
    Dll head, tail;
    int count;
    int capacity;
    
    public LRUCache(int capacity) {
        
        map = new HashMap<>();
        count = 0;
        this.capacity = capacity;
        
        head = new Dll();
        head.prev = null;
        
        tail = new Dll();
        tail.next = null;
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        Dll node = map.get(key);
        
        if(node ==  null){
            return -1;
        }

        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        
        
        Dll node = map.get(key);
        
        if(node == null){
            
            Dll newNode = new Dll(key, value);
            addNode(newNode);
            map.put(key, newNode);
            count++;
            
            if(count > capacity){
                Dll tail = popTail();
                map.remove(tail.key);
                count--;
            }
            
        }else{
            
            node.val = value;
            moveToHead(node);
        }
        
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */