class Solution {
    public String getSorted(int n){
        String temp = String.valueOf(n);
        int num = n;
        int len = 0;
        while(num > 0){
            num/=10;
            len++;
        }
        char arr[] = new char[len];
        for(int i = 0;i<temp.length();i++){
            arr[i] = temp.charAt(i);
        }
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
    public boolean reorderedPowerOf2(int n) {
       //new learning left shift of 1 to get the power of two
       String str = getSorted(n) ;
       for(int power = 0;power<=29;power++){
            if(str.equals(getSorted(1 << power))){
                return true;
            }
       }
       return false;
    }
}