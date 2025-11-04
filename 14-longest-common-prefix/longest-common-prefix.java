class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String pref = strs[0];

        for(int i =0;i<n;i++){
            while(!strs[i].startsWith(pref)){
                //0 to n -1 will be the indexing so use this will remove last character every time 
                pref = pref.substring(0,pref.length()-1);
            }
        }
        return pref;
    }
}