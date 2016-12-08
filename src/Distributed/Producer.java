package Distributed;
import java.util.Random;
/**
 * Created by terrysun on 11/28/16.
 */
public class Producer implements Runnable{

    protected BlockingQueue queue=null;

    public Producer(BlockingQueue queue)
    {
        this.queue=queue;
    }

    public void run()
    {
        try
        {
            Random rand = new Random();
            int x=rand.nextInt(100000);
            System.out.println("producer enqueue number: "+x);
            for (int j=0;j<x;j++)
                queue.enqueue(j+";");

        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
