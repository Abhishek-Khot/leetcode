class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(),n = s2.length();
        if(m > n)return false;

        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for(int i  = 0;i<m;i++){
            freq1[s1.charAt(i) -'a']++;
        }

        //sliding window 
        int i =0;
        int j = 0;

        while(j < n){
            freq2[s2.charAt(j) -'a']++;
            
            if(j - i + 1 > m){
                //shrink the window size
                freq2[s2.charAt(i) -'a']--;
                i++;
            }

            if(Arrays.equals(freq1,freq2)){
                return true;
            }
            j++;
        }
        return false;
    }
}