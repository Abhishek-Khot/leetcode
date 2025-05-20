class Solution {
    public String triangleType(int[] nums) {
        //check for valid triangle
        boolean valid = (nums[0] + nums[1] > nums[2]) && (nums[0] + nums[2] > nums[1]) && (nums[1] + nums[2] > nums[0]);

        if(!valid){
            return "none";
        }
        else if (nums[0] == nums[1]  && nums[1] == nums[2]){
            return "equilateral";
        }
        else if(nums[0] != nums[1]  && nums[1]  != nums[2] && nums[0] != nums[2]){
            return "scalene";
        }
        return "isosceles";
    }
}