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
    ListNode head = null;

    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        ListNode curr = head;
        int index = 1;
        int res = 0;
        while(curr != null) {
            if(Math.random() < 1.0 / index) {
                res = curr.val;
            }
            index++;
            curr = curr.next;
        }

        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */