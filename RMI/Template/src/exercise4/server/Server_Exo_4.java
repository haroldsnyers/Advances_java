package exercise4.server;

import static exercise1.server.Registry.REGISTRY_PORT;

import exercise3.PropertyRepository;
import exercise3.server.SimpleProperty;
import exercise4.Computer;
import exercise4.Task;
import exercise4.client.IntegerAdder;
import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.CompletableFuture;

/**
 * Server program.
 * <p>
 * Note: After the main method exits, the JVM is still running. This is because
 * the skeleton implements a non-daemon listening thread, which waits for
 * incoming requests forever.
 */
public class Server_Exo_4 {

  //
  // CONSTANTS
  //
  private static final String SERVICE_NAME = "Computer";

  //
  // MAIN
  //
  public static void main(String[] args) throws Exception {

    // check the name of the local machine (two methods)
    System.out.println("server: running on host " + InetAddress.getLocalHost());
    System.out.println("server: hostname property " + System
        .getProperty("java.rmi.server.hostname"));

    // instanciate the remote object
    Computer computer = new SimpleComputer();
    System.out.println("server: instanciated SimpleProperty");

    // create a skeleton and a stub for that remote object
    // note: the stub is for client use only; it will be passed to the client via the registry
    Computer stub = (Computer) UnicastRemoteObject
        .exportObject(computer, 0);
    System.out.println("server: generated skeleton and stub");

    // register the remote object's stub in the registry
    Registry registry = LocateRegistry.getRegistry(REGISTRY_PORT);
    registry.rebind(SERVICE_NAME, stub);
    System.out.println("server: registered remote object's stub");

    // main terminates here, but the JVM still runs because of the skeleton
    System.out.println("server: ready");

  }

}
