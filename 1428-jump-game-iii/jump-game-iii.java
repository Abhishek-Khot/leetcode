class Solution {
    public int n;
    public boolean dfs(int arr[],int i){
        if(i < 0 || i >= n || arr[i]< 0){
            // if the arr[i] is negative means it is visited and one time visiting so no memorization needed
            return false;
        }
        
        if(arr[i] == 0){
            return true;
        }
        // once visited then mark it as negative or use visited array to store it is visited 
        arr[i] *= -1;
        boolean back = dfs(arr,i-arr[i]);
        boolean forth = dfs(arr,i+ arr[i]);
        return back || forth;
    }
    public boolean canReach(int[] arr, int start) {
        n = arr.length;

        return dfs(arr,start);
    }
}