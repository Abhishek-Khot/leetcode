class Solution {
    public static int[] findL(int height[]){
        int n = height.length;
        int left[] = new int[n];
        left[0] = height[0];
        for(int i = 1;i<n;i++){
            left[i] = Math.max(left[i-1],height[i]);
        }
        return left;
    }
    public static int[] findR(int height[]){
        int n = height.length;
        int right[] = new int[n];
        right[n-1] = height[n-1];
        for(int i = n-2;i>=0;i--){
            right[i] = Math.max(right[i+1],height[i]);
        }
        return right;
    }
    public int trap(int[] height) {
        int left[] = findL(height);
        int right[] = findR(height);
        int sum = 0;
        int n = height.length;
        for(int i = 0;i<n;i++){
            int water = Math.min(left[i],right[i]);
            sum+=(water-height[i]);
        }
        return sum;
    }
}