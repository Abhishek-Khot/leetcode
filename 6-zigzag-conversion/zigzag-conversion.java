class Solution {
    public String convert(String s, int numRows) {
        // easy it is i to newrows -1 then newrows -2 to 0 
        // P   I   N
        // A L S I G
        // Y A H R
        // P   I

        int n = numRows;

        String ans[] = new String[n];

        for(int i = 0;i<n;i++){
            ans[i] = "";
        }
        int len = s.length();
        int i = 0;
        while(i < len){
            for(int idx = 0;idx<n && i < len;idx++){
                ans[idx] += s.charAt(i);
                i++;
            }
            for(int idx = n - 2;idx> 0 && i < len;idx--){
                ans[idx] += s.charAt(i);
                i++;
            }
        }
        StringBuilder res = new StringBuilder("");
        for(String str : ans){
            res.append(str);
        }
        return res.toString();
    }
}