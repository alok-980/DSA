public class Main {

    static class Solution {
        public boolean canEqual(int nums[], int k, int key) {
            int arr[] = nums.clone();

            int count = 0;

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] != key) {
                    arr[i] *= -1;
                    arr[i + 1] *= -1;
                    count++;

                    if (count > k) {
                        return false;
                    }
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (arr[i] != key) {
                    return false;
                }
            }

            return true;
        }

        public boolean canMakeEqual(int[] nums, int k) {
            return canEqual(nums, k, 1) || canEqual(nums, k, -1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1, -1, 1, -1, 1};
        // int k = 3;

        int nums2[] = {-1,-1,-1,1,1,1}; 
        int k = 5;

        boolean result = sol.canMakeEqual(nums2, k);
        System.out.println("Result: " + result); // Expected: true
    }
}
