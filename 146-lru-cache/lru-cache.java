class LRUCache {

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.cache = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {

        Node previous = node.prev;
        Node next = node.next;

        previous.next = next;
        next.prev = previous;
    }

    private void addToFront(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {

        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);

        remove(node);
        addToFront(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {

            Node node = cache.get(key);

            remove(node);

            node.value = value;

            addToFront(node);

            return;
        }

        Node node = new Node(key, value);

        cache.put(key, node);
        addToFront(node);

        if (cache.size() > capacity) {

            Node lru = tail.prev;

            remove(lru);

            cache.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */