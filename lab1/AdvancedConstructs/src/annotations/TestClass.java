package annotations;

import annotations.definition.TestSpec;

/**
 * @professor Jean-Michel Busca
 * @author Harold
 */
public class TestClass {

  @TestSpec(test = "test1", order = 1)
  @TestSpec(order = 3)
  public void foo() {
    System.out.println("foo");
  }

  @TestSpec(test = "test1", order = 2)
  @TestSpec(test = "test2", order = 2)
  @TestSpec(order = 2)
  public void bar() {
    System.out.println("bar");
  }

  @TestSpec(test = "test2", order = 1)

  @TestSpec(test = "test2", order = 3)
  @TestSpec(order = 1)
  public void baz() {
    System.out.println("baz");
  }

}
