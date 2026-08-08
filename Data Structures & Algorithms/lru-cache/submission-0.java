class Node {
    int key, val;
    Node prev, next;
    
    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    private int cap;
    private HashMap<Integer, Node> cache;
    // dummy head and tail to avoid null checks
    private Node left, right;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap<>();
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }
    
    // remove node from doubly linked list
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    // insert node at the tail (most recent)
    private void insert(Node node) {
        Node prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);
        
        if (cache.size() > cap) {
            // least recently used is the node after dummy head
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}