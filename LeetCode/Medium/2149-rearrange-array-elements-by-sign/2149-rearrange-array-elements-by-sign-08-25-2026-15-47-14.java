class Solution {
    public int[] rearrangeArray(int[] nums) {
        Deque<Integer> pos = new ArrayDeque<>();
        Deque<Integer> neg = new ArrayDeque<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0)
                neg.addFirst(nums[i]);
            else
                pos.addFirst(nums[i]);
        }

        int[] ans=new int[neg.size()+pos.size()];
        int i=0;
        while(!neg.isEmpty() && !pos.isEmpty()){
            if(!pos.isEmpty()){
                nums[i]=pos.peekLast();
                pos.pollLast();
                i++;
            }
            if(!neg.isEmpty()){
                nums[i]=neg.peekLast();
                neg.pollLast();
                i++;
            }
        }
        return nums;
    }
}