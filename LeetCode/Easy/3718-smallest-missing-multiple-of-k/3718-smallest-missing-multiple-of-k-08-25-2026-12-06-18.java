class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n=nums.length;
        int num=k;
        ArrayList<Integer> temp=new ArrayList<>();
        for(int i=0;i<n;i++){
            temp.add(nums[i]);
        }
        int i=0;
        while(true){
            if(!temp.contains(num) && num%k==0)
            return num;

            num++;
        }
    }
}