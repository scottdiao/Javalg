package leetcode;
/**
*
* @author Scott
*/
public class MoveZeroes  {
    // Shift non-zero values as far forward as possible
// Fill remaining space with zeros

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;        

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }        

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
    
    //GIPlan
    public void moveZeroes(int[] nums) {
        if(nums==null||nums.length==0) return;
        int insert =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0) nums[insert++] = nums[i];
        }
        while(insert<nums.length) nums[insert++] = 0;
    }
}
