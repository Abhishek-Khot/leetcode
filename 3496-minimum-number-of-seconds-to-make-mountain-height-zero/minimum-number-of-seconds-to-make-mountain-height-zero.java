class Solution {
    // min of max -- binary search on answer
    public boolean check(long mid, int mountainHeight, int[] workerTimes) {
        long total = 0;
        for (int t : workerTimes) {
            // solve k(k+1)/2 * t <= mid
            long k = (long)((Math.sqrt(1 + 8.0 * mid / t) - 1) / 2);
            total += k;

            if (total >= mountainHeight) {
                return true;
            }
        }
        return total >= mountainHeight;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1;
        long right = (long)1e18;
        long res = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (check(mid, mountainHeight, workerTimes)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}