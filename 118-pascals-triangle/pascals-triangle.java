class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i =0;i<numRows;i++){
            ArrayList<Integer> local = new ArrayList<>();
            for(int j =0;j<=i;j++){
                if(j ==0||i==j){
                    local.add(1);
                }
                else{
                    local.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
            }
            res.add(new ArrayList<>(local));
        }
        return res;
    }
}