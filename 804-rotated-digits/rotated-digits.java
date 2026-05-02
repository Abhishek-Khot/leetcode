class Solution {
    public boolean isGood(int num){
        boolean isGoodBB = false;
        while(num > 0){
            int lastDigit = num % 10;
            if(lastDigit == 3 || lastDigit == 4 || lastDigit == 7){
                return false;
            }
            if(lastDigit == 2 || lastDigit == 5 || lastDigit == 6 || lastDigit == 9){
                isGoodBB = true;
            }
            num = num / 10;
        }
        return isGoodBB;
    }
    public int rotatedDigits(int n) {
        int count = 0;
        for(int i = 0;i<=n;i++){
            if(isGood(i)){
                count++;
            }
        }
        return count;
    }
}