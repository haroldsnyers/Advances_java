package exercise4.client;

import exercise4.Task;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class StringSorter implements Task<List<String>>, Serializable {

  List<String> list;

  public StringSorter(List<String> l){
    list = l;
  }

  @Override
  public List<String> execute() {

    System.out.println(this + ": receveid " + list);

    Collections.sort(list);

    System.out.println(this + ": returning " + list);
    return list;
  }
}
