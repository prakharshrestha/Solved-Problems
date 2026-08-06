class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int low=0;
        int mid=m-1;
        int high=m;

        
        for(int i=m;i<m+n;i++){
            nums1[i]=nums2[i-m];
        }
        ArrayList<Integer> list=new ArrayList<>();
        
        while(low<=mid && high<=nums1.length-1){
            if(nums1[low]<=nums1[high]){
            list.add(nums1[low]);
            low++;
            }
            else{
              list.add(nums1[high]);
              high++;
            }
        }
        while(low<=mid){
            list.add(nums1[low]);
            low++;
        }
        while(high<=nums1.length-1){
            list.add(nums1[high]);
              high++;
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i]=list.get(i);
        }
    }
}