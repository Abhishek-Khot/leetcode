class Solution {
    public int possibleStringCount(String word) {
        //the previous is same and curr then count++
        int n = word.length(),count = 0;
        for(int i = 1;i< n;i++){
            if(word.charAt(i-1) == word.charAt(i)){
                count++;
            }
        }
        return count+1;//+1 for the original string
    }
}