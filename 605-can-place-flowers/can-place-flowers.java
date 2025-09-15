class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if(n == 0)return true;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                boolean leftCheck = (i == 0) || (flowerbed[i - 1] == 0);//if i is zero then just check for right
                boolean rightCheck = (i == len - 1) || (flowerbed[i + 1] == 0);//if i is zero then just check left part for below 

                if (leftCheck && rightCheck) {
                    flowerbed[i] = 1;
                    n--;
                    if (n == 0)
                        return true;
                }
            }
        }
        return false;
    }
}