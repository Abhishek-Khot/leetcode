class Solution {
    public int find(int[] tops, int[] bottoms,int tar_val){
        int count = 0;
        int swaptop = 0;
        int swapbottom = 0;
        for(int i =0;i<tops.length;i++){

            //invalid case
            if(tops[i] != tar_val && bottoms[i] != tar_val){
                return -1;
            }
            else if(tops[i] != tar_val){
                swaptop++;
            }
            else if(bottoms[i] != tar_val){
                swapbottom++;
            }
        }
        return Math.min(swaptop,swapbottom);
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = Integer.MAX_VALUE;
        for(int i=1;i<=6;i++){
            int ans = find(tops,bottoms,i);
            if(ans != -1){
                res = Math.min(res,ans);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}