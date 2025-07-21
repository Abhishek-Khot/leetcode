class Solution {
    public int findGCD(int a,int b){
        if(b == 0)return a;
        return findGCD(b,a%b);
    }
    public String gcdOfStrings(String str1, String str2) {
        //condition for gcd of string is str1 + str2 and str2 + str1 should be same 
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        //find the gcd of both lengths
        int GCD = findGCD(str1.length(),str2.length());
        return str1.substring(0,GCD);
    }
}