class StockSpanner {
    List<Integer> list;
    Stack<Integer> s;
    public StockSpanner() {
        this.list=new ArrayList<>();
        this.s=new Stack<>();
    }
    
    public int next(int price) {
        list.add(price);
        if(list.size()==1){
            s.push(0);
            return 1;
        }
        while(!s.isEmpty() && price>=list.get(s.peek())){
            s.pop();
        }
        if(s.isEmpty()){
            s.push(list.size()-1);
            return list.size();
        }else{
            int prevHigh=s.peek();
            s.push(list.size()-1);
            return list.size()-1-prevHigh;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
