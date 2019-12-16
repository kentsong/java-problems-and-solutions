package leetcode.T002;

public class AddTwoNumbers {

    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     * <p>
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * <p>
     * Example:
     * <p>
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     */

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.setNext(new ListNode(1));

        ListNode r1 = new ListNode(2);
        r1.setNext(new ListNode(1));

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode node = addTwoNumbers.addTwoNumbers(l1, r1);
        System.out.println(node.getNums());

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //題解方式寫法
        ListNode resultHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = resultHead;
        int carry = 0;
        while (p != null || q != null) {
            int a = p != null ? p.val : 0;
            int b = q != null ? q.val : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return resultHead.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        String getNums() {
//            System.out.println(val);
            String temp = "" + val;
            String innerStr = "";
            if (next != null) {
                innerStr = next.getNums();
            }
            return temp + innerStr;
        }
    }

    public ListNode reverseList_planA(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

}
