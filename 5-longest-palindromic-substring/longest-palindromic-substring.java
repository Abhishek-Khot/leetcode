class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int n = s.length();
        int resLen = 0;
        //expanding from the middle
        for(int i = 0;i<n;i++){
            int low = i;
            int high = i;
            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)){
                //if new length string comes or found
                if(resLen <(high - low + 1)){
                    res = s.substring(low,high+1);//bcz exclude the last character 
                    resLen = high - low +1;
                }
                low--;
                high++;
            }
            low = i;
            high = i+1;
            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)){
                //if new length string comes or found
                if(resLen <(high - low + 1)){
                    res = s.substring(low,high+1);//bcz exclude the last character 
                    resLen = high - low +1;
                }
                low--;
                high++;
            }
        }
        return res;
        
    }
}