package leetcode;
/**
*
* @author Scott
*/
public class FindtheDuplicateNumber  {
    public int findDuplicate(int[] nums) {
        if (nums.length > 1){
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast){
                slow = nums[slow];
                fast = nums[nums[fast]]; // two steps
            }
            fast = 0;
            while (fast != slow){
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
	}
	return -1;
    }
    
    //GIPlan
    public int findDuplicate(int[] nums) {
        if(nums.length>1){
            int slow=nums[0];
            int fast=nums[nums[0]];
            while(slow!=fast){
                slow = nums[slow];
                fast = nums[nums[fast]];
                
            }
            fast =0;
            while(slow!=fast){
                slow = nums[slow];
                fast = nums[fast];
                System.out.println("slow"+slow);
                System.out.println("fast"+fast);
            }
            return slow;
        }else{
            return -1;
        }
    }
}
