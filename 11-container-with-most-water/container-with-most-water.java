class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int n = height.length;
        int i = 0;
        int j = n -1;
        while(i < j){
            int ht = Math.min(height[i],height[j]);
            int wt = j - i ;
            int currArea = ht * wt;
            res = Math.max(res,currArea);
            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return res;
    }
}