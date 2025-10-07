class Solution {
    public boolean canArrange(int[] arr, int k) {
        //approach is like two numbers num1 and num2 remainder sum is equal to k 
        //we break the problem into two sum 
        //we will store pair and check matching using map
        int map[] = new int[k];//remainder will in the range 0 to k -1 
        for(int num : arr){
            // int rem = num % k;
            //handle negative also
            int rem = (num % k + k) % k;
            map[rem]++;
        }
        //0 pairs with k always and k can be the remainder so 0 frequency should be even
        if(map[0] % 2 != 0){
            return false;
        }
        //counter part matching so half check is enough 
        for(int rem = 1;rem<=k/2;rem++){
            int counterPart = k - rem;
            if(map[counterPart]!= map[rem]){
                return false;
            }
        }
        return true;
    }
}