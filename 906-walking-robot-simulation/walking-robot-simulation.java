class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // so start facing to north --> true north 
        // need to know about obstacles also keep set..
        // why to use period 
        // 11 0 and 1 10 if concat it will be the same so use period 


        HashSet<String> set = new HashSet<>();
        for(int ob[] : obstacles){
            set.add(ob[0] + "_" +ob[1]);
        }
        // idea is that just go on adding command times direction-> before that fix direction
        int dir[] = new int[]{0,1};// north 

        int n = commands.length;
        // x and y are current position
            // dx and dy is for direction
        int x = 0;
        int y = 0;
        int maxED = 0;
        for(int i = 0;i<n;i++){
            // -1 means right 
            // lets start with 0,1 then if i turn right one step what happens -> x, y 
            // i will get 1, 0 i will get -> y,x
            // if i turn left then i will get (-1 , 0) -> -y,x
            int dx = dir[0];
            int dy = dir[1];
            if(commands[i] == -1){
                dir = new int[]{dy,-dx};// for complete rotation 0,1 -> east -> 1,0 -> north -> 0,-1 thats why y -x
            }
            else if(commands[i] == -2){
                dir = new int[]{-dy,dx};
            }
            else{
                for(int j= 0;j<commands[i];j++){
                    // check for obstracles 
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    String check = newX + "_" + newY;
                    if(set.contains(check)){
                        break;
                    }
                    x = newX;
                    y = newY;
                }
            }
            maxED = Math.max(maxED,x*x + y *y);
        }
        return maxED;
    }
}