package exercise4.client;

import exercise4.Computer;
import exercise4.Task;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.List;

public class Client_Exo_4 {

  private static final String SERVICE_NAME = "Computer";
  private static final String SERVICE_HOST = "localhost";
  private static final int REGISTRY_PORT = 1099;

  public static void main(String[] args)
      throws RemoteException, NotBoundException {
    // locate the registry that runs on the remote object's server
    Registry registry = LocateRegistry.getRegistry(SERVICE_HOST, REGISTRY_PORT);
    System.out.println("client: retrieved registry");

    // retrieve the stub of the remote object by its name
    Computer computer = (Computer) registry.lookup(SERVICE_NAME);
    System.out.println("client: retrieved Sorter stub");

    // call the remote object to perform sorts and reverse sorts
    List<String> list = Arrays.asList("3", "5", "1", "2", "4");
    System.out.println("client: sending " + list);

    Task<List<String>> stringSorter = new StringSorter(list);
    list = computer.execute(stringSorter);
    System.out.println("client: received " + list);

    int a = 1;
    int b = 1;

    System.out.println("client: sending " + a + " + " + b);
    Task<Integer> integerAdder = new IntegerAdder(a,b);
    Integer adder = computer.execute(integerAdder);
    System.out.println("client: received " + adder);

    // main terminates here
    System.out.println("client: exiting");
  }

}
