public class Solution {
    public String longestPalindrome(String s) {
        //expanding outwards neetcode n ^ 2 solution
        int n = s.length();
        if(s == null || n < 1){
            return "";
        }
        String res = "";
        int resLen = 0;
        for(int i = 0;i<n;i++){
            //for the odd case
            int low = i, high = i;
            //expand the window to check for palindrome 
            while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){
                //once got the larger answer add to res and update the reslength
                if(resLen <(high - low +1)){
                    res = s.substring(low,high +1);
                    resLen = high - low + 1;
                }
                low--;
                high++;
            }
            //for the even case
            low = i ;
            high = i + 1;
            while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){
                //once got the larger answer add to res and update the reslength
                if(resLen <(high - low +1)){
                    res = s.substring(low,high +1);
                    resLen = high - low + 1;
                }
                low--;
                high++;
            }

        }
        return res;

    }
}