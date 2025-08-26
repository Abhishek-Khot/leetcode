class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        int maxDig = 0;
        int n = dimensions.length;
        for (int i = 0; i < n; i++) {
            int len = dimensions[i][1];
            int wid = dimensions[i][0];
            int dig = len * len + wid * wid;
            int currArea = len * wid;
            if (dig > maxDig) {
                maxDig = dig;
                maxArea = currArea;
            } else if (maxDig == dig)
                maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
}