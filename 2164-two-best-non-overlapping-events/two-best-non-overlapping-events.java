// notes in the dsa notes folder
// intervals so use sorting
// take and not take dp 
class Solution {
    public int n;
    public int dp[][];
    // lower bound of the events to get the 
    public int find(int events[][],int endTime){
        int res = n; // so that i will not accept if not found due to base case
        int low =  0;
        int high = n - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(events[mid][0] > endTime){
                res = mid;
                high = mid - 1;
            }
            else{
                low = mid +1;
            }
        }
        return res;

    }
    public int solve(int[][] events,int idx,int count){
        if(count == 2 || idx >= n){
            return 0;
        }
        if(dp[idx][count] != -1){
            return dp[idx][count];
        }
        int nextValidIndex = find(events,events[idx][1]);// want the next event after first event ends

        int take = events[idx][2] + solve(events,nextValidIndex,count+1);
        int not_take = solve(events,idx+1,count);

        return dp[idx][count] = Math.max(take,not_take);
    }
    public int maxTwoEvents(int[][] events) {
        n = events.length;
        dp = new int[100001][2];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        return solve(events,0,0);
    }
}