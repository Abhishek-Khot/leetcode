class Solution {
    public String findTheDerivative(Set<String> set,String word){
        //if substring present in set then root else word
        for(int i = 1;i<=word.length();i++){
            String root = word.substring(0,i);
            if(set.contains(root)){
                return root;
            }
        }
        return word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);
        StringBuilder res = new StringBuilder("");
        String words[] = sentence.split(" ");
        for(String word : words){
            res.append(findTheDerivative(set,word)).append(" ");
        }
        return res.toString().trim();
    }
}