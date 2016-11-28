package Distributed;
import java.lang.Exception;
import java.util.Objects;

/**
 * Created by terrysun on 11/28/16.
 */
public class Tester {

    BlockingQueue aBQ=new BlockingQueue(20);

    public void provider(Object item){

        try {
            aBQ.enqueue(item);
        }
        catch (Exception e)
        {

        }
    }

    public void consumer()
    {

        try {
            aBQ.dequeue();
        }
        catch (Exception e)
        {

        }

    }

}
