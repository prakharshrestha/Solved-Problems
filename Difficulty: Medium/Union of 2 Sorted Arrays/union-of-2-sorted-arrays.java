class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        int s1=a.length;
        int s2=b.length;
        HashSet<Integer> ans=new HashSet<>();
        for(int i=0;i<s1;i++){
            ans.add(a[i]);
        }
        for(int i=0;i<s2;i++){
            ans.add(b[i]);
        }
        ArrayList<Integer> res=new ArrayList<>(ans);
        Collections.sort(res);
        return res;
    }
}
