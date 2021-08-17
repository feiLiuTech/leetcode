package LinkedList;

import java.util.List;

public class CreatList {
    public static ListNode creadList(String s){
        String [] str=s.split(" ");
        ListNode dummy=new ListNode(0);
        dummy.next=null;
        ListNode cur=dummy;
        for(int i=0;i<str.length;i++){
            ListNode node=new ListNode(Integer.valueOf(str[i]));
            cur.next=node;
            cur=cur.next;
        }

        return dummy.next;
    }
}
