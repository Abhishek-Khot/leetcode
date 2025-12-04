int max(int a,int b){
    return a < b ? b : a;
}
bool canJump(int* nums, int numsSize) {
    int reach = 0;
    for(int i=0;i<numsSize;i++){
        if(reach < i){
            return false;
        }
        reach = max(reach,nums[i] + i);
        // take max out of it 
    }
    return true;
}