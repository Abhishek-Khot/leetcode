class Solution {
    //contraints are small go with the brute force
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        int res = 0;

        for(int i= 0;i<n;i++){
            int vowel = 0;
            int consonent = 0;
            for(int j = i;j<n;j++){
                char ch = s.charAt(j);
                if(isVowel(ch)){
                    vowel++;
                }
                else{
                    consonent++;
                }
                if(vowel == consonent && (vowel * consonent % k == 0)){
                    res++;
                }
            }
        }
        return res;
    }
}