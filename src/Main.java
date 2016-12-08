import Distributed.BlockingQueue;
import Distributed.Consumer;
import Distributed.Producer;
import java.lang.System;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

//        List<Integer> aList=new ArrayList<Integer>();
//
//        ClassLoader loader = Main.class.getClassLoader();
//        System.out.println(loader);
//        System.out.println(loader.getParent());
//        System.out.println(loader.getParent().getParent());
//
//        try {
//            loader.loadClass("test2");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        aList.add(null);
//        aList.add(null);
//        aList.add(null);
//
//        System.out.println("aList.size()=" + aList.size());


        testBlockingQueue();


    }


    public static void testBlockingQueue() {
        BlockingQueue queue = new BlockingQueue(300);

        Producer producer = new Producer(queue);

        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();


        try {
            Thread.currentThread().sleep(1000);
        }
        catch (Exception e)
        {

        }

        //for (int i=0;i<10;i++) {
        while(queue.size()>0)  {

            new Thread(consumer).start();
        }

        try {
            System.in.read();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}

