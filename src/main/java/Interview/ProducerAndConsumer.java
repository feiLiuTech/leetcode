package Interview;

import com.oracle.jrockit.jfr.Producer;
import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerAndConsumer {

    private int capacity=10;
    public static void main(String[] args) {
        LinkedList<Integer> queue=new LinkedList<Integer>();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new Producer(queue,2));
        service.execute(new Producer(queue,2));
        service.execute(new Producer(queue,2));
        service.execute(new Consumer(queue));
        service.execute(new Consumer(queue));
        service.execute(new Consumer(queue));
    }


    static class Producer implements Runnable{

        LinkedList<Integer> queue;
        private int capacity;
        public Producer(LinkedList<Integer> queue, int capacity){
            this.capacity=capacity;
            this.queue=queue;
        }
        @Override
        public void run() {
            synchronized (queue){

                //队列满了需要等待
                while(queue.size()==capacity){
                    try {
                        queue.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                queue.add(1);
                System.out.println(Thread.currentThread().getName()+"生成了"+1+" 现在队列里有"+queue.size());
                queue.notifyAll();
            }
        }
    }

    static class Consumer implements Runnable{
        LinkedList<Integer> queue;

        public Consumer(LinkedList<Integer> queue){
            this.queue=queue;
        }
        @Override
        public void run() {
            try{
                synchronized (queue){
                    while(queue.isEmpty()){
                        queue.wait();
                    }
                    //满足条件进行消费
                    int i=queue.removeFirst();
                    queue.notifyAll();
                    System.out.println(Thread.currentThread().getName()+"消费了"+i+"还剩"+queue.size());

                }
            }catch (InterruptedException e){
                System.out.println(e.getStackTrace());
            }


        }
    }
}
