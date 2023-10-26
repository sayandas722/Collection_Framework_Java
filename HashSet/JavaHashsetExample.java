import java.util.*;
public class JavaHashsetExample {
  public static void main(String[] args) {
    //creating hashset to store car names
    System.out.println("Creating a new HashSet to store car names.");
    HashSet<String> cars = new HashSet<String>();

    //adding the car names to the hashset
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("BMW"); // Adding a duplicate element
    cars.add("Mazda");
    System.out.println("HashSet after adding car names: " + cars);

    //checking if the set contains a specific car
    System.out.println("Checking if 'Mazda' is present in the HashSet: " + cars.contains("Mazda"));

    //removing a specific car from the set
    cars.remove("Volvo");
    System.out.println("HashSet after removing 'Volvo': " + cars);

    //finding the size of the set
    System.out.println("Size of the HashSet: " + cars.size());

    //implementing iterator method to iterate over the elements
    System.out.println("Iterating over the elements in the HashSet:");
    Iterator<String> itr=cars.iterator();  
    while(itr.hasNext()){  
      System.out.println(itr.next());  
    }

    //removing all the elements from the set
    cars.clear();
    System.out.println("HashSet after clearing all elements: " + cars);
  }
}
