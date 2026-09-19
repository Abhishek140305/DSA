class Solution {

    public void reorderList(ListNode head) {

        if(head == null || head.next == null){
            return;
        }

        // Step 1: Find Middle

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Split List

        ListNode second = slow.next;
        slow.next = null;

        // Step 3: Reverse Second Half

        ListNode prev = null;

        while(second != null){

            ListNode next = second.next;

            second.next = prev;

            prev = second;
            second = next;
        }

        second = prev;

        // Step 4: Merge Both Halves

        ListNode first = head;

        while(second != null){

            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}