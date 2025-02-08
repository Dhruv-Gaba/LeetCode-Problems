class NumberContainers {
    Map<Integer,Integer> map;
    Map<Integer,PriorityQueue<Integer>> integerToIndices;
    public NumberContainers() {
        map=new HashMap<>();
        integerToIndices=new HashMap<>();
    }
    
    public void change(int index, int number) {
        map.put(index,number);
        integerToIndices.computeIfAbsent(number,k->new PriorityQueue<>()).add(index);
    }
    
    public int find(int number) {
        if(integerToIndices.containsKey(number)){
            PriorityQueue<Integer> pq=integerToIndices.get(number);
            while(!pq.isEmpty() && map.get(pq.peek())!=number){
                pq.poll();
            }
            if(pq.isEmpty()){
                integerToIndices.remove(number);
                return -1;
            }
            return pq.peek();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
