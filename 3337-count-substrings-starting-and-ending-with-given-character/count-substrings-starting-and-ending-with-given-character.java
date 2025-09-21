class Solution {
    public long countSubstrings(String s, char c) {
        // long res = 0;
        long count = 0;
        int n = s.length();
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == c)count++;
        }
        return count * (count +1 )/2;
    }
}