import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class linkedlist {
  public static void main(String[] args) {
    LinkedList<String> ddd = new LinkedList<String>();
    Collections.reverse(ddd);
    ddd.add("Deepanshu");
    ddd.add("dinesh");
    ddd.add("yogesh");
    ddd.add("enter some volues ");
    ddd.add("ramlal");
    ddd.push("ffff");
    ddd.add(Integer.toString((int) (Math.random() * 10)));
    System.out.println(ddd);
    ddd.remove();
    System.out.println("after remove " + ddd);
    ddd.pop();
    System.out.println("after pop a element" + ddd);
    Collections.reverse(ddd);
    System.out.println("after reverce" + ddd);
    Iterator<String> it = ddd.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
    Collections.sort(ddd, Collections.reverseOrder());
    System.out.println("abhi ye h " + ddd);
    ArrayList<String> arr = new ArrayList<String>();
    arr.add("null");
    arr.addAll(0, ddd);
    // arr.addAll(ddd);
    System.out.println("ye wala g " + arr);
    HashMap<Integer, String> hash = new HashMap<>();
    for (String string1 : arr) {
      hash.put(null, string1);
      System.out.println(hash.values());
    }
    HashSet<String> fff = new HashSet<>(20, 0.25f);
    fff.addAll(ddd);
    System.out.println(fff);
  }
}
