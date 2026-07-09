class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        
        solve(0,arr,temp,ans);
        
        return ans;
    }
    public void solve(int i,int[] arr,ArrayList<Integer> temp,ArrayList<Integer> ans){
        if(i==arr.length){
            int sum=0;
            for(int n:temp){
                sum+=n;
            }
            ans.add(sum);
            return;
        }
        temp.add(arr[i]);
        solve(i+1,arr,temp,ans);
        temp.remove(temp.size()-1);
        solve(i+1,arr,temp,ans);
    }
}