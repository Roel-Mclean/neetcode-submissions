/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode currL1 = list1;
        ListNode currL2 = list2;

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (currL1 != null && currL2 != null) {
            if (currL1.val >= currL2.val) {
                ListNode currL2Next = currL2.next;
                tail.next = currL2;
                currL2 = currL2Next;
            } else {
                ListNode currL1Next = currL1.next;
                tail.next = currL1;
                currL1 = currL1Next;
            }
            tail = tail.next;
        }

        if (currL1 != null) {
            tail.next = currL1;
        } else if (currL2 != null) {
            tail.next = currL2;
        }

        return dummy.next;
    }
}