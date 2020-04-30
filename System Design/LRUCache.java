class LRUCache {

    class DLL
    {
        int key;
        int val;
        DLL prev;
        DLL next;
    }
    
    DLL head = null , tail = null;
    int cap;
    Map<Integer, DLL> map;
    int currSize;
    
    public LRUCache(int capacity) {
        
        cap = capacity;
        currSize = 0;
        head = new DLL();
        tail = new DLL();
        
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        
        DLL node = map.get(key);
        if ( node != null )
        {
            moveToFirst(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        
        DLL node = map.get(key);
        if ( node != null  )
        {
            remove(node);
            node.val = value;
            insertAtHead(node);
            map.put(key, node);
        }
        else
        {
            DLL newNode = new DLL();
            newNode.key = key;
            newNode.val = value;

            if ( currSize == cap )
            {
                map.remove( tail.prev.key );
                remove( tail.prev );
                currSize--;
            }
            insertAtHead( newNode );
            map.put(key, newNode);
            currSize++;
        }
    }
    
    void insertAtHead( DLL node )
    {
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }
    
    void moveToFirst( DLL node )
    {
        remove(node);
        insertAtHead(node);
    }
    
    void remove( DLL node )
    { 
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */