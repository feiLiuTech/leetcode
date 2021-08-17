package SwordOffer;

public class SwordOffer24 {
    /**
     * 迭代法
     * @param head
     * @return
     */
    public ListNode reverseList2020_1_0903(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode cur=head;
        ListNode pre=null;
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
    public ListNode reverseList2020_2_0903(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=null;
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
     * 递归法
     * @param head
     * @return
     */
    public ListNode reverseList2020_3_0903(ListNode head) {
        if(head==null){
            return null;
        }
        return recur(head);
    }
    public ListNode recur(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode new_head=recur(head.next);
        head.next.next=head;
        head.next=null;
        return new_head;
    }
}
