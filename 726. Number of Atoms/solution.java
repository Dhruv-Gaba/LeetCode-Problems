class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String,Integer>> stack=new Stack<>();
        stack.push(new HashMap<>());
        int i=0;
        while(i<formula.length()){
            if(formula.charAt(i)=='('){
                stack.push(new HashMap<>());
                i++;
            }
            else if(formula.charAt(i)==')'){
                Map<String,Integer> currMap=stack.pop();
                i++;
                StringBuilder multiply=new StringBuilder();
                while(i<formula.length() && Character.isDigit(formula.charAt(i))){
                    multiply.append(formula.charAt(i));
                    i++;
                }
                if(multiply.length()>0){
                    int m=Integer.parseInt(multiply.toString());
                    for(String atom:currMap.keySet()){
                        currMap.put(atom,currMap.get(atom)*m);
                    }
                }
                for(String atom:currMap.keySet()){
                    stack.peek().put(atom,stack.peek().getOrDefault(atom,0)+currMap.get(atom));
                }
            }
            else{
                StringBuilder currAtom=new StringBuilder();
                currAtom.append(formula.charAt(i));
                i++;
                while(i<formula.length() && Character.isLowerCase(formula.charAt(i))){
                    currAtom.append(formula.charAt(i));
                    i++;
                }
                StringBuilder currCount=new StringBuilder();
                while(i<formula.length() && Character.isDigit(formula.charAt(i))){
                    currCount.append(formula.charAt(i));
                    i++;
                }
                int count=currCount.length()>0?Integer.parseInt(currCount.toString()):1;
                stack.peek().put(currAtom.toString(),stack.peek().getOrDefault(currAtom.toString(),0)+count);
            }
        }
        TreeMap<String,Integer> finalMap=new TreeMap<>(stack.peek());
        StringBuilder ans=new StringBuilder();
        for(String atom:finalMap.keySet()){
            ans.append(atom);
            if(finalMap.get(atom)>1){
                ans.append(finalMap.get(atom));
            }
        }
        return ans.toString();
    }
}
