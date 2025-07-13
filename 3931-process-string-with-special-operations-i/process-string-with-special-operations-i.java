class Solution {
    public String reverse(String sb){
        int start = 0;
        int end = sb.length() -1;
        char arr[] = sb.toCharArray();
        while(start < end){
            char ch = arr[start];
            arr[start]= arr[end];
            arr[end] = ch;
            start++;
            end--;
        }
        return String.valueOf(arr);
    }
    public String processStr(String s) {
        StringBuilder res = new StringBuilder("");

        int n = s.length();
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                if(res.length() > 0){
                    res.deleteCharAt(res.length() -1);
                }
            }
            else if(ch == '#'){
                res.append(res);
            }
            else if(ch == '%'){
                res = new StringBuilder(reverse(res.toString()));
            }

            else {
                res.append(ch);
            }
        }
        return res.toString();
    }
}