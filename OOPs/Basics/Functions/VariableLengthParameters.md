
## Variable Length Arguments(var agrs)

```java
import java.util.Arrays;

public class VariableLengthParameters {
    static void fun(int a,int b,int ...x) {
        // now x is an array of integers
        // var args should be last in the parameters
        
        System.out.println(Arrays.toString(x));
    }

    public static void main(String[] args) {
        fun(1,2,3,4,5,5,6);
        // this will print all the arguments passed
    }
}
```

## Shadowing:

Function ke bahar agr koi variable initialized h to function ke andar bhi same variable phir se initialize ho sakta hai<br>
Lekin same function ke andar same variable dobara initialize nhi ho sakta (Function scope only)<br>
Shadowing, function-scope hai block-scope nahi

```java
    Class Demo{
        static int x = 10;
        public static void main(String[] args){
            int x = 100; // valid: it is called shadowing
            sout(x); // o/p : 100
            
            {
                int x = 20; // gives error as x is already defined in psvm.
                x = 20; // this will work fine bcz you're not re-initializing it, this is the reason for-loop runs even if i is defined outside
            }

            // scoping in for loop

            int i = 10;
            for(int i = 0; i < 10; i++){
                // this will give error as i is already defined in the scope
            }

            int i = 10;
            for(i = 0; i < 10; i++){
                // this will work fine as i is being re-assigned multiple times(10 times)

            }
        }
    }
```

## Method Overloading
Same class me, 2 methods `exactly` same nhi ho sakte.<br>
Ya to methods ke naam change kro, ya number of parameters change kro,
ya parameters ka data type change kro.