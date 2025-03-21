class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> set=new HashSet<>(Arrays.asList(supplies));
        HashSet<String> ans=new HashSet<>();
        boolean added=true;
        while(added){
            added=false;
            for(int i=0;i<recipes.length;i++){
                if(ans.contains(recipes[i]))continue;
                List<String> ingredient=ingredients.get(i);
                boolean canMake=true;
                for(int j=0;j<ingredient.size();j++){
                    if(!set.contains(ingredient.get(j))){
                        canMake=false;
                        break;
                    }
                }
                if(canMake){
                    ans.add(recipes[i]);
                    set.add(recipes[i]);
                    added=true;
                }
            }
        }
        List<String> result=new ArrayList<>(ans);
        return result;
    }
}
