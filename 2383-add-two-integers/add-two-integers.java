class Solution {
    public int sum(int num1, int num2) {
        if(num1 > 0 && num2 > 0){
            if(num2 == 0)        {
            return num1;
        }
        return sum(num1 +1, num2 - 1);
        }
        return num1+num2;
    }
}