import java.util.*;

class Solution {

    public ArrayList<ArrayList<Integer>> targetSumComb(int[] arr, int target) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        check(0, arr, temp, ans, target);

        return ans;
    }

    public void check(int i, int arr[], ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res, int t) {

        if (i == arr.length) {
            if (t == 0) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        if (arr[i] <= t) {
            temp.add(arr[i]);
            check(i, arr, temp, res, t - arr[i]);
            temp.remove(temp.size() - 1);
        }

        check(i + 1, arr, temp, res, t);
    }
}