class Solution {
    public String frequencySort(String s) {
        int[] arr = new int[123];
        for(char c: s.toCharArray()) arr[c]++;
        StringBuilder sb=new StringBuilder();
        while(true){
            int max=0,maxi=-1;
            for(int i=0;i<123;i++) if(arr[i]>max){
                maxi=i;
                max=arr[i];
            }
            if(max==0) break;
            for(int i=0;i<max;i++) sb.append((char)(maxi));
            arr[maxi]=0;
        }
        return sb.toString();
    }
}