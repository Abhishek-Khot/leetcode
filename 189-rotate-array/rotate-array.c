void rotateOnce(int* nums,int start,int end){
    while(start < end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}
void rotate(int* nums, int numsSize, int k) {
    k = k % numsSize;
    numsSize--;
    rotateOnce(nums,0,numsSize);
    rotateOnce(nums,0,k-1);
    rotateOnce(nums,k,numsSize);
}