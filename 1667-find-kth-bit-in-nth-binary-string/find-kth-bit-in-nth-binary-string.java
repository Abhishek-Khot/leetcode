class Solution {
    public char findKthBit(int n, int k) {
        // so if answer lies in first half then solve(n-1,k) 
        // if k == middle then answer will be 1
        // second half then 
        // 0111001 then reverse then flipped . so reverse means k char will be n - k -1 both are same
        // for flippling just if else
        //base case changing variable n 
        if(n == 1){
            return '0';
        }

        int len = (int)Math.pow(2,n) - 1;// number of characters is 2 ^ n - 1
        //first half
        if(k < (int)Math.ceil(len/2.0)){
            return findKthBit(n-1,k);// kth bit in previous string
        }
        else if(k == (int)Math.ceil(len/2.0)){
            return '1';
        }
        else{
            //reverse then flipped
            char ch = findKthBit(n-1,len-k+1);
            return ch == '1' ? '0' : '1';
        }
    }
}