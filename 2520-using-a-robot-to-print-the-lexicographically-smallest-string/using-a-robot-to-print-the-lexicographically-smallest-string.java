class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        Stack<Character> t = new Stack<>();
        StringBuilder paper = new StringBuilder("");
        char visitedRight[] = new char[n];
        char minchar = s.charAt(n - 1);
        visitedRight[n - 1] = s.charAt(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch < minchar) {
                minchar = ch;
            }
            visitedRight[i] = minchar;
        }
        int i = 0;
        while (i < n) {
            t.push(s.charAt(i));
            char minChar = ((i + 1) < n) ? visitedRight[i + 1] : s.charAt(i);
            while (!t.isEmpty() && t.peek() <= minChar) {
                paper.append(t.pop());
            }
            i++;
        }
        while (!t.isEmpty()) {
            paper.append(t.pop());
        }
        return paper.toString();
    }
}