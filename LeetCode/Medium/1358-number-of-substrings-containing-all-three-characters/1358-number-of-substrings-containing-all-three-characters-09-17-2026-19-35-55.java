class Solution {
    public int numberOfSubstrings(String s) {
        int[] arr=new int[3];
        Arrays.fill(arr,-1);
        int ans=0;
        for(int i=0;i<s.length();i++){
                char x=s.charAt(i);
                if(x=='a')
                arr[0]=i;
                if(x=='b')
                arr[1]=i;
                if(x=='c')
                arr[2]=i;
                int min = Math.min(arr[0],Math.min(arr[1], arr[2]));

            if(min != -1)
                ans += min + 1;
        }
        return ans;
    }
}