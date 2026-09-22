// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        int s = 0;
        int e = pairs.size() - 1;

        if (e - s + 1 <= 1) {
            return pairs;
        }

        int left = 0;
        int pivot = pairs.get(e).key;

        for (int i = 0; i < e; i++) {
            if (pairs.get(i).key < pivot) {
                Pair tmp = pairs.get(i);
                pairs.set(i, pairs.get(left));
                pairs.set(left, tmp);
                left++;
            }
        }

        Pair tmp = pairs.get(left);
        pairs.set(left, pairs.get(e));
        pairs.set(e, tmp);

        quickSort(pairs.subList(0, left));
        quickSort(pairs.subList(left + 1, e + 1));
        return pairs;
    }
}
