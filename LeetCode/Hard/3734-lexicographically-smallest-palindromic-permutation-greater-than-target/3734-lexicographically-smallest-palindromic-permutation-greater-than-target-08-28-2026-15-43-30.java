class Solution {

    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] fullFrequency = new int[26];
        for (int index = 0; index < n; index++) {
            int charIndex = s.charAt(index) - 'a';
            fullFrequency[charIndex] = fullFrequency[charIndex] + 1;
        }
        int oddCountCharacters = 0;
        int oddCharIndex = -1;
        for (int letterIndex = 0; letterIndex < 26; letterIndex++) {
            if (fullFrequency[letterIndex] % 2 != 0) {
                oddCountCharacters = oddCountCharacters + 1;
                oddCharIndex = letterIndex;
            }
        }
        boolean isEvenLength = (n % 2 == 0);
        if (isEvenLength && oddCountCharacters != 0) {
            return "";
        }
        if (!isEvenLength && oddCountCharacters != 1) {
            return "";
        }
        int half = n / 2;
        int[] halfCount = new int[26];
        for (int letterIndex = 0; letterIndex < 26; letterIndex++) {
            halfCount[letterIndex] = fullFrequency[letterIndex] / 2;
        }
        char middleCharacter = isEvenLength ? ' ' : (char) ('a' + oddCharIndex);
        String targetFirstHalf = target.substring(0, half);
        int[] targetFirstHalfFrequency = new int[26];
        for (int index = 0; index < half; index++) {
            int charIndex = targetFirstHalf.charAt(index) - 'a';
            targetFirstHalfFrequency[charIndex] = targetFirstHalfFrequency[charIndex] + 1;
        }
        boolean targetFirstHalfMatchesMultiset = true;
        for (int letterIndex = 0; letterIndex < 26; letterIndex++) {
            if (targetFirstHalfFrequency[letterIndex] != halfCount[letterIndex]) {
                targetFirstHalfMatchesMultiset = false;
                break;
            }
        }
        if (targetFirstHalfMatchesMultiset) {
            String candidatePalindrome = buildPalindrome(targetFirstHalf, middleCharacter, isEvenLength);

            if (candidatePalindrome.compareTo(target) > 0) {
                return candidatePalindrome;
            }
        }
        String nextGreaterHalf = findSmallestGreaterPermutation(halfCount, targetFirstHalf);
        if (nextGreaterHalf == null) {
            return "";
        }
        return buildPalindrome(nextGreaterHalf, middleCharacter, isEvenLength);
    }
    private String buildPalindrome(String firstHalf, char middleCharacter, boolean isEvenLength) {
        StringBuilder builder = new StringBuilder();
        builder.append(firstHalf);
        if (!isEvenLength) {
            builder.append(middleCharacter);
        }
        for (int index = firstHalf.length() - 1; index >= 0; index--) {
            builder.append(firstHalf.charAt(index));
        }
        return builder.toString();
    }
    private String findSmallestGreaterPermutation(int[] multiset, String x) {

        int length = x.length();
        if (length == 0) {
            return null;
        }
        int[] current = new int[26];
        for (int letterIndex = 0; letterIndex < 26; letterIndex++) {
            current[letterIndex] = multiset[letterIndex];
        }
        int matchedLength = 0;
        for (int position = 0; position < length; position++) {
            int charIndex = x.charAt(position) - 'a';
            if (current[charIndex] > 0) {
                current[charIndex] = current[charIndex] - 1;
                matchedLength = matchedLength + 1;
            } else {
                break;
            }
        }
        int topPosition;
        if (matchedLength == length) {
            int lastCharIndex = x.charAt(length - 1) - 'a';
            current[lastCharIndex] = current[lastCharIndex] + 1;
            matchedLength = matchedLength - 1;
            topPosition = matchedLength;
        } else {
            topPosition = matchedLength;
        }
        for (int position = topPosition; position >= 0; position--) {

            int targetCharIndex = x.charAt(position) - 'a';
            int foundCharIndex = -1;
            for (int candidateIndex = targetCharIndex + 1; candidateIndex < 26; candidateIndex++) {
                if (current[candidateIndex] > 0) {
                    foundCharIndex = candidateIndex;
                    break;
                }
            }
            if (foundCharIndex != -1) {
                current[foundCharIndex] = current[foundCharIndex] - 1;

                StringBuilder result = new StringBuilder();
                result.append(x, 0, position);
                result.append((char) ('a' + foundCharIndex));

                for (int letterIndex = 0; letterIndex < 26; letterIndex++) {
                    for (int count = 0; count < current[letterIndex]; count++) {
                        result.append((char) ('a' + letterIndex));
                    }
                }

                return result.toString();
            }
            if (position > 0) {
                int previousCharIndex = x.charAt(position - 1) - 'a';
                current[previousCharIndex] = current[previousCharIndex] + 1;
            }
        }
        return null;
    }
}