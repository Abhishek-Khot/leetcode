class Solution {
    public boolean isPrime(int number){
        int count = 0;
        for(int i = 1;i<=50;i++){
            if(number % i == 0){
                count++;
            }
        }
        if(count == 2){
            return true;
        }
        return false;
    }
    public int setBits(int n){
        int count = 0;
        while(n != 0){
            int bitmask = n & 1;
            if(bitmask == 1){
                count++;
            }
            n =  n >> 1;
        }
        if(isPrime(count)){
            return 1;
        }
        return 0;
    }
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for(int i = left;i<= right;i++){
            count+= setBits(i);
        }
        return count;
    }
}