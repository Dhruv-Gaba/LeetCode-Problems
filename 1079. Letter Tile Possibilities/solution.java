class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> sequences = new HashSet<>();
        boolean[] used=new boolean[tiles.length()];
        generateSequences(tiles,new StringBuilder(),sequences,used);
        return sequences.size()-1;
    }
    public void generateSequences(String tiles,StringBuilder sb,Set<String> sequences,boolean[] used){
        sequences.add(sb.toString());
        for(int i=0;i<tiles.length();i++){
            if(!used[i]){
                used[i]=true;
                sb.append(tiles.charAt(i));
                generateSequences(tiles,sb,sequences,used);
                sb.delete(sb.length()-1,sb.length());
                used[i]=false;
            }
        }
    }
}
