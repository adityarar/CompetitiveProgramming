class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        if(x<0){
            isNegative = true;
            x *= -1;
        }
        if(x==0)
            return 0;
        long y=0;
        while(x!=0){
            y = y*10 + x%10;
            x /= 10;
        }
        if(Math.abs(y)>=Integer.MAX_VALUE)//has overflowed
            return 0;
        if(isNegative)
            y *= -1;
        return (int)y;
    }
}