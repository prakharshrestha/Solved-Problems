class Solution {
    public void mergeSort(int arr[], int l, int r) {
        
        if(l>=r) 
        return;
        
        int mid=l+(r-l)/2;
        
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
        
    }
    public void merge(int[] arr, int l, int mid, int r){
        int low=l;
        int high=mid+1;
        
        ArrayList<Integer> list=new ArrayList<>();
        
        while(low<=mid && high<=r){
            if(arr[low]<=arr[high]){
            list.add(arr[low]);
            low++;
            }
            else{
              list.add(arr[high]);
              high++;
            }
        }
        while(low<=mid){
            list.add(arr[low]);
            low++;
        }
        while(high<=r){
            list.add(arr[high]);
              high++;
        }
        for(int i=l;i<=r;i++){
            arr[i]=list.get(i-l);
        }
    }
}