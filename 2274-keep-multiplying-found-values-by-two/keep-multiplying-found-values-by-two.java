class Solution {
    public int findFinalValue(int[] nums, int original) {
        // HashSet<Integer> set = new HashSet<>();
        boolean vis[] = new boolean[1001];
        for(int num : nums){
            vis[num] = true;
        }
        while(original <= 1000 && vis[original]){
            original *= 2;
        }
        return original;
    }
}