class Solution {
    public boolean isAnagram(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 != n2){
            return false;
        }
        int freq[] = new int[26];
        for(int i = 0;i<n1;i++){
            freq[s1.charAt(i)-'a']++;
        }
        for(int i = 0;i<n2;i++){
            freq[s2.charAt(i)-'a']--;
        }
        for(int i =0;i<26;i++){
            if(freq[i] != 0){
                return false;
            }
        }
        return true;
    }
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        res.add(words[0]);//always comes
        for(int i = 1;i<n;i++){
            if(!isAnagram(words[i],res.get(res.size() -1))){
                res.add(words[i]);
            }
        }
        return res;
    }
}