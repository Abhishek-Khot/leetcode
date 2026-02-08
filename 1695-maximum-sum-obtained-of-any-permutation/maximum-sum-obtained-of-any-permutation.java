class Solution {
    public int M = (int)1e9+7;
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        // difference array techinque 
        // max result- element which comes many times i will put max element there 
        // query 
        // 1 to 4
        // 1 to 2
        // 0 1 2 3 4  5 
        // +1 +1 -1 0 -1 
        // []
        int n = nums.length;
        Integer num[] = new Integer[n];
        for(int i = 0;i<n;i++){
            num[i] = nums[i];
        }
        Integer event[] = new Integer[n];
        Arrays.fill(event,0);

        for(int req[] : requests){
            int start = req[0];
            int end = req[1];

            event[start] += 1;
            if(end +1 < n){
                event[end+1] -= 1; // end +1 because include last element also
            }
        }
        // find cummulative sum 
        // 1 2 1 1 0 
        for(int i = 1;i<n;i++){
            event[i] += event[i-1];
        }
        // sort both in descending order
        
        Arrays.sort(event,Collections.reverseOrder());
        Arrays.sort(num,Collections.reverseOrder());

        long sum = 0;
        for(int i = 0;i<n;i++){
            sum = (sum + (long)event[i] * num[i]) % M;
        }
        return (int)sum;

    }
}