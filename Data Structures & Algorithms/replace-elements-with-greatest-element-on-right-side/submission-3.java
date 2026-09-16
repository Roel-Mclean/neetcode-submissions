class Solution {
    public int[] replaceElements(int[] arr) {

        if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        };
        
        int replacement = arr[arr.length - 1];
        arr[arr.length - 1] = -1;

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > replacement) {
                int tmp = arr[i];
                arr[i] = replacement;
                replacement = tmp;
            } else {
                arr[i] = replacement;
            }
        }

        return arr;
    }
}