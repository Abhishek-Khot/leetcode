class Solution {
    public int[] findEvenNumbers(int[] digits) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = digits.length;
        int map[] = new int[10];

        for(int i =0;i<n;i++){
            map[digits[i]]++;
        }

        for(int i = 1;i<=9;i++){
            if(map[i] == 0)continue;
            map[i]--;

            for(int j =0;j<=9;j++){
                if(map[j] == 0)continue;
                map[j]--;
                for(int k = 0;k<=8;k+=2){
                    if(map[k] == 0)continue;
                    map[k]--;
                    int num = (i *100) + (j*10) +k;
                    res.add(num);
                    map[k]++;
                }
                map[j]++;
            }
            map[i]++;
        }
        int m = res.size();
        int ans[] = new int[m];
        for(int i = 0;i<m;i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}