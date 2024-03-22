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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode prevSlowNode = null;
        ListNode slowNode = head;
        ListNode fastNode = head;
        while(fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;

            ListNode nextSlowNode = slowNode.next;
            slowNode.next = prevSlowNode;
            prevSlowNode = slowNode;
            slowNode = nextSlowNode;
        }

        ListNode firstHalfPointer = prevSlowNode;
        ListNode secondHalfPointer = null;
        if(fastNode == null) {
            secondHalfPointer = slowNode;
        } else if(fastNode.next == null) {
            secondHalfPointer = slowNode.next;
        }

        while(firstHalfPointer != null && secondHalfPointer != null) {
            if(firstHalfPointer.val != secondHalfPointer.val) {
                return false;
            }
            
            firstHalfPointer = firstHalfPointer.next;
            secondHalfPointer = secondHalfPointer.next;
        }

        return true;
    }
}