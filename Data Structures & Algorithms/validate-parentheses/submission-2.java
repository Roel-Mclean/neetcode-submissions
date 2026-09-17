class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> bracketPairs = new HashMap<>();
        bracketPairs.put(')', '(');
        bracketPairs.put('}', '{');
        bracketPairs.put(']', '[');

        Stack<Character> brackets = new Stack<>();

        for (char bracket : s.toCharArray()) {
            if (bracketPairs.containsKey(bracket)) {
                if (!brackets.isEmpty() && brackets.peek() == bracketPairs.get(bracket)) {
                    brackets.pop();
                } else {
                    return false;
                }
            } else {
                brackets.push(bracket);
            }
        }

        return brackets.isEmpty();
    }
}
