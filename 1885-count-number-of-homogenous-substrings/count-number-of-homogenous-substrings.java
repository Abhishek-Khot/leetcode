class Solution {
    public int mod = (int)1e9 + 7;
    public int countHomogenous(String s) {
        long res = 0;
        int n = s.length();
        int i = 0;

        while(i<n){
            // j start at i 
            int j = i; 
            while(j < n && s.charAt(i) == s.charAt(j)){
                j++;
            }
            int len = j - i;
            // res = (res+(long)(len * (len +1 )/2))% mod;
            res = (res + (long)len * (len + 1) / 2) % mod; 
            i = j;//i go to the next group
        }
        return (int)res;
    }
}