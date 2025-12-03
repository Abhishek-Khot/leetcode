char* reverseWords(char* s) {
    int n = strlen(s);

    // Array to store words (max words = n/2 + 1)
    char** words = (char**)malloc(sizeof(char*) * (n + 1));
    int wordCount = 0;

    int i = 0;

    // 1. Extract words one by one
    while (i < n) {

        // Skip spaces
        while (i < n && s[i] == ' ') i++;

        if (i >= n) break;

        // Start index of word
        int start = i;

        // Move until next space
        while (i < n && s[i] != ' ') i++;

        int end = i;

        // Allocate memory and copy the word
        int len = end - start;
        char* word = (char*)malloc(len + 1);
        strncpy(word, s + start, len);
        word[len] = '\0';

        words[wordCount++] = word;
    }

    // 2. Build result string
    char* result = (char*)malloc(n + 1);
    int idx = 0;

    for (int k = wordCount - 1; k >= 0; k--) {
        int len = strlen(words[k]);
        memcpy(result + idx, words[k], len);
        idx += len;

        if (k > 0) result[idx++] = ' '; // add space
        free(words[k]);                // free each word
    }

    result[idx] = '\0';
    free(words);

    return result;
}