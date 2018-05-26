class Solution {
    public int singleNumber(int[] nums) {//Could be generalized to k repetitions of numbers except one
	        int n = Integer.SIZE;
	        int[] bitCount = new int[n+1];
	        for(int i=0; i<nums.length; i++) {
	            int num = nums[i];
	            for(int j=0; j<n; j++) {
	                if((num&(1<<j)) != 0)
	                	bitCount[j] = (bitCount[j] + 1) % 3;//adding if bit is set//%3 since 3 times means not useful
	            }
	        }
	        int ans = 0;
	        for(int i=0; i<n; i++) {
	            if(bitCount[i] == 1)
	                ans = ans | 1<<i;
	        }
	        return ans;
	    }
}