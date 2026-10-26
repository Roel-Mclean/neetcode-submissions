class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] mostFreq = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> frequencies = new ArrayList<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < nums.length + 1; i++) {
            frequencies.add(new ArrayList<>());
        }

        for (int key : map.keySet()) {
            int freq = map.get(key);
            frequencies.get(freq).add(key);
        }

        int topFreqsFound = 0;

        for (int i = frequencies.size() - 1; i >= 0; i--) {
            if (!frequencies.get(i).isEmpty()) {
                for (int value : frequencies.get(i)) {
                    if (topFreqsFound == k) {
                        break;
                    }
                    mostFreq[topFreqsFound] = value;
                    topFreqsFound++;
                }
            }
        }

        return mostFreq;
    }
}
