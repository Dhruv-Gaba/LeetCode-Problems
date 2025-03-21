class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> set=new HashSet<>(Arrays.asList(supplies));
        List<String> ans=new ArrayList<>();
        Map<String,Integer> recipeToIdx=new HashMap<>();
        for(int i=0;i<recipes.length;i++){
            recipeToIdx.put(recipes[i],i);
        }
        for(String recipe:recipes){
            if(canMake(recipe,set,ingredients,recipeToIdx,new HashSet<>())){
                ans.add(recipe);
            }
        }
        return ans;
    }
    public boolean canMake(String recipe,Set<String> set,List<List<String>> ingredients,Map<String,Integer> recipeToIdx, Set<String> visited){
        if(set.contains(recipe)){
            return true;
        }
        if(!recipeToIdx.containsKey(recipe) || visited.contains(recipe)){
            return false;
        }
        visited.add(recipe);
        List<String> ing=ingredients.get(recipeToIdx.get(recipe));
        for(String i:ing){
            if(!canMake(i,set,ingredients,recipeToIdx,visited)){
                return false;
            }
        }
        set.add(recipe);
        return true;
    }
}
