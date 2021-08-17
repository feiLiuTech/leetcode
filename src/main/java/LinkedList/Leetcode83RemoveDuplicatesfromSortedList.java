package LinkedList;
/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 示例 1:
 输入: 1->1->2
 输出: 1->2
 *
 */
public class Leetcode83RemoveDuplicatesfromSortedList {
    /**
     * 思路：如果当前指针的值和下一个值重复，那么就让当前指针指向下一个的下一个，否则指针移动到下一个位置
     * @param head
     * @return
     */
    public ListNode deleteDuplicates_2020_0901(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode cur=head;
        while(cur!=null && cur.next!=null){
            if(cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return head;
    }
}
class Leetcode83RemoveDuplicatesfromSortedList_2020_0903 {
    /**
     * 思路：如果当前指针的值和下一个值重复，那么就让当前指针指向下一个的下一个，否则指针移动到下一个位置
     * @param head
     * @return
     */
    public ListNode deleteDuplicates_2020_0901(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=head;
        while(cur!=null && cur.next!=null){
            if(cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}