import java.util.*;
class Solution {
    class Pair{
        int arrival;
        int departure;
        
        Pair(int a,int d){
            arrival=a;
            departure=d;
        }
    }
    public int minPlatform(int arr[], int dep[]) {
        
        int n=arr.length;
        Pair[] temp=new Pair[n];
        for(int i=0;i<n;i++){
            temp[i]=new Pair(arr[i],dep[i]);
        }
        Arrays.sort(temp,(a,b)->a.arrival-b.arrival);
        
        int platform=1;
        PriorityQueue<Integer> time=new PriorityQueue<>();
        time.add(temp[0].departure);
        for(int i=1;i<n;i++){
            
            if(time.peek()<temp[i].arrival)
            time.poll();
  
            time.add(temp[i].departure);
            
            platform=Math.max(platform,time.size());
        }
        return platform;
    }
}
