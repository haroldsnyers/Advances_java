package threads;

/**
 * Demonstrates the basic operation of threads.
 *
 * @author Jean-Michel Busca
 */
public class ThreadBasicsDemonstrator {

  public static void main(String[] args) throws InterruptedException {

    // Note: when the JVM initializes, it starts a non-daemon thread whose
    // purpose is to execute the main method of the class
    System.out.println("method main: run by " + Thread.currentThread());

    // start thread1 (which is an instance of the MyThread class)
    System.out.println("method main: starting thread1");
    Thread thread1 = new MyThread("thread1");
    // setting daemon on the threads enables the JVM to terminate the program when
    // the main method ends
    // thread1.setDaemon(true);
    thread1.start();

    // start thread2 (using an instance of the MyRunnable class)
    System.out.println("method main: starting thread2");
    Thread thread2 = new Thread(new MyRunnable(), "thread2");
    // thread2.setDaemon(true);
    thread2.start();

    Thread.sleep(5000);
    // https://www.javaspecialists.eu/archive/Issue056.html
    thread2.interrupt();

    // start thread3 (using a lambda expression)
    System.out.println("method main: starting thread2");
    Thread thread3 = new Thread(() -> {
      String name = Thread.currentThread().getName();
      for(int i=0; i <= 10000000; i+=100000) {
        System.out.println(name + ": i="+ i);
        try {
          Thread.sleep(2);
        } catch(Exception e) {
          e.printStackTrace();
        }
      }
    }, "thread3");
    // thread3.setDaemon(true);
    thread3.start();

    // By using Thread .join method we demand that the main thread waits for
    // the completion of the joined threads
    // need to add "throws InterruptedException" to use join
    thread1.join();
    thread2.join();
    thread3.join();



    System.out.println("method main: done");

  }

}
