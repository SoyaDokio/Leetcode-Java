// version 1
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}

// version 2
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> input = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (input.containsKey(diff)) {
                int lindex = input.get(diff);
                int rindex = i;
                return new int[]{Math.min(lindex, rindex), Math.max(lindex, rindex)};
            }
            input.put(nums[i], i);
        }
        return null;
    }
}

// version 3
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        int lindex = 0,
            rindex = nums.length - 1,
            augend = 0,
            summand = 0;
        // Get 2 elements which summation equals the target from the integer array 'sortedNums'
        while (lindex < rindex) {
            int sum = sortedNums[lindex] + sortedNums[rindex];
            if (sum == target && lindex != rindex) {
                augend = sortedNums[lindex];
                summand = sortedNums[rindex];
                break;
            } else if (sum < target) {
                lindex += 1;
            } else {
                rindex -= 1;
            }
        }
        // Get indices of the 2 elements from last step in the integer array 'nums'
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == augend) {
                lindex = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == summand) {
                rindex = i;
                break;
            }
        }
        
        return new int[]{Math.min(lindex, rindex), Math.max(lindex, rindex)};
    }
}
