class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int idx = 0;
        while(i < n){
            char curr = chars[i];
            int count = 0;
            while( i < n && curr == chars[i]){
                count++;
                i++;
            }
            chars[idx] = curr;
            idx++;

            String co = String.valueOf(count);
            if(count > 1){
                for(char ch : co.toCharArray()){
                    chars[idx] = ch;
                    idx++;
                }
            }
        }
        return idx;
    }
}