package exercise3.client;

import exercise1.Sorter;
import exercise3.PropertyRepository;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.List;

/**
 * Client program.
 * <p>
 * Note: In order to retrieve the stub of the remote object, the client needs to
 * know (1) the name of the remote object, (2) the machine that hosts it.
 */
public class Client_Exo_3 {

  //
  // CONSTANTS
  //
  private static final String SERVICE_NAME = "PropertyRepository";
  private static final String SERVICE_HOST = "localhost";
  private static final int REGISTRY_PORT = 1099;

  //
  // MAIN
  //
  public static void main(String[] args) throws Exception {

    // locate the registry that runs on the remote object's server
    Registry registry = LocateRegistry.getRegistry(SERVICE_HOST, REGISTRY_PORT);
    System.out.println("client: retrieved registry");

    // retrieve the stub of the remote object by its name
    PropertyRepository SP = (PropertyRepository) registry
        .lookup(SERVICE_NAME);
    System.out.println("client: retrieved PropertyRepository stub");

    // call the setProperty

    String key = "Smits";
    String value = "Victor";
    System.out.println("client: sending (" + key + ", " + value + ")");
    SP.setProperty(key, value);
    System.out.println("the attribute has been set");

    String key2 = "Snyers";
    String value2 = "Harold";
    System.out.println("client: sending (" + key2 + ", " + value2 + ")");
    SP.setProperty(key2, value2);
    System.out.println("the attribute has been set");

    // call the getProperty
    key = "Smits";
    System.out.println("client: sending " + key);
    value = SP.getProperty(key);
    System.out.println("client: received " + value);

    // call the getProperty
    key2 = "Snyers";
    System.out.println("client: sending " + key2);
    value2 = SP.getProperty(key2);
    System.out.println("client: received " + value2);

    // call the removeProperty
    key = "Smits";
    System.out.println("client: sending " + key);
    SP.removeProperty(key);
    System.out.println("the attribute has been removed");

    // call the getProperty
    key = "Smits";
    System.out.println("client: sending " + key);
    value = SP.getProperty(key);
    if(value != null){
      System.out.println("client: received " + value);
    }else{
      System.out.println("client: Key does not exist");
    }


    // call the getProperty
    key2 = "Snyers";
    System.out.println("client: sending " + key2);
    value2 = SP.getProperty(key2);
    if(value2 != null){
      System.out.println("client: received " + value2);
    }else{
      System.out.println("client: Key does not exist");
    }


    // main terminates here
    System.out.println("client: exiting");

  }

}
