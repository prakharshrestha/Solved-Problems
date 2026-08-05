class Solution {
    class Pair{
        int start;
        int finish;
        
        Pair(int s,int f){
            start=s;
            finish=f;
        }
    }
    public int activitySelection(int[] start, int[] finish) {
        int n=start.length;
        Pair[] arr=new Pair[n];
        
        for(int i=0;i<n;i++){
            arr[i]=new Pair(start[i],finish[i]);
        }
        Arrays.sort(arr,(a,b)->a.finish-b.finish);
        
        int c=1;
        int last=arr[0].finish;
        
        for(int i=1;i<n;i++){
            if(arr[i].start>last){
                c++;
                last=arr[i].finish;
            }
        }
        return c;
    }
}
