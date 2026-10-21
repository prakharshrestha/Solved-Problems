class Solution {
    public long maxKelements(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i: nums){
            pq.add(i);
        }
        long ans=0;
        int l=0;
        while(k>0){
            int num=pq.peek();
            ans=ans+pq.poll();
            pq.add((int)Math.ceil(num/3.0));
            k--;
        }
        return ans;
    }
}