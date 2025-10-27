class Solution {
    public void findComb(int[] candidates,int target,List<List<Integer>> res,List<Integer> local,int idx){
        if(idx == candidates.length){
            if(target == 0){
                res.add(new ArrayList<>(local));
                return;
            }
            return;
        }
        if(candidates[idx] <= target){
            local.add(candidates[idx]);
            findComb(candidates,target - candidates[idx],res,local,idx);
            local.remove(local.size()-1);
        }
        findComb(candidates,target,res,local,idx+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> local = new ArrayList<>();

        findComb(candidates,target,res,local,0);
        return res;
    }
}