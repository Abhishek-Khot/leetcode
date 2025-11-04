class Solution {
    public void findSubsets(int[] nums,List<List<Integer>> res,List<Integer> local,int idx){
        if(idx == nums.length){
            res.add(new ArrayList<>(local));
            return;
        }
        local.add(nums[idx]);
        findSubsets(nums,res,local,idx+1);
        local.remove(local.size()-1);
        findSubsets(nums,res,local,idx+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int idx = 0;
        List<Integer> local = new ArrayList<>();
        findSubsets(nums,res,local,idx);
        return res;
    }
}