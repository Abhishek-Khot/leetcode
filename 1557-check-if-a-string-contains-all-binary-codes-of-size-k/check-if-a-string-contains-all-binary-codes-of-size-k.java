class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int possible = (int)Math.pow(2,k);
        Set<String> st = new HashSet<>();

        for(int i = 0;i<n-k+1;i++){
            st.add(s.substring(i,i+k));
        }
        return st.size() == possible;
    }
}