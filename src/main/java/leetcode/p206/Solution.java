package leetcode.p206;


class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode reversed = null;
        ListNode nextNode = null;
        for (var node = head; node != null; node = nextNode) {
            nextNode = node.next;
            node.next = reversed;
            reversed = node;
        }
        return reversed;
    }
}
