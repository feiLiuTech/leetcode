package LinkedList;

public class Leetcode206ReverseLinkedList {
    /**
     * 双指针迭代
     * @param head
     * @return
     */
    public ListNode reverseList_1_2020_0830(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode nxt=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nxt;
        }
        return pre;
    }

    /**
     * 头插法
     * @param head
     * @return
     */
    public ListNode reverseList_2_2020_0830(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode dummy=new ListNode(0);
        ListNode cur=head;
        while(cur!=null){
            ListNode nxt=cur.next;
            cur.next=dummy.next;
            dummy.next=cur;
            cur=nxt;
        }
        return dummy.next;
    }

    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode reverseList_3_2020_0830(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode new_head=reverseList_3_2020_0830(head.next);
        head.next.next=head;
        head.next=null;
        return new_head;
    }
}
