class Solution {
    public long countVowels(String word) {
        long res = 0;
        int n = word.length();
        for(int i =0;i<n;i++){
            char ch = word.charAt(i);
            if(ch =='a' || ch =='i' || ch == 'e' || ch =='o' || ch == 'u'){
                res+=(long)(i+1)*(n-i);//n - i will be the all possible substrings 
                //i+1 because of start point
            }
        }
        return res;
    }
}