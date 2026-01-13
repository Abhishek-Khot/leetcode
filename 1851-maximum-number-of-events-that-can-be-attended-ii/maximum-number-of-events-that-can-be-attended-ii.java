class Solution {
    public int n;
    public int dp[][];

    public int getUpperBound(int events[][], int endTime, int low) {
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (events[mid][0] > endTime) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int solve(int events[][], int k, int idx) {
        if (idx >= n || k == 0) {
            return 0;
        }
        if (dp[idx][k] != -1) {
            return dp[idx][k];
        }
        int skip = solve(events, k, idx + 1);
        // O (n * k * logn)
        int j = getUpperBound(events, events[idx][1], idx + 1);
        // O( n * k * n)
        // for (; j < n; j++) {
        //     int end = events[idx][1];
        //     int newStart = events[j][0];
        //     if (newStart > end) {
        //         break;
        //     }
        // }
        int take = events[idx][2] + solve(events, k - 1, j);
        return dp[idx][k] = Math.max(skip, take);
    }

    public int maxValue(int[][] events, int k) {
        // take and skip sort as per the starting time 
        n = events.length;
        dp = new int[n + 1][k + 1];
        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int idx = 0;
        return solve(events, k, idx);
    }
}