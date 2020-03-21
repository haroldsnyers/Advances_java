package exercise4.client;

import exercise4.Task;
import java.io.Serializable;

public class IntegerAdder implements Task<Integer>, Serializable {

  int A;
  int B;

  public IntegerAdder(int a, int b){
    A = a;
    B = b;
  }

  @Override
  public Integer execute() {
    return A+B;
  }
}
