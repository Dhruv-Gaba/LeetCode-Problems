class ProductOfNumbers {
    List<Integer> list;
    List<Integer> prefixProd;
    public ProductOfNumbers() {
        list=new ArrayList<>();
        prefixProd=new ArrayList<>();
    }
    
    public void add(int num) {
        list.add(num);
        if(num==0){
            prefixProd.clear();
        }else{
            if(prefixProd.isEmpty()){
                prefixProd.add(num);
            }else{
                prefixProd.add(prefixProd.get(prefixProd.size()-1)*num);
            }
        }
    }
    
    public int getProduct(int k) {
        int n=prefixProd.size();
        if(n==k){
            return prefixProd.get(n-1);
        }
        else if(k>n){
            return 0;
        }
        else{
            return prefixProd.get(n-1)/prefixProd.get(n-1-k);
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
