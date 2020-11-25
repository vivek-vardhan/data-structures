package com.java.ds.fastslowpointers;

public class HappyNumber {

    /**
     * 23 = happy number
     *
     * 2^2 + 3^2 = 13
     * ​1^2 + 3^2 = 10
     * 1^2 + 0 = 1
     *
     *for those who are not happy numbers the eventual square of sum will repeat.. means eventually a cycle
     *
     *
     * 12 = Not a happy number
     *
     * 1^2  + 2^2 = 5, 5*5= 25, 1*2 + 5* 5 = 29, 2*2 + 9 * 9 = 89.... 37, 3*3 +  7 * 7 = 58, 5*5 + 8 * 8= 89:::: REPEAT, cycyle
     *
     *
     */

    public boolean isHappy(int num) {
        int fast = num;//Current num is treated as fast and slow, fast means two time calculation
        int slow = num;
        //end case: either we will get a 1 or fast == slow
        while (fast != 1) {
            fast = calculateSumOfSquareOfDigits(fast);
            fast = calculateSumOfSquareOfDigits(fast);
            slow = calculateSumOfSquareOfDigits(slow);
            if(fast != 1 && fast == slow){
                return false;
            }
        }
        return true;

    }

    private int calculateSumOfSquareOfDigits(int num){
        int res = 0;
        while(num > 0){
            int n = num % 10;
            res += n * n;
            num /= 10;
        }
        return res;
    }
}
