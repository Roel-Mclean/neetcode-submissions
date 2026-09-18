class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> q = new LinkedList<>();

        for (int student : students) {
            q.offer(student);
        }

        int output = q.size();

        for (int sandwich : sandwiches) {
            int count = 0;
            while (count < q.size() && sandwich != q.peek()) {
                q.offer(q.poll());
                count++;
            }

            if (q.peek() == sandwich) {
                q.poll();
                output--;
            } else {
                break;
            }
        }
        return output;
    }
}