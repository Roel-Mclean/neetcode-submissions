class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> record = new Stack<>();
        int result = 0;

        for (String operation : operations) {
            if (operation.equals("+")) {
                int lastVal = record.pop();
                int secondLastVal = record.peek();
                int addition = lastVal + secondLastVal;
                record.push(lastVal);
                record.push(addition);
                result += addition;
            } else if (operation.equals("D")) {
                int val = record.peek() * 2;
                record.push(val);
                result += val;
            } else if (operation.equals("C")) {
                int val = record.pop();
                result -= val;
            } else {
                int val = Integer.parseInt(operation);
                record.push(val);
                result += val;
            }
        }

        return result;
    }
}