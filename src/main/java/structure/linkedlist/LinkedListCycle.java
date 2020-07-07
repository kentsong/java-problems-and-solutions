package structure.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * T141
 */

public class LinkedListCycle {

    public static void main(String[] args) {
        Hash_Solution(new ListNode(1));
        slow_fast_point_Solution(new ListNode(1));
    }

    private static boolean Hash_Solution(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    private static boolean slow_fast_point_Solution(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            //fast 如果有环，会在环里面一直跑，直到与 slow 相遇
            fast = fast.next.next;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}





