class Solution {
    // easy idx to i partition try for all if idx == n valid partition add it to the result 
    public int n;
    public boolean palindrome(String sub){
        int m = sub.length();
        for(int i= 0;i<m;i++){
            if(sub.charAt(i) != sub.charAt(m-i-1)){
                return false;
            }
        }
        return true;
    }
    public void solve(String s,int idx,List<String> curr,List<List<String>> res){
        if(idx == n){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = idx;i<n;i++){
            String part = s.substring(idx,i+1);
            if(palindrome(part)){
                // add explore remove explore
                curr.add(part);
                // idx or i -> idx is fix and i is moving so i +1 not idx +1 you noob
                solve(s,i+1,curr,res);
                curr.remove(curr.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        n = s.length();
        List<List<String>> res = new ArrayList<>();
        solve(s,0,new ArrayList<>(),res);
        return res;
    }
}