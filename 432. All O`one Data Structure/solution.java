class Node{
    int freq;
    Node next;
    Node prev;
    Set<String> keys=new HashSet<>();

    Node(int freq){
        this.freq=freq;
    }
}

class AllOne {
    HashMap<String,Node> map;
    Node head;
    Node tail;
    public AllOne() {
        map=new HashMap<>();
        head=new Node(0);
        tail=new Node(0);
        head.next=tail;
        tail.prev=head;
    }
    
    public void inc(String key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.keys.remove(key);
            int freq=node.freq;
            Node nextNode=node.next;
            if(nextNode==tail || nextNode.freq!=freq+1){
                Node newNode=new Node(freq+1);
                newNode.keys.add(key);
                newNode.next=nextNode;
                newNode.prev=node;
                node.next=newNode;
                nextNode.prev=newNode;
                map.put(key,newNode);
            }
            else{
                nextNode.keys.add(key);
                map.put(key,nextNode);
            }
            if(node.keys.isEmpty()){
                removeNode(node);
            }
        }else{
            Node firstNode=head.next;
            if(firstNode==tail || firstNode.freq>1){
                Node newNode=new Node(1);
                newNode.keys.add(key);
                newNode.next=firstNode;
                newNode.prev=head;
                head.next=newNode;
                firstNode.prev=newNode;
                map.put(key,newNode);
            }
            else{
                firstNode.keys.add(key);
                map.put(key,firstNode);
            }
        }
    }
    
    public void dec(String key) {
        Node node=map.get(key);
        node.keys.remove(key);
        int freq=node.freq;
        if(freq==1){
            map.remove(key);
        }
        else{
            Node prevNode=node.prev;
            if(prevNode==head || prevNode.freq!=freq-1){
                Node newNode=new Node(freq-1);
                newNode.keys.add(key);
                newNode.next=node;
                newNode.prev=prevNode;
                prevNode.next=newNode;
                node.prev=newNode;
                map.put(key,newNode);
            }
            else{
                prevNode.keys.add(key);
                map.put(key,prevNode);
            }
        }
        if(node.keys.isEmpty()){
            removeNode(node);
        }
    }
    
    public String getMaxKey() {
        if(tail.prev==head){
            return "";
        }
        return tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        if(head.next==tail){
            return "";
        }
        return head.next.keys.iterator().next();
    }

    public void removeNode(Node node){
        Node nextNode=node.next;
        Node prevNode=node.prev;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
