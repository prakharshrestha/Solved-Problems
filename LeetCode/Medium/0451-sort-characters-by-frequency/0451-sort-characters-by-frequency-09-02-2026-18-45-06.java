class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq =
        new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        pq.addAll(freq.entrySet());
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();

            for (int i = 0; i < entry.getValue(); i++) {
                ans.append(entry.getKey());
            }
        }
        return ans.toString();
    }
}