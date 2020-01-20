package lambdas;

/**
 * Interface that defines only one abstract method: test().
 *
 * @author Jean-Michel Busca
 */

// this is a functional interface because it contains only one abstract method
// putting this @FunctionalInterface does not permit the interface to be sth else
@FunctionalInterface
public interface StringTester {

  /**
   * Test the specified string for some property.
   *
   * @param string the string to test
   *
   * @return true if the specified string passes the test and false otherwise.
   */
  boolean test(String string);

  // putting this function generates errors after because the interface isn't functional anymore
  // lamba and other methods only work with functional interfaces
  // void bar();
}
