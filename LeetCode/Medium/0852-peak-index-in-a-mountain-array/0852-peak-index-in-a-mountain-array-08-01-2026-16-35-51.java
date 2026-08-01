class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return solve(arr,0,arr.length-1);
    }
    public int solve(int[] arr,int l,int r){
        if(l==r)
        return l;

        int mid=(l+r)/2;

        if(arr[mid]<arr[mid+1])
        return solve(arr,mid+1,r);

        return solve(arr,0,mid);
    }
}