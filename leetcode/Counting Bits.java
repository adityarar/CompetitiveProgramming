class Solution {
    /*Idea : When we hit a power of 2, binary patterns repeat with an extra 1 bit in front. e.g. (4 = 100) == 1(0=0)
    So C(17) = C(1)+1;//Because 17 has thw same binary pattern as 1 but with an extra 1 bit in front.
    */
    public int[] countBits(int num) {
        int[] arr = new int[num+1];
        int pow = 2, comparor = 0;
        arr[0] = 0;
        for(int i=1; i<=num; i++){
            if(i==pow){
                pow <<= 1;
                comparor = 0;
            }
            arr[i] = arr[comparor++] + 1;
        }
        System.out.println(arr);
        return arr;
    }
}