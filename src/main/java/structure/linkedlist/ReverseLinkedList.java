package structure.linkedlist;

public class ReverseLinkedList {

    /**
     * Reverse a singly linked list.
     *
     * Example:
     *
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     * Follow up:
     *
     * A linked list can be reversed either iteratively or recursively. Could you implement both?
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list
     *
     */

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 方法一：迭代
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public ListNode reverseList_planA(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return head;
    }

    /**
     * 方法一：递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * Tips：從最後面查找遞歸往前推進
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * 返回了5这个节点
     * reverseList(4)中
     * p为5
     * head.next.next = head 相当于 5 -> 4
     * 现在节点情况为 4 -> 5 -> 4
     * head.next = null,切断4 -> 5 这一条，现在只有 5 -> 4
     * 返回（return）p为5，5 -> 4
     * 返回上一层reverseList(3)
     * 处理完后返回的是4 -> 3
     * 依次向上
     */




}
