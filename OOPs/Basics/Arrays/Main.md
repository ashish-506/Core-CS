`syntax:` `datatype[] ref_variable_name = new datatype[size];`

E.g. <br>
`int[] arr = new int[5];` <br>
`int[] arr = {10,20,40,40};`<br>
yaha `=` ke left side wali cheez compile time prr hoti hai, aur right side(heap memory) runtime prr(dynamic memory allocation)

Arrays in java can be continuous or non-continuous, depends on JVM. Kyuki java me pointers jaisi koi cheez nahi hoti to continuous rakhne ka koi jabarjasti nahi hai.
C++ me pointer arithmatic hota tha isiliye continuous rakha jaata tha like `4[arr]` was also a valid syntax in cpp.

```java
int[] roll; // declaration of array. roll is getting defined in the stack
roll = new int[5]; // initialization: actually here object is being created in the heap.

```

```java
int roll[] = new int[5]; // {0,0,0,0,0}
String name = new String[5]; // {null,null,null,null,null}
```

## Input in Arrays

```java
import java.util.Arrays;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            // length is not a function in java, it's property of an array
            arr[i] = in.nextInt();

            System.out.print(arr[i] + " ");
        }
        
        // you can print by converting it to string 
        System.out.println(Arrays.toString(arr));
        
        // for-each loop in java(same)
        for (int num : arr) System.out.print(num + " ");
        // Ques: C++ me to for(int &num: arr) bhi krr sakte the, kya isme kr skte hai aisa kuchh?
        // like time complexity prr kya asar padta hai iska
    }
}
```

## Array Passing in Methods
Array is an object, so `arr[0]` means `0th` index of this array.

So when you do `arr[1] = 39;`, you're telling change the `1st` index of `this array object` arr.
You're not creating new array, just modifying the value, something like `arr[1].value = 39`. It is the same object.

This is the reason that when you change the value of any index through methods, the parameter of the function contains
the ref. to the array and modifying the index is in-place.

```java
int x = 40;
int y = x;
y = 50;
```
This is not going to change the value of x. Because it will now create a new object `50` and y will be pointing
to this object in the memory. But changing value of any index in the array `doesn't` work like this.

# MultiDimension Arrays

`syntax : datatype[][] ref_variable_name = new datatype[#rows][#cols]`
<br>#cols is not necessary to define.

```java
int[][] arr = {
                {23,42,12,5},// 4 columns
                {23,12},// 2 columns
                {2,3,1,4,5,6,1,4,5} // 9 columns
            };
```

### Internal working:
```java
int[][] arr = {{},{},{},{}};
```
Imagine it as array-of-arrays, every element `{}` in the array is a reference to an array itself.
Inn elements ko aapas me koi mtlb nahi hai, hrr element ek alg array object ko point krega that's why hrr array ka size alg ho sakta hai.<br>
Hence column size can vary according to requirement.