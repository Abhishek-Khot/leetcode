class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pref = strs[0];
        int n = strs.length;
        for(int i = 1;i<n;i++){
            while(!strs[i].startsWith(pref)){
                pref = pref.substring(0,pref.length()-1);
            }
        }
        return pref;
    }
}