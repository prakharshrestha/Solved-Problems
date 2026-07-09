import java.util.*;

class Solution {

    public ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int target) {

        Arrays.sort(arr);

        HashSet<ArrayList<Integer>> ans = new HashSet<>();
        ArrayList<Integer> temp = new ArrayList<>();

        check(0, arr, temp, ans, target);

        return new ArrayList<>(ans);
    }

    public void check(int i, int[] arr, ArrayList<Integer> temp, HashSet<ArrayList<Integer>> res, int target) {

        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (i == arr.length || target < 0) {
            return;
        }

        temp.add(arr[i]);
        check(i + 1, arr, temp, res, target - arr[i]);
        temp.remove(temp.size() - 1);

        check(i + 1, arr, temp, res, target);
    }
}