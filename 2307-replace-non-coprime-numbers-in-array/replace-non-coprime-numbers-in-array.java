    //It can be shown that replacing adjacent non-coprime numbers in any arbitrary order will lead to the same result.this line make the problem easy because
    //if you go with left to right or vice versa you will get same for middle also
        //lcm = > product / GCD
        //lcm take union multiplication
        //we are using the list as stack to implement 
        //this kind of questions are solved using stake 
        //we touch particular number 2 times = 2 * o(n) * o(log(min(a,b)))
class Solution {
    public long findGcd(long a,long b){
        if(b == 0){
            return a;
        }
        return findGcd(b,a%b);
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Long> temp = new ArrayList<>();
        for(int num : nums){
            //merge until getting merge if lcm is one then break
            long curr = num;
            while(!temp.isEmpty()){
                long prev = temp.get(temp.size() -1);
                long gcd = findGcd(curr,prev);
                if(gcd == 1){
                    break;
                }
                //gcd is not one then find lcm and then pop then add the lcm
                temp.remove(temp.size() -1);
                long lcm =(curr * prev) / gcd;
                //we need to add the lcm inplace of num
                curr = lcm;
            }
            temp.add(curr);
        }
        List<Integer> res = new ArrayList<>();
        for(long curr : temp){
            res.add((int)curr);
        }
        return res;
    }
}