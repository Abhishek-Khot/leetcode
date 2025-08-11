class Solution {
    public int M = (int)1e9+7;
    public int[] productQueries(int n, int[][] queries) {
        // int ans[] = new int
        List<Integer> power = new ArrayList<>();
        //32 bits integer size
        for(int i = 0;i<=32;i++){
            if(((n & (1 << i)) != 0)){
                power.add(1 << i);
            }
        }
        int ans[] = new int[queries.length];
        int k = 0;
        for(int query[] : queries){
            int start = query[0];
            int end = query[1];
            long product = 1;
            for(int i = start;i<=end ;i++){
                product = (product * power.get(i)) % M;
            }
            ans[k++] = (int)product;
        }
        return ans;
    }
}