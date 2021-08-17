package Interview;

import sun.dc.pr.PRError;
import java.util.Deque;
import java.util.LinkedList;

public class Test{
    public static Deque<Integer> dq=new LinkedList<Integer>();
    public int capaicty;
    public Test(int capaicty){
        this.capaicty=capaicty;
    }
    public static void main(String[] args) {
        //我们规定队列的容量
        Test test=new Test(20);
        //首先进行new生产者
        Product product=new Product(10);
        //new消费之
        Consummer consummer=new Consummer();

    }
}


class Consummer extends Thread {
    Test test;
    public void consumer(){
        //进行消费数字
        //在消费之前判断是否队列为空
        if(test.dq.isEmpty()){
            //如果为空了。需要进行等待
        }else{
            //如果不为空，那么进行消费
            test.dq.removeFirst();
        }

    }

}

class Product{
    Test test;
    private int size;//表示生产的数量
    public Product(int size){
        this.size=size;
    }
    public void product(int num){
        //在生成之前判断队列的是否满了
        if(test.capaicty==test.dq.size()){
            //说明队列已经满了，那么需要进行等待队列有空间

        }else{
            //生产一个数字放入队列中

            test.dq.addLast(num);

        }
        //产生数字放入队列中

    }


}