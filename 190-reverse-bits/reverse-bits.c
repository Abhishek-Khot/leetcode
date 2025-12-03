int reverseBits(int n) {
    int res = 0;
    for(int i =0;i<32;i++){
        res =  res << 1;
        int mask = n & 1;
        if(mask == 1){
            res++;
        }
        n = n >> 1;
    }
    return res;
}