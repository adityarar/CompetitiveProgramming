class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int[] table = new int[nums.length + 1];
        int[] ans = new int[2];
        for(int i=0 ;i<nums.length; i++){
            int item = nums[i];
            table[item]++;
            if(table[item] > 1){//present twice
                ans[0] = item;
            }
        }
        for(int i=1; i<=nums.length; i++){
            // System.out.print(table[i] + ",");
            if(table[i] == 0){
                ans[1] = i;
                // System.out.println("asdad" + i);
                break;
            }
        }
        return ans;
    }
}