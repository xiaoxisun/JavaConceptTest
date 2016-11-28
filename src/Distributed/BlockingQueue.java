package Distributed;
//import java.util.concurrent.ArrayBlockingQueue;
import java.util.LinkedList;
import java.util.List;
import java.lang.InterruptedException;
import java.lang.System.*;
/**
 * Created by terrysun on 11/14/16.
 */
public class BlockingQueue {

    private List queue=new LinkedList();
    private int limit=10;


    public BlockingQueue(int limit){
        this.limit=limit;
    }


    public synchronized void enqueue(Object item)
    throws InterruptedException
    {
        while (this.queue.size()==this.limit)
        {

            System.out.println("enqueue wait: queue size"+ this.queue.size());
            wait();
        }


        System.out.println("enqueue:" + item.toString());

        this.queue.add(item);

        notifyAll();
    }


    public synchronized void dequeue()
        throws InterruptedException
    {
        while (this.queue.size()==0)
        {
            System.out.println("dequeue wait: queue size"+ this.queue.size());
            wait();
        }

        System.out.println("dequeue:" + queue.get(0).toString());

        this.queue.remove(0);

        notifyAll();
    }

}


