class Solution {
    public int[] getSneakyNumbers(int[] nums) {       
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[2];
        int ind = 0;
        
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        for (; iterator.hasNext(); ) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() == 2) {
                if (ind < 2) {
                    ans[ind++] = entry.getKey();
                }
            }
        }
        
        return ans;
    }
}
