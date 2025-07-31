class Solution {
    public String breakPalindrome(String palindrome) {
        //three variations
        //aaaa -> make last b
        //abccba -> first non a make it b
        //aabaa -> odd length middle no change last make it b
        //traverse n/2 it will handle the above two conditions
        int n = palindrome.length();
        if(n == 1){
            return "";
        }
        char arr[] = palindrome.toCharArray();
        for(int i = 0;i<n/2;i++){
            char ch = arr[i];
            if(ch != 'a'){
                arr[i] = 'a';
                return String.valueOf(arr);
            }
        }
        arr[n-1] = 'b';
        return String.valueOf(arr);
    }
}