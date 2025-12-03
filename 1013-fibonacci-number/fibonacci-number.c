int fib(int n){
    if(n == 0 || n == 1){
        return n;
    }
    int first = 0;
    int second = 1;
    int res = 0;
    for(int i =1;i< n;i++){
        res = first + second;
        first = second;
        second = res;
    }
    return res;
}