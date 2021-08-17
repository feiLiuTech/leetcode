package LinkedList;

public class Leetcode2TwoSum {
    public static void main(String[] args) {
        ListNode l1=CreatList.creadList("2 4 3");
        ListNode l2=CreatList.creadList("5 6 4");
        Leetcode2TwoSum test=new Leetcode2TwoSum();
        test.addTwoNumbers_2020_0903(l1,l2);
    }
    /**
     * 关键点是为了保证l1和l2位数相同，长度不够的可以填0
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers_2020_0903(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur=dummy;
        ListNode p=l1,q=l2;
        int carry=0;
        while(p!=null || q!=null){
            int val1=(p==null)?0:p.val;
            int val2=(q==null)?0:q.val;
            int sum=val1+val2+carry;
            carry=0;
            ListNode node=new ListNode(sum);
            if(sum>=10) {
                node.val=sum%10;
                carry=1;
            }
            cur.next=node;
            cur=cur.next;
            if(p!=null){
                p=p.next;
            }
            if(q!=null){
                q=q.next;
            }

        }
        //可能最后会有进位
        if(carry==1){
            cur.next=new ListNode(1);
        }
        return dummy.next;
    }
}
