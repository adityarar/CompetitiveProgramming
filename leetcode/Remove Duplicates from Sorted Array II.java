class Solution {
    public int removeDuplicates(int[] nums) {
        
        if (nums.length==0) return 0;
        int count = 0;//Count of replacements. Shift OK items by this much space
        int itemCount = 1;//Holds count of current repeating number.
        int item = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != item) {//new item, so refresh itemCount
                item = nums[i];
                itemCount = 1;
                nums[i-count] = nums[i];
            }
            else {
                itemCount++;
                if (itemCount > 2) {//Current number has occurred more than twice. So all the remaining numbers will be shifted by count+1
                    count++;
                }
                else {
                    nums[i-count] = nums[i];
                }
            }
        }
        return nums.length-count;
    }
}