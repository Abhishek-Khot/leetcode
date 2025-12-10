class Solution {
    public int MOD = (int)1e9+7;
    public int countPermutations(int[] complexity) {
        // first will be unlocked 
        // check for com[0] >= comp[i] return 0 and for other n -1 options n-2 then n-3 goes on
        // per will be multiplication of those things (n-1)! because 1 is fixed  will be the answer
        long res = 1;
        int n = complexity.length;
        for(int i = 1;i<n;i++){
            if(complexity[0] >= complexity[i]){
                return 0;
            }
            res = res * i;
            res = res % MOD;
        }
        return (int)res;
    }
}