class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int i = 0,j = 0;
        int count = 0;
        int n = trainers.length,m = players.length;
        Arrays.sort(players);
        Arrays.sort(trainers);
        while(i < m &&j < n){
            if(players[i] <= trainers[j]){
                count++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return count;

    }
}