class Solution {

    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] right = new int[m];
        for (int i = 0; i < m; i++) {
            right[i] = -1;
        }
        int j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                right[j] = i;
                j--;
            }
        }
        int[] answer = new int[m];
        int word2Index = 0;
        boolean changed = false;
        for (int i = 0; i < n && word2Index < m; i++) {
            if (word1.charAt(i) == word2.charAt(word2Index)) {
                answer[word2Index] = i;
                word2Index++;
            }
            else if (changed == false) {
                if (word2Index == m - 1) {
                    answer[word2Index] = i;
                    word2Index++;
                    changed = true;
                }
                else if (right[word2Index + 1] > i) {
                    answer[word2Index] = i;
                    word2Index++;
                    changed = true;
                }
            }
        }
        if (word2Index < m) {
            return new int[0];
        }
        return answer;
    }
}