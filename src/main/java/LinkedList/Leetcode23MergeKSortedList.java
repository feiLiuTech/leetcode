package LinkedList;

import java.util.*;

public class Leetcode23MergeKSortedList {
    public static void main(String[] args) {
        Leetcode23MergeKSortedList test=new Leetcode23MergeKSortedList();
        ListNode l1=CreatList.creadList("1 3 5 7 9");
        ListNode l2=CreatList.creadList("2 4 6 8 10");
        ListNode [] lists=new ListNode[]{l1,l2};
        ListNode head=test.mergeKLists_2020_0911(lists);
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }

    }

    /**
     * 两两合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists_2020_0911(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }
        ListNode head=lists[0];
        for(int i=1;i<lists.length;i++){
            head=mergeTwoList(head, lists[i]);
        }
        return head;
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2){

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

    /**
     * 最小堆
     * @param lists
     * @return
     */
//    public ListNode mergeKLists_2_2020_0911(ListNode[] lists) {
//        if(lists==null || lists.length==0){
//            return null;
//        }
//        PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>(new Comparator<ListNode>(){
//            @Override
//            public int compare(ListNode o1, ListNode o2){
//                if(o1.val>o2.val){
//                    return 1;
//                }else if(o1.val<o2.val){
//                    return -1;
//                }else{
//                    return 0;
//                }
//
//            }
//        });
//
//
//        for(int i=0;i<lists.length;i++){
//            pq.add(lists[i]);
//        }
//        ListNode dummy=new ListNode(0);
//        ListNode cur=dummy;
//        while(!pq.isEmpty()){
//            ListNode node=pq.poll();
//            cur.next=node;
//            cur=cur.next;
//            if(node.next!=null){
//                pq.offer(node.next);
//            }
//        }
//        return dummy.next;
//    }

    /**
     * 分治法
     * @param lists
     * @return
     */
    public ListNode mergeKLists_3_2020_0911(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }
        return mergeSort(0,lists.length-1,lists);

    }
    public ListNode mergeSort(int L, int R, ListNode[] lists){
        if(L>=R){
            return lists[L];
        }
        int mid=(R-L)/2+L;
        ListNode l1=mergeSort(L, mid, lists);
        ListNode l2=mergeSort(mid+1, R, lists);
        return mergeTwoList(l1,l2);
    }


}


/**
 * 分治法
 */
class Leetcode23_2020_0911{
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */


    public ListNode mergeKLists(ListNode[] lists) {
            if(lists==null || lists.length==0){
                return null;
            }
            return mergeSort(0,lists.length-1,lists);
        }
        public ListNode mergeSort(int L, int R, ListNode[] lists){
            if(L>=R){
                return lists[L];
            }
            int mid=(R-L)/2+L;
            ListNode l1=mergeSort(L, mid, lists);
            ListNode l2=mergeSort(mid+1, R, lists);
            return mergeTwoList(l1,l2);
        }


        public ListNode mergeTwoList(ListNode l1, ListNode l2){

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
}