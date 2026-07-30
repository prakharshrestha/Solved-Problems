class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> ans = new HashSet<>();

        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){

            HashMap<Integer,Integer> map = new HashMap<>();

            for(int j=i+1;j<n;j++){

                int need = -(nums[i]+nums[j]);
                
                if(map.containsKey(need)){
                    ans.add(Arrays.asList(nums[i],need,nums[j]));
                }
                map.put(nums[j],1);
            }
        }
        return new ArrayList<>(ans);
    }
}