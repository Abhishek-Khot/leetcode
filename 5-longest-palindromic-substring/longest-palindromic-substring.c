void findSubstring(char* s,char res[],int low,int high){
    int j = 0;
    for(int i = low;i<=high;i++){
        res[j++] = s[i];
    }
    res[j] ='\0';
}
char* longestPalindrome(char* s) {
    int n = strlen(s);
    static char res[1001] = {0};
    int resLen = 0;
    for(int i= 0;i<n;i++){
        int low = i;
        int high = i;
        while(low >= 0 && high < n&& s[low] ==  s[high]){
            int len = high - low +1;
            if(resLen < (len)){
                findSubstring(s,res,low,high);
                resLen = len ;
            }
            low--;
            high++;
        }
        low = i;
        high = i+1;
        while(low >= 0 && high < n&& s[low] ==  s[high]){
            int len = high - low +1;
            if(resLen < (len)){
                findSubstring(s,res,low,high);
                resLen = len;
            }
            low--;
            high++;
        }
    }
    return res;
}