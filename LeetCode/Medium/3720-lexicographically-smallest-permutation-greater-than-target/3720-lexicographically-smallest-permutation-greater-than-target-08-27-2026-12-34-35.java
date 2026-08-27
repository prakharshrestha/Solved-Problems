class Solution {

    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder prefix = new StringBuilder();

        int[] bestF = null;
        int bestI = -1;
        char bestC = ' ';

        for (int i = 0; i < n; i++) {

            int targetC = target.charAt(i) - 'a';
            for (int j = targetC + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    bestI = i;
                    bestC = (char) ('a' + j);
                    bestF = freq.clone();
                    break;
                }
            }

            if (freq[targetC] == 0) {
                break;
            }

            freq[targetC]--;
            prefix.append(target.charAt(i));
        }
        if (prefix.length() == n) {

            freq = new int[26];
            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;
            }

            prefix = new StringBuilder();
            bestF = null;
            bestI = -1;

            for (int i = 0; i < n; i++) {
                int targetC = target.charAt(i) - 'a';
                for (int j = targetC + 1; j < 26; j++) {
                    if (freq[j] > 0) {
                        bestI = i;
                        bestC = (char) ('a' + j);
                        bestF = freq.clone();
                        break;
                    }
                }
                freq[targetC]--;
                prefix.append(target.charAt(i));
            }
        }

        if (bestI == -1) 
            return "";
        

        StringBuilder ans = new StringBuilder();
        ans.append(target.substring(0, bestI));
        ans.append(bestC);

        bestF[bestC - 'a']--;

        for (int i = 0; i < 26; i++) {
            while (bestF[i] > 0) {
                ans.append((char) ('a' + i));
                bestF[i]--;
            }
        }
        return ans.toString();
    }
}