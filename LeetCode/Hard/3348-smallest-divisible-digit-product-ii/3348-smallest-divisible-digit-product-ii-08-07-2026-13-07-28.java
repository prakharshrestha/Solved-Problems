class Solution {
    public String smallestNumber(String num, long t) {
        long tt = t;
        int a=0,b=0,c=0,d=0;
        while(tt%2==0){a++;tt/=2;}
        while(tt%3==0){b++;tt/=3;}
        while(tt%5==0){c++;tt/=5;}
        while(tt%7==0){d++;tt/=7;}
        if(tt!=1) return "-1";

        int[][] vec = new int[10][];
        vec[1]=new int[]{0,0,0,0};
        vec[2]=new int[]{1,0,0,0};
        vec[3]=new int[]{0,1,0,0};
        vec[4]=new int[]{2,0,0,0};
        vec[5]=new int[]{0,0,1,0};
        vec[6]=new int[]{1,1,0,0};
        vec[7]=new int[]{0,0,0,1};
        vec[8]=new int[]{3,0,0,0};
        vec[9]=new int[]{0,2,0,0};

        int dimA=a+1, dimB=b+1, dimC=c+1, dimD=d+1;
        int strideA = dimB*dimC*dimD;
        int strideB = dimC*dimD;
        int strideC = dimD;
        int total = dimA*strideA;
        short[] dist = new short[total];

        for(int ai=0; ai<dimA; ai++){
            for(int bi=0; bi<dimB; bi++){
                for(int ci=0; ci<dimC; ci++){
                    for(int di=0; di<dimD; di++){
                        int idx = ai*strideA+bi*strideB+ci*strideC+di;
                        if(ai==0 && bi==0 && ci==0 && di==0){ continue; }
                        int best = Integer.MAX_VALUE;
                        for(int dg=2; dg<=9; dg++){
                            int[] v = vec[dg];
                            int na = ai - v[0]; if(na<0) na=0;
                            int nb = bi - v[1]; if(nb<0) nb=0;
                            int nc = ci - v[2]; if(nc<0) nc=0;
                            int nd = di - v[3]; if(nd<0) nd=0;
                            if(na==ai && nb==bi && nc==ci && nd==di) continue;
                            int nidx = na*strideA+nb*strideB+nc*strideC+nd;
                            int val = dist[nidx]+1;
                            if(val<best) best=val;
                        }
                        dist[idx] = (short) best;
                    }
                }
            }
        }

        int n = num.length();
        int[] digits = new int[n];
        for(int i=0;i<n;i++) digits[i]=num.charAt(i)-'0';

        int firstZero = n;
        for(int i=0;i<n;i++){ if(digits[i]==0){ firstZero=i; break; } }

        int limit = Math.min(n, firstZero);
        int[] cumA = new int[limit+1];
        int[] cumB = new int[limit+1];
        int[] cumC = new int[limit+1];
        int[] cumD = new int[limit+1];
        for(int i=0;i<limit;i++){
            int[] v = vec[digits[i]];
            cumA[i+1] = Math.min(a, cumA[i]+v[0]);
            cumB[i+1] = Math.min(b, cumB[i]+v[1]);
            cumC[i+1] = Math.min(c, cumC[i]+v[2]);
            cumD[i+1] = Math.min(d, cumD[i]+v[3]);
        }

        if(firstZero==n){
            int ra=a-cumA[n], rb=b-cumB[n], rc=c-cumC[n], rd=d-cumD[n];
            if(ra==0&&rb==0&&rc==0&&rd==0){
                return num;
            }
        }

        int maxPivotP = (firstZero<n)? firstZero : n-1;
        for(int p=maxPivotP; p>=0; p--){
            int digitAtP = digits[p];
            int suffixLen = n-1-p;
            for(int x=digitAtP+1; x<=9; x++){
                int[] v = vec[x];
                int na = Math.min(a, cumA[p]+v[0]);
                int nb = Math.min(b, cumB[p]+v[1]);
                int nc = Math.min(c, cumC[p]+v[2]);
                int nd = Math.min(d, cumD[p]+v[3]);
                int ra=a-na, rb=b-nb, rc=c-nc, rd=d-nd;
                int idx = ra*strideA+rb*strideB+rc*strideC+rd;
                if(dist[idx] <= suffixLen){
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, p);
                    sb.append((char)('0'+x));
                    int remA=ra, remB=rb, remC=rc, remD=rd;
                    int budget=suffixLen;
                    while(budget>0){
                        for(int dg=1; dg<=9; dg++){
                            int[] vv = vec[dg];
                            int nna = remA-vv[0]; if(nna<0) nna=0;
                            int nnb = remB-vv[1]; if(nnb<0) nnb=0;
                            int nnc = remC-vv[2]; if(nnc<0) nnc=0;
                            int nnd = remD-vv[3]; if(nnd<0) nnd=0;
                            int nidx = nna*strideA+nnb*strideB+nnc*strideC+nnd;
                            if(dist[nidx] <= budget-1){
                                sb.append((char)('0'+dg));
                                remA=nna; remB=nnb; remC=nnc; remD=nnd;
                                budget--;
                                break;
                            }
                        }
                    }
                    return sb.toString();
                }
            }
        }

        int fullIdx = a*strideA+b*strideB+c*strideC+d;
        int m = dist[fullIdx];
        int L = Math.max(n+1, m);
        StringBuilder sb = new StringBuilder();
        int remA=a, remB=b, remC=c, remD=d;
        int budget=L;
        while(budget>0){
            for(int dg=1; dg<=9; dg++){
                int[] vv = vec[dg];
                int nna = remA-vv[0]; if(nna<0) nna=0;
                int nnb = remB-vv[1]; if(nnb<0) nnb=0;
                int nnc = remC-vv[2]; if(nnc<0) nnc=0;
                int nnd = remD-vv[3]; if(nnd<0) nnd=0;
                int nidx = nna*strideA+nnb*strideB+nnc*strideC+nnd;
                if(dist[nidx] <= budget-1){
                    sb.append((char)('0'+dg));
                    remA=nna; remB=nnb; remC=nnc; remD=nnd;
                    budget--;
                    break;
                }
            }
        }
        return sb.toString();
    }
}