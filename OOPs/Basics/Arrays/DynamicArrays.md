 # ArrayList
 `syntax: ArrayList<datatype> ref_var_name = new ArrayList<optional datatype>(initial size);`

```java
import java.util.ArrayList;
 import java.util.Scanner;

 public class ArrayListExamples {
     // generics
     ArrayList<Integers> list = new ArrayList<>(3);
     // could also be ArrayList<Integer>(3);
     // you can only use Wrapper-classes in datatypes, not primitives
    list.add(85);
    list.add(35);
    list.add(34);
    list.add(53);
     // search more about the array methods
     // get item by index
     Integer x = list.get(2);// x = 34
     
     for(int i = 0; i<list.length; i++){
         System.out.println(list.get(i)); // pass index here
         // list[index] syntax will not work here
     }
     
    System.out.println(list);

     // 2D ArrayList
     ArrayList<Arraylist<Integer>> list2 = new ArrayList<>(); // list2 is empty currently
     for(int i = 0; i< 3; i++){
         list2.add(new ArrayList<Integer>());
     }// list2 is now initialized with 3 ArrayLists. {{},{},{}}

     Scanner in = new Scanner
     // adding elements
     for(int i = 0; i< 3; i++){
         for (int j = 0; j < 3; j++) {
             list.get(i).add(in.nextInt());
         }
     }
     
     System.out.println(list2);
 }
```