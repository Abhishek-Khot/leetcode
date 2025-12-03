int hammingWeight(int n) {
    int count = 0;
    while(n > 0){
        int mask = n & 1;
        if(mask == 1){
            count++;
        }
        n = n >> 1;
    }
    return count;
}