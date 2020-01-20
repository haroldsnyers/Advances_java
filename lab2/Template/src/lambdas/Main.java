package lambdas;

/**
 * Demonstrates the use of anonymous classes, lambda expressions and method
 * references.
 *
 * @author Jean-Michel Busca
 */
public class Main {

  /**
   * Checks whether the specified strings all pass the specified test.
   *
   * @param strings the strings to check
   * @param tester the string tester to use
   *
   * @return true if the specified strings all pass the test, and false
   * otherwise
   */
  private static boolean checkStrings(String[] strings, StringTester tester) {
    // go through all the specified strings
    for (String string : strings) {
      // test the current string using the specefied tester object
      if (!tester.test(string)) {
        return false;
      }
    }
    return true;
  }

  /**
   * @param items items of type T to test
   * @param tester general test method
   * @param <T> any type of object
   * @return true or false depending on the result of the test
   */
  private static<T> boolean checkObjects(T[] items , AnyTypeTester<T> tester){
    for (T item : items) {
      // test the current string using the specified tester object
      if (!tester.test(item)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {

    // the strings we want to test
    String[] strings = {"123", "abc", "you"};

    // Test #1: do all string start with "A"?
    // We use an instance of the StringStartsWithA class as the tester object
    boolean ok1 = checkStrings(strings, new StringStartsWithA());
    System.out.println("all strings starts with \"a\": " + ok1);

    // Test #2: are all strings 3-character long?
    // We use an instance of an anonymous class as the tester object
    boolean ok2 = checkStrings(strings, new StringTester() {
      @Override
      public boolean test(String string) {
        return string.length() == 3;
      }
    });
    // lamba expression to simplify expression just above
    boolean ok3 = checkStrings(strings, string -> string.length() == 3);

    System.out.println("all strings are 3-character long: " + ok2);
    System.out.println("all strings are 3-character long: " + ok3);

    // Test #3: are all strings equal to "foo"?
    // Your turn: use a lambda expression to define the tester
    // ... Your turn
    boolean ok4 = checkStrings(strings, string -> string.equals("foo"));
    System.out.println("all strings are equal to foo: " + ok4);
    boolean ok5 = checkStrings(strings, string -> !string.equals("foo"));
    System.out.println("all strings are different from foo: " + ok5);

    boolean ok7 = checkStrings(strings, string -> "foo".equals(string));
    System.out.println("all strings are equal to foo: " + ok7);

    // Test #4: are all strings equal to "foo"? (same test as above)
    // Your turn: use method reference to define the tester
    // ... Your turn
    // object reference -> Object::<method_name>
    boolean ok6 = checkStrings(strings, "foo"::equals);
    System.out.println("all strings are equal to foo: " + ok6);

    // with/without parenthesis for the parameter list
    boolean ok8 = checkStrings(strings, string -> string.equals("foo"));
    boolean ok9 = checkStrings(strings, (string) -> string.equals("foo"));

    // with/without parameter types,
    boolean ok10 = checkStrings(strings, string -> string.equals("foo"));
    boolean ok11 = checkStrings(strings, (String string) -> string.equals("foo"));
    // with/without a bloc for the lambda’s body
    boolean ok12 = checkStrings(strings, string -> string.equals("foo"));
    boolean ok13 = checkStrings(strings, string -> { return string.equals("foo");});

    boolean ok14 = checkStrings(strings, string -> string.startsWith("A"));

    Integer[] integers = {1, 4, 6};
    boolean ok15 = checkObjects(integers, integer -> integer <= 10);
    System.out.println("all integers are smaller than 10: " + ok15);

  }


}
