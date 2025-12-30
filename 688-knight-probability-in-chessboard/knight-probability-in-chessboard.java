class Solution {
    // if going out of bound then return 0 
    // if inside and done with all k moves return 1 
    // return combined answer 
    public int bound;
    public int directions[][] = {{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    public HashMap<String,Double> map;
    public double solve(int k,int i,int j){
        if(i < 0 || i > bound-1 || j <0 || j > bound-1 ){
            return 0;
        }
        if(k == 0){
            return 1;
        }
        String key = k +"$"+i +"$"+j +"$";
        if(map.containsKey(key)){
            return map.get(key);
        }
        double ans = 0.0;
        for(int dir[] : directions){
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            ans += solve(k -1,new_i,new_j);
        }
        double res = (double)ans / 8.0;
        map.put(key,res);
        return res;
    }
    public double knightProbability(int n, int k, int row, int column) {
        bound = n;
        map = new HashMap<>();
        return solve(k,row,column);
    }
}