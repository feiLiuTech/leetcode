package LinkedList;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 说明:
 1 ≤ m ≤ n ≤ 链表长度。
 示例:
 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 输出: 1->4->3->2->5->NULL
 */
public class Leetcode92ReverseLinkedListII {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static void main(String[] args) {
        Leetcode92ReverseLinkedListII test=new Leetcode92ReverseLinkedListII();
        ListNode head=new ListNode(5);

        test.reverseBetween_2020_0830(head,1,1);
    }
        public ListNode reverseBetween_2020_0830(ListNode head, int m, int n) {
            if(head==null){
                return null;
            }
            ListNode dummy=new ListNode(0);
            dummy.next=head;
            ListNode pre=dummy;
            ListNode start=head, end=head;
            for(int i=1;i<m;i++){
                pre=start;
                start=start.next;
            }
            for(int i=0;i<n;i++){
                end=end.next;
            }
            ListNode new_head=reverse(start,end);
            start.next=end;
            pre.next=new_head;
            return dummy.next;
        }

        public ListNode reverse(ListNode start, ListNode end){
            ListNode pre=null;
            ListNode cur=start;
            while(cur!=end){
                ListNode nxt=cur.next;
                cur.next=pre;
                pre=cur;
                cur=nxt;
            }
            return pre;
        }

    /**
     * 递归解法
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween_2_2020_0830(ListNode head, int m, int n) {

        ListNode successor=null;
        if(m==1){
            return reverseN(head,n,successor);
        }
        head.next=reverseBetween_2_2020_0830(head.next,m-1,n);
        return head;
    }

    /**
     * 逆置前N个节点
     * @param head
     * @param n
     * @param successor
     * @return
     */
    public ListNode reverseN(ListNode head, int n, ListNode successor){
        if(n==1){
            //找到第n个节点的后继节点
            successor=head.next;
        }
        ListNode newHead=reverseN(head.next, n-1, successor);
        head.next.next=head;
        head.next=successor;
        return newHead;
    }



}

