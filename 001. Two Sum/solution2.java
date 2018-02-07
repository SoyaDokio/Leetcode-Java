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
