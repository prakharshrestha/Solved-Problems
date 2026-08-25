class Solution {
    public ArrayList<Integer> findSubarray(int[] arr) {

        int n = arr.length;
        long maxSum = -1;

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (arr[i] < 0) {
                continue;
            }

            long sum = 0;
            ArrayList<Integer> temp = new ArrayList<>();

            for (int j = i; j < n; j++) {

                if (arr[j] < 0) {
                    break;
                }

                sum += arr[j];
                temp.add(arr[j]);
            }

            if (sum > maxSum) {
                maxSum = sum;

                ans.clear();
                ans.addAll(temp);
            }

            else if (sum == maxSum && temp.size() > ans.size()) {
                ans.clear();
                ans.addAll(temp);
            }
        }

        if (ans.size() == 0) {
            ans.add(-1);
        }

        return ans;
    }
}