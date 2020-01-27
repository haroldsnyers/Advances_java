package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @professor Jean-Michel Busca
 * @author Harold
 */
public class ClassIntrospector {

  public static <T> void printMethods(Class<T> clazz) {
    String className = clazz.getCanonicalName();
    Method[] methods = clazz.getDeclaredMethods();
    for (Method method : methods) {
      String methodName = method.getName();
      int parameterCount = method.getParameterCount();
      System.out.println(className + "." + methodName
              + "(<#" + parameterCount + " parameter(s)>)");
    }
    Class<? super T> superClass = clazz.getSuperclass();
    if (superClass != null) {
      printMethods(superClass);
    }
  }

  public static <T> T invokeDefaultConstructor(Class<T> clazz) {
    Constructor<?>[] constructors = clazz.getConstructors();
    Constructor<T> defaultConstructor = null;
    for (Constructor constructor : constructors) {
      if (constructor.getParameterCount() == 0) {
        defaultConstructor = constructor;
        break;
      }
    }
    if (defaultConstructor == null) {
      throw new IllegalArgumentException();
    }
    try {
      return defaultConstructor.newInstance();
    } catch (ReflectiveOperationException e) {
      throw new IllegalArgumentException();
    }
  }

  public static void main(String[] args) {

    System.out.println("Object");
    printMethods(Object.class);

    System.out.println("Sequence");
    printMethods(generics.Sequence.class);

    System.out.println("ArrayList");
    printMethods(java.util.ArrayList.class);

    String string = invokeDefaultConstructor(String.class);
    System.out.println("string=\"" + string + "\"");

    Object object = invokeDefaultConstructor(Object.class);
    System.out.println("object=\"" + object + "\"");
  }
}
