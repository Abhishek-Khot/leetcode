int majorityElement(int* nums, int numsSize) {
    int count = 1;
    // we are considering first element so count start with the one 
    int majorElement = nums[0];

    for(int i = 1;i<numsSize;i++){
        if(count == 0){
            majorElement = nums[i];
            count++;
        }
        else if(nums[i] == majorElement){
            count++;
        }
        else{
            count--;
        }
    }
    return majorElement;
}