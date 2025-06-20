class Solution {
    public int maxDistance(String s, int k) {
        int N = 0, S = 0, W = 0, E = 0;
        int res = 0;
        for(char ch: s.toCharArray()){
            switch(ch){
                case 'N': 
                    N++; break;
                case 'S': 
                    S++; break;
                case 'W': 
                    W++; break;
                case 'E': 
                    E++; break;
            }
            res = Math.max(res, getDist(N, S, W, E, k));
        }
        return res;
    }
    
    // check Manhattan Distance with k change
    int getDist(int N, int S, int W, int E, int k){
        if(S > N){ // swap
            int temp = S;
            S = N;
            N = temp;
        }
        if(E > W){ // swap
            int temp = E;
            E = W;
            W = temp;
        }

        int dist = (N - S) + (W - E);
        if(k >= S){
            dist += 2 * S;
            k -= S;
            dist += 2 * Math.min(k, E);
        }else{
            dist += 2 * k;
        }
        return dist;
    }
}