class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            this.prev=null;
            this.next=null;
        }
    }
    Node head;
    Node tail;
    int capacity;
    Map<Integer,Node> map;
    public LRUCache(int capacity) {
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
        map=new HashMap<>();
        this.capacity=capacity;
    }
    public void deleteNode(Node node){
        Node prev=node.prev;
        Node next=node.next;
        prev.next=next;
        next.prev=prev;
    }
    public void addAfterHead(Node node){
        Node next=head.next;
        head.next=node;
        node.next=next;
        next.prev=node;
        node.prev=head;
    }
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node=map.get(key);
        deleteNode(node);
        addAfterHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            deleteNode(node);
            addAfterHead(node);
        }else{
            Node newNode=new Node(key,value);
            if(map.size()==capacity){
                Node node=tail.prev;
                map.remove(node.key);
                deleteNode(node);
            }
            addAfterHead(newNode);
            map.put(key,newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
