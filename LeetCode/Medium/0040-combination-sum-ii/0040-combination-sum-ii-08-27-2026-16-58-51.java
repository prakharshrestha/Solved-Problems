class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        Arrays.sort(candidates);
        solve(ans,temp,candidates,target,0);
        return ans;
    }
    public void solve(List<List<Integer>> ans, List<Integer> temp, int[] candidates,int t,int ind){
        if(t==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=ind;i<candidates.length;i++){
            if(i>ind && candidates[i]==candidates[i-1])
            continue;

            if(candidates[i]>t)
            break;

            temp.add(candidates[i]);
            solve(ans,temp,candidates,t-candidates[i],i+1);
            temp.remove(temp.size()-1);
        }
    }

}