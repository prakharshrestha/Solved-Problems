import java.util.*;

class Solution {

    class R {
        char c;
        int r;

        R(char c, int r) {
            this.c = c;
            this.r = r;
        }
    }

    TreeMap<Integer, R> mp = new TreeMap<>();
    TreeMap<Integer, Integer> len = new TreeMap<>();

    void add(int l, int r, char c) {
        mp.put(l, new R(c, r));
        len.put(r - l + 1, len.getOrDefault(r - l + 1, 0) + 1);
    }

    void rem(int l) {
        R x = mp.get(l);
        int z = x.r - l + 1;

        int f = len.get(z);

        if (f == 1)
            len.remove(z);
        else
            len.put(z, f - 1);

        mp.remove(l);
    }

    public int[] longestRepeating(String s, String qc, int[] qi) {

        int n = s.length();

        char[] a = s.toCharArray();

        int l = 0;

        for (int i = 1; i <= n; i++) {

            if (i == n || a[i] != a[l]) {
                add(l, i - 1, a[l]);
                l = i;
            }
        }

        int[] ans = new int[qi.length];

        for (int q = 0; q < qi.length; q++) {

            int i = qi[q];
            char c = qc.charAt(q);

            Map.Entry<Integer, R> e = mp.floorEntry(i);

            int st = e.getKey();
            R x = e.getValue();

            if (x.c == c) {
                ans[q] = len.lastKey();
                continue;
            }

            int ed = x.r;
            char old = x.c;

            rem(st);

            if (st < i)
                add(st, i - 1, old);

            add(i, i, c);

            if (i < ed)
                add(i + 1, ed, old);

            Map.Entry<Integer, R> cur = mp.floorEntry(i);

            if (cur.getKey() != i) {
                cur = mp.ceilingEntry(i);
            }

            Map.Entry<Integer, R> pre = mp.lowerEntry(cur.getKey());

            if (pre != null &&
                pre.getValue().r + 1 == cur.getKey() &&
                pre.getValue().c == cur.getValue().c) {

                int nl = pre.getKey();
                int nr = cur.getValue().r;
                char nc = cur.getValue().c;

                rem(pre.getKey());
                rem(cur.getKey());

                add(nl, nr, nc);

                cur = mp.floorEntry(i);
            }

            Map.Entry<Integer, R> nxt = mp.higherEntry(cur.getKey());

            if (nxt != null &&
                cur.getValue().r + 1 == nxt.getKey() &&
                cur.getValue().c == nxt.getValue().c) {

                int nl = cur.getKey();
                int nr = nxt.getValue().r;
                char nc = cur.getValue().c;

                rem(cur.getKey());
                rem(nxt.getKey());

                add(nl, nr, nc);
            }

            ans[q] = len.lastKey();
        }

        return ans;
    }
}