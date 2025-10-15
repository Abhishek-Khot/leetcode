// class Solution {
//     public boolean isIncreasing(List<Integer> nums,int k){
//         int knew = k -1;
//         if(knew == 0) return true;
//         for(int i = k + 1;i<nums.size();i++){
//             if(nums.get(i) > nums.get(i-1) && nums.get(i-k) > nums.get(i-k-1)){
//                 knew--;
//             }
//             else{
//                 knew = k -1;
//             }
//             if(knew == 0){
//                 return true;
//             }
//         }
//         return false;
//     }
//     public int maxIncreasingSubarrays(List<Integer> nums) {
//         int max = 1;
//         int n = nums.size();
//         int k = 1;

//         while(k < n){
//             if(isIncreasing(nums,k)){
//                 max = Math.max(k,max);
//             }
//             k++;
//         }
//         return max;
//     }
// }
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int up = 1, preUp = 0, res = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                up++;
            } else {
                preUp = up;
                up = 1;
            }
            int half = up >> 1;
            int min = preUp < up ? preUp : up;
            int candidate = half > min ? half : min;
            if (candidate > res)
                res = candidate;
        }
        return res;
    }
}
