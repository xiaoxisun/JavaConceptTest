package Distributed;

import java.util.Random;
//import org.apache.log4j.*;

/**
 * Created by terrysun on 11/28/16.
 */
public class Consumer implements Runnable {

    protected BlockingQueue queue=null;

    public Consumer(BlockingQueue queue){
        this.queue=queue;
    }

    public void run(){
        String threadId = String.valueOf(Thread.currentThread().getId());

        try {
            Random rand = new Random();
            int x=rand.nextInt(1000);
            System.out.println("Consumer "+threadId +" dequeue number: "+x);

            for (int i=0;i<x;i++)
                queue.dequeue();

        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }



    }

}
