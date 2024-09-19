class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans=new ArrayList<>();
        if(expression.length()==0){
            return ans;
        }
        if(expression.length()==1){
            ans.add(Integer.parseInt(expression));
            return ans;
        }
        if(expression.length()==2 && Character.isDigit(expression.charAt(0))){
            ans.add(Integer.parseInt(expression));
            return ans;
        }

        for(int i=0;i<expression.length();i++){
            char currChar=expression.charAt(i);
            if(Character.isDigit(currChar)){
                continue;
            }
            List<Integer> leftExp=diffWaysToCompute(expression.substring(0,i));
            List<Integer> rightExp=diffWaysToCompute(expression.substring(i+1));

            for(int leftVal:leftExp){
                for(int rightVal:rightExp){
                    int result=0;
                    switch (currChar){
                        case '+': 
                        result=leftVal+rightVal;
                        break;
                        case '-': 
                        result=leftVal-rightVal;
                        break;
                        case '*': 
                        result=leftVal*rightVal;
                        break;
                    }
                    ans.add(result);
                }
            }
        }
        return ans;
    }
}
