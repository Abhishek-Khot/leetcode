class Solution {
    public int countPalindromicSubsequence(String s) {
        // we dont need to track middle character just check for the first and last characters are same or not
        HashSet<String> res = new HashSet<>();//for unique palindrome
        HashSet<Character> left = new HashSet<>();
        int right[] = new int[26];
        // left side character then right side character take middle pointer and check if left side character present 
        // in the right side if yes add into the result easy 
        // middle character is ch
        for(char ch : s.toCharArray()){
            right[ch-'a']++;
        }
        for(char ch : s.toCharArray()){
            right[ch - 'a']--;
            for(char c : left){
                if(right[c -'a'] > 0){
                    res.add(c + "_"+ ch);//left character and middle character we dont care about right bcz we check freq of right to do that 
                }
            }
            left.add(ch);
        }
        return res.size();
    }
}