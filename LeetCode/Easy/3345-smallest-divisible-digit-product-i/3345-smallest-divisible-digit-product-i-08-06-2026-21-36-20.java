class Solution {
    public int smallestNumber(int n, int t) {
        int f=0;
        while(f==0){
           if(check(n,t)==true){
            return n;
           }
           n++;
        }
        return n;
    }
    public boolean check(int num, int t)
    {
        
        int p=1;
        while(num>0){
            int d=num%10;
            p*=d;
            num=num/10;
        }
        if(p%t==0)
        return true;

        return false;
    }
}