class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder("");
        int n = s.length();

        Stack<Character> stk = new Stack<>();
        for(int i = 0;i< n;i++){
            char ch = s.charAt(i);
            if(!stk.isEmpty() && ch == '*'){
                stk.pop();
            }
            if(ch != '*'){
                stk.push(ch);
            }
        }
        while(!stk.isEmpty()){
            sb.insert(0,stk.pop());
        }
        return sb.toString();
    }
}