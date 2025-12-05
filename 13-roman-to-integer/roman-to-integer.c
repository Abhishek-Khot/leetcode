int value(char ch) {
    switch (ch) {
    case 'I':
        return 1;
    case 'V':
        return 5;
    case 'X':
        return 10;
    case 'L':
        return 50;
    case 'C':
        return 100;
    case 'D':
        return 500;
    case 'M':
        return 1000;
    default:
        return 0;
    }
}
int romanToInt(char* s) {
    int sum = 0;
    int n = strlen(s);
    for(int i = 0;i<n;i++){
        if(i+1< n && value(s[i]) < value(s[i+1])){
            sum -= value(s[i]);
        }
        else{
            sum+=value(s[i]);
        }
    }
    return sum;
}
