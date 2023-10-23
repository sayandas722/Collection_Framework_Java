import java.util.*;
public class Main {
  public static void main(String[] args) {
    //creating hashset
    HashSet<String> cars = new HashSet<String>();
    //adding the car names
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("BMW");
    cars.add("Mazda");
    System.out.println(cars);
    //check is the car is present in the hashset
    System.out.println(cars.contains("Mazda"));
    //remove the mentioned car from the set
    cars.remove("Volvo");
    System.out.println(cars);
    //find the set size
    System.out.println(cars.size());
    cars.add("Ford");
    //implement iterator method
    Iterator<String> itr=cars.iterator();  
    while(itr.hasNext()){  
      System.out.println(itr.next());  
    }  
    //removes all the elements from the set
    cars.clear();
    System.out.println(cars);
  }
}
