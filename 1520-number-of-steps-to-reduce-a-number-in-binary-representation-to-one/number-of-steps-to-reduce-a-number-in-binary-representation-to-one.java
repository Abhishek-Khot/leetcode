class Solution {
    public int numSteps(String s) {
        // if the number is even then just pop last element == divide by 2
        // for odd search for first zero from last make it 1 and other elements zero


        // conclusion 
        // for odd we need two operations -> change it to zero then pop
        // for even only pop only one operation

        // carry try it for 1101 then you will get to know this issue of carry 
        int n = s.length();
        int operations = 0;
        int carry = 0;

        for(int i = n-1;i>=1;i--){

            if((s.charAt(i)-'0') + carry % 2 == 1){
                operations+=2;
                carry = 1;
            }
            else{
                operations++;
            }
        }
        return operations + carry;// last carry if it is remaining
    }
}