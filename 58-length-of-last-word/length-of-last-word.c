// this is 
int lengthOfLastWord(char* s) {
    int n = strlen(s);
    int count = 0;
    int i = n - 1;
    while (i >= 0 && s[i] == ' ') {
        i--;
    }
    int start = i;
    while (i >= 0 && s[i] != ' ') {
        count++;
        i--;
    }
    return count;
}