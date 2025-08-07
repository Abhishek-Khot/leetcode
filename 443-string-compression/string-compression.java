class Solution {
    //two pointer i and index just dry run 
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int index = 0;
        while (i < n) {
            char curr_char = chars[i];
            int count = 0;
            while (i < n && curr_char == chars[i]) {
                i++;
                count++;
            }
            chars[index] = curr_char;
            index++;
            //if count is two digit 
            String str = String.valueOf(count);
            //if count is 1 then no need to do that 
            if (count > 1) {
                for (char ch : str.toCharArray()) {
                    chars[index] = ch;
                    index++;
                }
            }
        }
        return index;
    }
}