package executors;

import threads.MyThread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Demonstrates the basic operation of executors.
 *
 * @author Jean-Michel Busca
 */
public class ExecutorBasicsDemonstrator {

  public static void main(String[] args) throws InterruptedException {

    // Run the three tasks of exercise 1.1 using an Executor

    ExecutorService executorService = Executors.newFixedThreadPool(3);

    Thread thread1 = new MyThread("thread1");
    Thread thread2 = new MyThread("thread2");
    Thread thread3 = new MyThread("thread3");

    executorService.submit(thread1);
    executorService.submit(thread2);
    executorService.submit(thread3);
//    Callable<String> callableTask = () -> {
//      String name = Thread.currentThread().getName();
//      for (int i = 0; i < 1_000_000; i += 1) {
//        if (i % 100_000 == 0) {
//          TimeUnit.MILLISECONDS.sleep(30);
//          System.out.println(name + ": i=" + i);
//
//        }
//      }
//      return "Task's execution";
//    };

    Collection<Callable<Thread>> callableTasks = new ArrayList<>();
    callableTasks.add(thread1);
    callableTasks.add(thread2);
    callableTasks.add(thread3);

    executorService.invokeAll(callableTasks);

    executorService.shutdown();
    try {
      if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
        executorService.shutdownNow();
      }
    } catch (InterruptedException e) {
      executorService.shutdownNow();
    }

    //
    System.out.println("method main: done");

  }

}
