package lambdas;

public interface AnyTypeTester<T> {
    /**
     * Test the specified object for some property.
     *
     * @param any the object to test
     *
     * @return true if the specified object passes the test and false otherwise.
     */
    boolean test(T any);
}
