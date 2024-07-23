package codefile;

public class Solution88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        for (int i = 0; i < m; i++){
            temp[i] = nums1[i];
        }
        mergeHelper(nums1, temp, nums2);
    }
	private void mergeHelper(int[] output, int[] num1, int[] num2) {
		int s1 = 0;
		int s2 = 0;
		for (int curr = 0; curr < num1.length + num2.length; curr++) {
			if (s1 == num1.length) {
				output[curr] = num2[s2++];
				continue;
			}
			if (s2 == num2.length) {
				output[curr] = num1[s1++];
				continue;
			}
			if (num1[s1] < num2[s2]) {
				output[curr] = num1[s1++];
				continue;
			}else {
				output[curr] = num2[s2++];
				continue;
			}
		}
	}
}
