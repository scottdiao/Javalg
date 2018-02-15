package leetcode;

import java.math.BigInteger;

/**
*
* @author Scott
*/
public class SmallestGoodBase  {
    public String smallestGoodBase(String n) {
        long num = Long.valueOf(n);
        
        for(int m = Math.min((int) (Math.pow(num, 0.5)), 64); m > 1; m--) {
            // k = logm(num)
            long k = (long) Math.pow(num, 1.0 / m);
            if(isGoodBase(num, k, m)) return String.valueOf(k);
        }
        return String.valueOf(num - 1);
    }
    
    private boolean isGoodBase(long num, long base, int m) {
        long sum = num;
        long val = 1;
        // calculate k^0, k^1,  ..., k^m
        for(int i = 0; i <= m; i++) {
            sum -= val;
            val *= base;
        }
        return sum == 0;
    }
}
