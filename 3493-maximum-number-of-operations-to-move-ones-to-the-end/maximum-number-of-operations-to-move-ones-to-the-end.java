class Solution {
    public int maxOperations(String s) {
        //simple observation
        //see how many ones are coming before zero add them if zero continuous move 
        int res = 0;
        int countOf1 = 0;
        int n = s.length();
        int i =0;
        while(i < n){
            char ch = s.charAt(i);
            if(ch == '0'){
                res+=countOf1;
                while(i < n && s.charAt(i) == '0'){
                    i++;
                }
            }
            else{
                countOf1++;
                i++;
            }
        }
        return res;
    }
}