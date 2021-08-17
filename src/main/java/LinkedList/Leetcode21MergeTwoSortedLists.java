package LinkedList;

/**
 * 合并两个有序链表
 */
public class Leetcode21MergeTwoSortedLists {
    public LinkedList.ListNode mergeTwoLists2020_0831(LinkedList.ListNode l1, LinkedList.ListNode l2) {
        if(l1==null && l2==null){
            return null;
        }
        LinkedList.ListNode dummy=new LinkedList.ListNode(0);
        LinkedList.ListNode cur=dummy;
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
}
