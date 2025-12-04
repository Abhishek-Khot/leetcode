int removeDuplicates(int* nums, int numsSize) {
    int j = 1;
    int n = numsSize;

    for(int i = 1;i<n;i++){
        // not equal then take 
        if(nums[i-1] != nums[i]){
            nums[j] = nums[i];
            j++;
        }
    }
    return j;
}