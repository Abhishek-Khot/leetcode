class Solution {
    public int lengthOfLongestSubstring(String s) {
        // if map size i less than j - i +1 then only remove -- check for the example once
        int n = s.length();
        int i  =0;
        int j = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int res = 0;

        while(j < n){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size() == j - i +1){
                res = Math.max(res,j-i+1);
            }
            else if (map.size() < j- i +1){
                while(map.size() < j - i +1){
                    map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
                    if(map.get(s.charAt(i)) == 0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
            }
            j++;
        }
        return res;
    }
}