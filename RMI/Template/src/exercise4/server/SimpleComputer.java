package exercise4.server;

import exercise4.Computer;
import exercise4.Task;
import java.rmi.RemoteException;

public class SimpleComputer implements Computer {

  @Override
  public <T> T execute(Task<T> task) {
    return task.execute();
  }
}
