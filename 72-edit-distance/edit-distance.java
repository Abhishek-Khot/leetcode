class Solution {
    public int dp[][];
    public int solve(String word1,String word2,int i,int j){
        // if the word2 is out of bound then word1 delete m - i
        if(j == word2.length()){
            return word1.length() - i;
        }
        // if word1 is out of bound then insert n - j 
        else if(i == word1.length()){
            return word2.length() - j;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        // both chars are same just move to next no need to anything
        if(word1.charAt(i) == word2.charAt(j)){
            return solve(word1,word2,i+1,j+1);
        }
        // if both are different try each operation -> take minimum
        else{
            int insertChar = 1 + solve(word1,word2,i,j+1);// insert then i will stay there match j move 1 place
            int deleteChar = 1 + solve(word1,word2,i+1,j);// delete char from word1 then just move i
            int replaceChar = 1 + solve(word1,word2,i+1,j+1);// making both same move both

            return dp[i][j] = Math.min(insertChar,Math.min(deleteChar,replaceChar));
        }
    }
    public int minDistance(String word1, String word2) {
        // Easy 
        // Tree Daigram 
        int m = word1.length();
        int n = word2.length();
        dp = new int[m+1][n+1];
        for(int d[]: dp){
            Arrays.fill(d,-1);
        }
        return solve(word1,word2,0,0);
    }
}