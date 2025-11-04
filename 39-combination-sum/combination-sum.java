class Solution {
    public void findSubsets(int[] candidates, int target, List<List<Integer>> res, List<Integer> local, int idx) {
        if (idx == candidates.length) {
            if (target == 0) {
                res.add(new ArrayList<>(local));
                return;
            }
            return;
        }
        if (candidates[idx] <= target) {
            local.add(candidates[idx]);
            findSubsets(candidates, target - candidates[idx], res, local, idx);
            local.remove(local.size() - 1);
        }
        findSubsets(candidates, target, res, local, idx + 1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> local = new ArrayList<>();
        int idx = 0;
        findSubsets(candidates, target, res, local, idx);
        return res;
    }
}
