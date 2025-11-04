class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int n = s.length();
        int resLen = 0;
        for(int i = 0;i<n;i++){
            int low = i;
            int high = i;
            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)){
                if(resLen < (high - low +1)){
                    ans = s.substring(low,high+1);//one is not takine
                    resLen = Math.max(resLen,(high-low +1));
                }
                low--;
                high++;
            }
            low = i;
            high = i+1;
            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)){
                if(resLen < (high - low +1)){
                    ans = s.substring(low,high+1);//one is not takine
                    resLen = Math.max(resLen,(high-low +1));
                }
                low--;
                high++;
            }
        }
        return ans;
    }
}