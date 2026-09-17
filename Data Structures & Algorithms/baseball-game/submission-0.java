class Solution {
    public int calPoints(String[] operations) {
        List<Integer> record = new ArrayList<>();
        int total = 0;
        for (String operation : operations) {
            if (operation.equals("+")) {
                int a = record.get(record.size() - 1);
                int b = record.get(record.size() - 2);
                int value = a + b;
                record.add(value);
                total += value;
            } else if (operation.equals("D")) {
                int lastVal = record.get(record.size() - 1);
                int newVal = lastVal * 2;
                record.add(newVal);
                total += newVal;
            } else if (operation.equals("C")) {
                int value = record.remove(record.size() - 1);
                total -= value;
            } else {
                Integer value = Integer.valueOf(operation);
                record.add(value);
                total += value;
            }
        }

        return total;
    }
}