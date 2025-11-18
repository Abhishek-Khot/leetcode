class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        //approach one 
        //if 1 comes make a pair and push the i by 2 and if 0 comes skip
        //at the end always there will be 0 
        //if your i stops at last index of bits array then all ones has make pairs . no matter what is 
        //coming after one 
        int n = bits.length;
        int i = 0;
        while(i < n - 1){
            if(bits[i] == 1){
                i+=2;
            }
            else{
                i++;
            }
        }
        return i == n - 1;
    }
}