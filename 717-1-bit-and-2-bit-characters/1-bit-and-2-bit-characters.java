class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        //approach one 
        //if 1 comes make a pair and push the i by 2 and if 0 comes skip
        //at the end always there will be 0 
        //if your i stops at last index of bits array then all ones has make pairs . no matter what is 
        //coming after one 
        // int n = bits.length;
        // int i = 0;
        // while(i < n - 1){
        //     if(bits[i] == 1){
        //         i+=2;
        //     }
        //     else{
        //         i++;
        //     }
        // }
        // return i == n - 1;
        //approach two 
        //if even number of ones are present then all ones make pair so return true else false
        int n = bits.length;
        int count = 0;
        //bits[i] == 1 is acting as break statment here 
        for(int i = n-2;i>=0 && bits[i] == 1;i--){
            // if(bits[i] == 1){
                count++;
            // }
        }
        return count % 2 == 0 ? true : false;
    }
}