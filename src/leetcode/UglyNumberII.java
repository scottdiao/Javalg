package leetcode;
/**
*
* @author Scott
*/
// DP
//We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5.
//
//Then we use similar merge method as merge sort, to get every ugly number from the three subsequence.
//
//Every step we choose the smallest one, and move one step after,including nums with same value.
//
//Thanks for this author about this brilliant idea. Here is my java solution
public class UglyNumberII {
     public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }
}
