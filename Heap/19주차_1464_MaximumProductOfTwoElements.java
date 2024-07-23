package codefile;

public class Solution1464 {
	public int maxProduct(int[] nums) {
        int temp;

        for(int i = 0; i < nums.length; i++){
            for (int j = nums.length-1; j > i; j--){
                if(nums[j] < nums[j-1]){
                    temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }

        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
}
