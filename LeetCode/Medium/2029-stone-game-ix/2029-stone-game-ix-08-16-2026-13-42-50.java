class Solution {
    public boolean stoneGameIX(int[] stones) {

        int[] count = new int[3];

        for (int x : stones) {
            count[x % 3]++;
        }

        boolean startWith1 =check(count[0], count[1], count[2]);
        boolean startWith2 =check(count[0], count[2], count[1]);

        return startWith1 || startWith2;
    }
    private boolean check(int zero, int one, int two) {

        if (one == 0) {
            return false;
        }
        
        one--;

        int pairs = Math.min(one, two);
        int moves = 1 + pairs * 2;

        one -= pairs;
        two -= pairs;

        if (one > 0) {
            moves++;
            one--;
        }

        moves += zero;
        return moves % 2 == 1 && (one + two > 0);
    }
}