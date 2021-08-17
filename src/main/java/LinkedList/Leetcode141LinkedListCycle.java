package LinkedList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。

 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */
public class Leetcode141LinkedListCycle {
    /**
     * set方法
     * @param head
     * @return
     */
    public boolean hasCycle_20200831(ListNode head) {
        if(head==null){
            return false;
        }
        Set<ListNode> set=new HashSet<ListNode>();
        ListNode cur=head;
        while(cur!=null){
            if(set.contains(cur)){
                return true;
            }
            set.add(cur);
            cur=cur.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle_2_20200831(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode fast=head.next;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            if(fast==slow){
                return true;
            }
            fast=fast.next.next;
            slow=slow.next;

        }
        return false;
    }
}
