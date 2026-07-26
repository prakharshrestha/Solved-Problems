class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        ArrayList<Integer> temp = new ArrayList<>();

        temp.add(intervals[0][0]);
        temp.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= temp.get(1)) {

                temp.set(1, Math.max(temp.get(1), intervals[i][1]));

            } else {

                ans.add(new ArrayList<>(temp));

                temp.clear();

                temp.add(intervals[i][0]);
                temp.add(intervals[i][1]);
            }
        }

        ans.add(new ArrayList<>(temp));

        int[][] arr = new int[ans.size()][2];

        for (int i = 0; i < ans.size(); i++) {
            arr[i][0] = ans.get(i).get(0);
            arr[i][1] = ans.get(i).get(1);
        }

        return arr;
    }
}