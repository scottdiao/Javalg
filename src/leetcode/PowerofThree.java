package leetcode;
/**
*
* @author Scott
*/
public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        return n>0 && (n==1 || (n%3==0 && isPowerOfThree(n/3)));
    }
}
