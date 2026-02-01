class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] log = new int[2051];

        for(int l[] : logs){
            int start = l[0];
            int end = l[1];
            log[start]++;
            log[end]--;
        }
        int max = 0;
        int curr = 0;
        int ans = 0;
        for(int i = 1950;i<=2050;i++){
            curr+=log[i];
            if(curr > max){
                max = curr;
                ans = i;
            }
        }
        return ans;
    }
}