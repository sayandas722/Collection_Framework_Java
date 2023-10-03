import java.util.*;

// Collections -> It is a Class (plural)
// Collection -> It is an Interface (Singular)

public class ClassRoom {

   // Function for Swapping the elements in an ArrayList
   public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
      int temp = list.get(idx1);
      list.set(idx1, list.get(idx2));
      list.set(idx2, temp);
   }

   // Function for Storing Water Problem -> (Brute Force method)
   // Time Complexity-> O(n^2)

   public static int maxStoreWater2(ArrayList<Integer> ht) {
      int mx = 0;
      for (int i = 0; i < ht.size(); i++) {
         for (int j = i + 1; j < ht.size(); j++) {
            int height = Math.min(ht.get(i), ht.get(j));
            int width = j - i;
            int totalWater = height * width;
            mx = Math.max(mx, totalWater);
         }
      }
      return mx;
   }

   // Function for Storing Water Problem -> (Optimized method)
   // Using Two Pointer Approach -> T.C -> O(n)
   public static int maxStoreWater(ArrayList<Integer> ht) {
      int mx = 0;
      int s = 0, e = ht.size() - 1;
      while (s < e) {
         int height = Math.min(ht.get(s), ht.get(e));
         int width = e - s;
         int totalWater = height * width;
         mx = Math.max(mx, totalWater);
         if (ht.get(s) < ht.get(e)) {
            s++;
         } else {
            e--;
         }
      }
      return mx;
   }

   // Function for finding the Pair Sum using two Pointer Approach (can only be
   // used if List is sorted)
   public static boolean PairSum(ArrayList<Integer> list, int target) {
      Collections.sort(list);
      int s = 0, e = list.size() - 1;
      while (s < e) {
         if (list.get(s) + list.get(e) == target) {
            return true;
         } else if (list.get(s) + list.get(e) > target) {
            e--;
         } else {
            s++;
         }
      }
      return false;
   }

   // Function for checking whether the function is Monotonic or not
   public static boolean MonotonicOrNot(ArrayList<Integer> list) {

      boolean inc = true;
      boolean dec = true;

      for (int i = 0; i < list.size() - 1; i++) {
         if (list.get(i) > list.get(i + 1)) {
            inc = false;
         }
         if (list.get(i) < list.get(i + 1)) {
            dec = false;
         }
      }
      return inc || dec;
   }

   // Function for finding the lonely Integer (i.e element with neither have a
   // previous element nor the next element)
   public static ArrayList<Integer> findLonely(ArrayList<Integer> ht) {
      Collections.sort(ht);
      ArrayList<Integer> list = new ArrayList<>();
      for (int i = 1; i < ht.size() - 1; i++) {
         if (ht.get(i - 1) + 1 < ht.get(i) && ht.get(i) + 1 < ht.get(i + 1)) {
            list.add(ht.get(i));
         }
      }

      if (ht.size() == 1) {
         list.add(ht.get(0));
      }

      if (ht.size() > 1) {
         if (ht.get(0) + 1 < ht.get(1)) {
            list.add(ht.get(0));
         }

         if (ht.get(ht.size() - 2) + 1 < ht.get(ht.size() - 1)) {
            list.add(ht.get(ht.size() - 1));
         }
      }

      return list;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      ArrayList<Integer> ht = new ArrayList<>();
      // Adding an element in an Arraylist can be done using add Function...!
      ht.add(0);
      ht.add(2);
      ht.add(3);
      ht.add(4);
      ht.add(5);
      ht.add(12);
      ht.add(7);
      ht.add(6);
      ht.add(9);

      System.out.println(ht);

      // To get any value at any index we use get function...!
      int element = ht.get(2);
      System.out.println(element);

      // To remove an element from the List we use remove function
      ht.remove(2);
      System.out.println(ht);

      // To set a value at any index in the ht we use set function
      ht.set(2, 20);
      System.out.println(ht);

      // To check if the ht contains that element of not we use contains function
      // A type of boolean function that return true or false accordingly
      System.out.println(ht.contains(1));
      System.out.println(ht.contains(21));

      // We can also use add function to add element at any index
      ht.add(2, 15);
      System.out.println(ht);

      // To calculate the size of ArrayList we use size() method
      System.out.println(ht.size());

      // We can also use the size() function to iterate through an Arrayht like
      for (int i = 0; i < ht.size(); i++) {
         System.out.print(ht.get(i) + " ");
      }

      // Function to print reverse of an ArrayList
      for (int i = ht.size() - 1; i >= 0; i--) {
         System.out.print(ht.get(i) + " ");
      }

      // function to find Max in an ArrayList
      int mx = Integer.MIN_VALUE;
      for (int i = 0; i < ht.size(); i++) {
         // if(mx < list.get(i)) {
         // mx = list.get(i);
         // }
         mx = Math.max(mx, ht.get(i));
      }
      System.out.println("Maximum Element is: " + mx);

      // Function for Swapping the elements in an ArrayList
      int idx1 = 1, idx2 = 3;
      swap(ht, idx1, idx2);
      System.out.println(ht);

      // for Sorting and Swapping the ArrayList we can use these methods
      // Collections.sort(list); // Sort the list in ascending order
      Collections.swap(ht, 1, 3);
      Collections.sort(ht, Collections.reverseOrder()); // Sort the list in descending order

      // Creating a Multi-dimensional ArrayList, can be done as
      ArrayList<ArrayList> mainList = new ArrayList<>();
      ArrayList<Integer> list2 = new ArrayList<>();
      ArrayList<Integer> list3 = new ArrayList<>();
      ArrayList<Integer> list4 = new ArrayList<>();

      for (int i = 1; i <= 5; i++) {
         list2.add(i * 1);
         list3.add(i * 2);
         list4.add(i * 3);
      }

      mainList.add(list2);
      mainList.add(list3);
      mainList.add(list4);

      for (int i = 0; i < mainList.size(); i++) {
         ArrayList<Integer> currentList = mainList.get(i);
         for (int j = 0; j < currentList.size(); j++) {
            System.out.print(currentList.get(j) + " ");
         }
         System.out.println();
      }

      // Ques. Container with most water...! (brute force Approach)
      // Time Complexity -> O(n^2) -> Can be Further Optimized using "Two Pointer
      // Approach" -> O(n);
      System.out.println("Max Water that can be Stored: " + maxStoreWater(ht));

      // Function for checking whether the function is Monotonic or not
      System.out.println(MonotonicOrNot(ht));

      // Function for checking whether the element is lonely or not
      System.out.println(findLonely(ht));

   }
}
