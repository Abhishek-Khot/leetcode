class Solution {
    public List<Integer> partitionLabels(String s) {
       List<Integer> res = new ArrayList<>();
       int map[] = new int[26];
       int n = s.length();

        //finding the last occurance
        for(int i= 0;i<n;i++){
            int idx = s.charAt(i) -'a';
            map[idx] = i;
        }

        //sliding window approach
        int i = 0;
        while(i < n){
            int end = map[s.charAt(i) -'a'];
            int j = i;
            while(j <end){
                end = Math.max(end,map[s.charAt(j) -'a']);
                j++;
            }
            res.add(j - i+1);
            i = j+1;
        }
        return  res;
    }
}