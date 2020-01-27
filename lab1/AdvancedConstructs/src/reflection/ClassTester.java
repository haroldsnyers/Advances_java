package reflection;

import annotations.TestClass;
import annotations.definition.TestSpec;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @professor Jean-Michel Busca
 * @author Harold
 */
public class ClassTester {

  private static class MethodDesc implements Comparable<MethodDesc> {

    private final Method method;
    private final int number;

    public MethodDesc(Method method, int number) {
      this.method = method;
      this.number = number;
    }

    @Override
    public int compareTo(MethodDesc other) {
      return number - other.number;
    }

  }

  public static <T> void testClass(Class<T> clazz, String testName) {

    // get methods with annotation @TestSpec and test = testName
    List<MethodDesc> methods = new ArrayList<>();
    for (Method method : clazz.getDeclaredMethods()) {
      if (false) { // select exercise 3.4
        // exercise 3.3
        TestSpec spec = method.getDeclaredAnnotation(TestSpec.class);
        if (spec != null && spec.test().equals(testName)) {
          methods.add(new MethodDesc(method, spec.order()));
        }
      } else {
        // exercise 3.4
        // adds every TestSpec found for method (for used is it can
        // pass if there are 0, 1 or more TestSpec for the method
        for (TestSpec spec : method.getDeclaredAnnotationsByType(TestSpec.class)) {
          if (spec.test().equals(testName)) {
            methods.add(new MethodDesc(method, spec.order()));
          }
        }
      }
    }
    // sort method descriptors by test order
    Collections.sort(methods);

    // execute methods in order
    try {
      // first create an object of the class
      T instance = ClassIntrospector.invokeDefaultConstructor(clazz);
      // then execute the methods on the object
      for (MethodDesc descriptor : methods) {
        descriptor.method.invoke(instance);
      }
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
      throw new IllegalArgumentException();
    }
  }

  public static void main(String[] args) {

    System.out.println("executing test \"\":");
    testClass(TestClass.class, "");

    System.out.println("executing test \"test1\":");
    testClass(TestClass.class, "test1");

    System.out.println("executing test \"test2\":");
    testClass(TestClass.class, "test2");

  }
}
