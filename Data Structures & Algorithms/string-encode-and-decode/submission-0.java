class Solution {

    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> stringLengths = new ArrayList<>();
        for (String str : strs) {
            stringBuilder.append(str);
            stringLengths.add(str.toCharArray().length);
        }
        for (int length : stringLengths) {
            stringBuilder.append("," + length);
        }
        stringBuilder.append("," + strs.size());
        return stringBuilder.toString();
    }

    public List<String> decode(String str) {
        String[] splitString = str.split(",");

        Integer numOfStrs = Integer.parseInt(splitString[splitString.length - 1]);

        List<Integer> stringLengths = new ArrayList<>();

        for (int i = 0; i < numOfStrs; i++) {
            Integer length = Integer.parseInt(splitString[splitString.length - 1 - numOfStrs + i]);
            stringLengths.add(length);
        }

        List<String> result = new ArrayList<>();
        int index = 0;

        for (int length : stringLengths) {
            String value = str.substring(index, index + length);
            index += length;
            result.add(value);
        }

        return result;
    }
}
