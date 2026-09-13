class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {

        ArrayList<int[]> ones1 = new ArrayList<>();
        ArrayList<int[]> ones2 = new ArrayList<>();
        int n = img1.length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                if(img1[i][j] == 1) {
                    ones1.add(new int[]{i, j});
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                if(img2[i][j] == 1) {
                    ones2.add(new int[]{i, j});
                }
            }
        }
        HashMap<String, Integer> map = new HashMap<>();
        int ans = 0;
        for(int[] p1 : ones1) {

            for(int[] p2 : ones2) {

                int dr = p2[0] - p1[0];
                int dc = p2[1] - p1[1];

                String key = dr + "," + dc;

                map.put(key, map.getOrDefault(key, 0) + 1);

                ans = Math.max(ans, map.get(key));
            }
        }
        return ans;
    }
}