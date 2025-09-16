class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean map[] = new boolean[26];
        int n = brokenLetters.length();
        for (int i = 0; i < n; i++) {
            char ch = brokenLetters.charAt(i);
            map[ch - 'a'] = true;
        }
        int m = text.length();
        boolean flag = true;
        int count = 0;
        for (int i = 0; i < m; i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                if (flag == true) {
                    count++;
                }
                flag = true;
            } else {
                // if the word is present in the map means not typeable
                if (map[ch - 'a'] == true) {
                    flag = false;
                }

            }
        }
        //for the last word
        if(flag == true){
            count++;
        }
        return count;
    }
}