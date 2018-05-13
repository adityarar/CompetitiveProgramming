class Solution {
    public void sortColors(int[] nums) {
        int start=0, end=nums.length-1;
        while(start<end){//Shifting all 0s to left
            while(nums[start]==0 && start<end){
                start++;
            }
            while(nums[end]!=0 && start<end){
                end--;
            }
            if(start < end){
                swap(nums, start, end);
            }
        }
        start = 0; end = nums.length-1;
        while(start<end){//Shifting 1s
            while(nums[start]!=2 && start<end){
                start++;
            }
            while(nums[end]!=1 && start<end){
                end--;
            }
            if(start < end){
                swap(nums, start, end);
            }
        }
        
    }
    
    private void swap(int[] arr, int p, int q){
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }
}