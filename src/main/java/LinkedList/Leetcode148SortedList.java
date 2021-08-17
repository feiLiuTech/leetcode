package LinkedList;

/**
 * 注意点1：head==null 或者head.next==null 的时候表示只有一个节点的时候直接返回
 */
public class Leetcode148SortedList {
    public ListNode sortList_2020_0906(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }
        ListNode mid=find(head);
        ListNode R=sortList_2020_0906(mid.next);
        mid.next=null;
        ListNode L=sortList_2020_0906(head);
        return mergeTwoList(L, R);
    }
    public  ListNode mergeTwoList(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        if(l1!=null){
            cur.next=l1;
        }
        if(l2!=null){
            cur.next=l2;
        }
        return dummy.next;
    }
    public ListNode find(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode fast=head.next;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
