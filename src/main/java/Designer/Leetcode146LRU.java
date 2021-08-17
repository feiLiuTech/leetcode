package Designer;

import org.omg.PortableInterceptor.INACTIVE;


import java.util.HashMap;
import java.util.Map;

/**
 * 注意事项1：removeLast函数再调用remove函数的时候，不需要再size--
 * 注意事项2：Doublist的dummyHead和dummyTail要new空间
 * 注意事项3：put函数中如果map中存在key,那么首先先获取链表节点，特别注意要更新新的值
 */
class Node{
    int key;
    int value;
    public Node next;
    public Node pre;
    public Node(int key, int value){
        this.key=key;
        this.value=value;
    }


}
class DoubleList{
    public Node dummyHead=new Node(0,0);
    public Node dummyTail=new Node(0,0);
    private int size;
    public DoubleList(){
        dummyHead.next=dummyTail;
        dummyTail.pre=dummyHead;
    }
    public void addFirst(Node node){
        node.next=dummyHead.next;
        node.pre=dummyHead;
        dummyHead.next.pre=node;
        dummyHead.next=node;
        size++;
    }
    //删除的节点一定存在
    public void remove(Node node){
        //先看看是否链表为空
        if(dummyHead.next==dummyTail){
            return ;
        }
        node.pre.next=node.next;
        node.next.pre=node.pre;
        size--;
    }
    public Node removeLast(){
        if(dummyHead.next==dummyTail){
            return null;
        }
        Node node=dummyTail.pre;
        remove(node);
        //注意这里remove函数已经将size减掉了
        return node;
    }
    public int getSize(){
        return size;
    }

}
public class Leetcode146LRU {
    private int capacity;
    private DoubleList cache;
    private Map<Integer,Node> map;
    public Leetcode146LRU(int capacity){
        this.capacity=capacity;
        cache=new DoubleList();
        map=new HashMap<Integer, Node>();
    }
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }else{
            Node node=map.get(key);
            //将这个节点移动到头部
            cache.remove(node);
            cache.addFirst(node);
            return node.value;
        }
    }

    public void put(int key, int value){
        Node node=new Node(key, value);
        if(!map.containsKey(key)){
            if(cache.getSize()>=capacity){
                //先删除尾部节点腾出空间
                Node lastnode=cache.removeLast();
                if(lastnode!=null){
                    map.remove(lastnode.key);
                }

            }
            cache.addFirst(node);
            map.put(key, node);
        }else{

            node=map.get(key);
            //如果存在需要更新节点的值
            node.value=value;
            cache.remove(node);
            cache.addFirst(node);
        }
    }
}