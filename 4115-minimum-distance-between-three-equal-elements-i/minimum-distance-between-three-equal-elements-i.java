class Solution {
    // hint if you get any equation try to solve then use it 
    // j - i + (k - j)  +(k - i)
    // j cancel 
    // - i + k + k - i
    // 2(k - i)

    public int minimumDistance(int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            for(int j = i +1 ;j < n;j++){
            // two optimization if i and j th elt is not equal just continue no need to run k th loop
                if(nums[i] != nums[j]) continue;
                for(int k = j +1 ;k<n;k++){
                    if(nums[i]== nums[j] && nums[j] == nums[k]){
                        res = Math.min(2 * (k - i),res);
                    break;// so if k goes then dist increase no use of that 
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}