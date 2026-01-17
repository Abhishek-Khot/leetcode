class Solution {
    public List<Integer> solve(String s) {
        // for loop for the checking 
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // splitting the string from the operator 
            char ch = s.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = solve(s.substring(0, i));
                List<Integer> right = solve(s.substring(i + 1));
                for (int x : left) {
                    for (int y : right) {
                        if (ch == '+') {
                            res.add(x + y);
                        } else if (ch == '-') {
                            res.add(x - y);
                        } else {
                            res.add(x * y);
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.parseInt(s));
        }
        return res;
    }

    public List<Integer> diffWaysToCompute(String s) {
        return solve(s);
    }
}