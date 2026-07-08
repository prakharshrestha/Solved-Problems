import java.util.*;

class Solution {

    public ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int target) {

        Arrays.sort(arr);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        backtrack(0, arr, target, new ArrayList<>(), ans);

        return ans;
    }

    void backtrack(int start, int[] arr, int target,ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < arr.length; i++) {

            if (i > start && arr[i] == arr[i - 1])
                continue;

            if (arr[i] > target)
                break;

            temp.add(arr[i]);
            backtrack(i + 1, arr, target - arr[i], temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}