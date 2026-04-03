class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stk = new Stack<>();

        // stack is for positive and for neg iterate 
        for(int asteroid : asteroids){
            // one is neg and pos destory if destory then pop or change it to 0
            while(!stk.isEmpty() && asteroid < 0 && stk.peek() > 0){
                int sum = asteroid + stk.peek();
                // if direction is left just pop from stack
                if(sum < 0){
                    stk.pop();
                }
                // positive means right direction asteroid destory 
                else if(sum > 0){
                    asteroid = 0;
                    // break;
                }
                // if its zero 
                else {
                    stk.pop();
                    asteroid = 0;
                }
            }
            if(asteroid != 0){
                stk.push(asteroid);
            }
        }
        int resSize = stk.size();
        int res[] = new int[resSize];
        int k = resSize - 1;
        while(!stk.isEmpty()){
            res[k--] = stk.pop();
        }
        return res;
    }
}