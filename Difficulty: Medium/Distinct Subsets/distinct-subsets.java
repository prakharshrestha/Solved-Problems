import java.util.*;
class Solution {
    public ArrayList<ArrayList<Integer>> findSubsets(int[] arr) {
        HashSet<ArrayList<Integer>> ans=new HashSet<>();
        ArrayList<Integer> temp=new ArrayList<>();
        Arrays.sort(arr);
        
        solve(0,arr,ans,temp);
        return new ArrayList<>(ans);
    }
    public void solve(int i,int[] arr,HashSet<ArrayList<Integer>> ans,ArrayList<Integer> temp){
    if(i==arr.length){
        ans.add(new ArrayList<>(temp)); 
        return;
    }
    
    temp.add(arr[i]);
    solve(i+1,arr,ans,temp);
    temp.remove(temp.size()-1);
    solve(i+1,arr,ans,temp);
    }
}
