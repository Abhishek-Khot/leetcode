class Solution {
    public void swap(int avail[],int i ,int j){
        int temp = i;
        avail[i] = avail[j];
        avail[j] = temp;
    }
    public int minSwaps(int[][] grid) {
        //story points
        //1. find the number of zeros in each row from the end
        //2. check for the need of zeros n - row -1
        // 3. if not meet number of zero -1
        //4 calculate stesp by doing j - i
        int n = grid.length;
        int avail[] = new int[n];
        for(int i= 0;i<n;i++){
            int j = n-1;
            int count = 0;
            while(j >= 0 && grid[i][j] == 0){
                count++;
                j--;
            }
            avail[i] = count;
        }

        int steps = 0;
        for(int i = 0;i<n;i++){
            int j = i;// start from i if i itself has need number of zeros 
            int need = n - i -1;
            while(j < n && avail[j] < need){
                j++;
            }
            if(j == n){
                return -1;
            }
            steps += j - i;

            //swapping of inner loop
            // i am on j so swap from i to j start with last come to first 
            while(j > i){
                swap(avail,j,j-1);
                j--;
            }

        }
        return steps;
    }
}