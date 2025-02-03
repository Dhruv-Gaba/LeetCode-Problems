class MyCircularDeque {
    int deque[];
    int front;
    int rear;
    int size;
    public MyCircularDeque(int k) {
        deque=new int[k];
        front=-1;
        rear=-1;
        size=k;
    }
    
    public boolean insertFront(int value) {
        if(isEmpty()){
            front=rear=0;
            deque[front]=value;
            return true;
        }
        if(isFull()){
            return false;
        }
        if(front==0){
            front=size-1;
        }else{
            front--;
        }
        deque[front]=value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            front=rear=0;
            deque[front]=value;
            return true;
        }
        rear=(rear+1)%size;
        deque[rear]=value;
        return true;
        
    }
    
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        if(front==rear){
            front=rear=-1;
        }
        else{
            front=(front+1)%size;
        }
        return true;
        
    }
    
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        if(front==rear){
            front=rear=-1;
        }
        else if(rear==0){
            rear=size-1;
        }else{
            rear--;
        }
        return true;
        
    }
    
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return deque[front];
    }
    
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return deque[rear];
    }
    
    public boolean isEmpty() {
        return front==-1 && rear==-1;
    }
    
    public boolean isFull() {
        return (rear+1)%size==front;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
