package SwordOffer;

/**
 *剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

 返回删除后的链表的头节点。

 注意：此题对比原题有改动

 示例 1:

 输入: head = [4,5,1,9], val = 5
 输出: [4,1,9]
 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

 */
public class SwordOffer18 {
    public ListNode deleteNode_2020_0831(ListNode head, int val) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=dummy;
        while(cur.next!=null && cur.next.val!=val){
            cur=cur.next;
        }
        if(cur.next!=null){
            //说明找到了
            cur.next=cur.next.next;
        }

        return dummy.next;
    }

    public ListNode deleteNode_2_2020_0831(ListNode head, int val) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=head;
        while(cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
                break;
            }
            pre=cur;
            cur=cur.next;
        }
        return dummy.next;
    }

}
