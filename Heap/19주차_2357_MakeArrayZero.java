package codefile;

public class Solution2357 {
	public int minimumOperations(int[] nums) {
        int count = 0;
        

        while(true){
            int sum = 0;
            for (int k = 0; k < nums.length; k++){
                sum += nums[k];
            }
            if (sum == 0){
                break;
            }
            int min = 101;
            for (int i = 0; i<nums.length; i++){
                if (nums[i] < min && nums[i] != 0){
                    min = nums[i];
                }
            }
            for (int j = 0; j<nums.length; j++){
                if (nums[j] - min < 0){
                    nums[j] = 0;
                }else{
                    nums[j] = nums[j] - min;
                }
            }
            count ++;
        }
        return count;
    }
}
