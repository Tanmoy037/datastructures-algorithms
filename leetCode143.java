class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;
            ListNode s = head;
            ListNode f = head;

        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }

        ListNode Prev = null;
        ListNode Curr = s.next;
        s.next = null;

        while (Curr != null) {
            ListNode Currp1 = Curr.next;
            Curr.next = Prev;
            Prev = Curr;
            Curr = Currp1;
        }


        ListNode left = head;
        ListNode right = Prev;

        while (right != null) {
            
            ListNode leftp1 = left.next;
            ListNode rightp1 = right.next;

            left.next = right;
            right.next = leftp1;
            left = leftp1;
            right = rightp1;
        }
    }

}
