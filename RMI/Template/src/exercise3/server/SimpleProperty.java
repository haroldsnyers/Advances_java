package exercise3.server;

import exercise3.PropertyRepository;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple implementation of {@link PropertyRepository} using methods of class {@code Collections}. For test purposes, the
 * {@code toString()} method displays the name of the current thread.
 *
 * Note: methods {@code sort} and {@code reverseSort} do not throw {@code RemoteException}. This demonstrates that this
 * exception is not thrown by the server code, but rather by the RMI runtime when a communication failure is detected in
 * the object's stub, on the client side.
 *
 */

public class SimpleProperty implements PropertyRepository {

  public Map<String,String> attributes;

  public SimpleProperty() {
    attributes = new HashMap<String, String>();
  }

  @Override
  public String getProperty(String key) {
    System.out.println("Getting the attribute value...");
    return this.attributes.get(key);
  }

  @Override
  public void setProperty(String key, String value) {
    System.out.println("Setting a new attribute...");
    this.attributes.put(key, value);
  }

  @Override
  public void removeProperty(String key) {
    System.out.println("Removing the attribute...");
    this.attributes.remove(key);
  }

  @Override
  public String toString() {
    return "SimpleProperty " + Thread.currentThread();
  }

}
