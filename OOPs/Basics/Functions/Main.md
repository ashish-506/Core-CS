Functions inside class is called method<br>
So every function in JAVA is called a Method<br>
Method overloading aata hai to usko nhi cover kiya hai inn files me


`syntax:`<br>
```js
access_modifier return_type name_of_function(data_type parameters){
    body;
    return statement;
}
```
Classes ke andar function kahi prr bhi declare kiya jaa sakta hai zaruri nahi ki call krne se pehle declare hi krna hai.

In java, there is only `pass by ref. value`
```js
    func(String naam){
        naam = "kunal";
    }
    String name = "ashish";
    func(name); //this is not going to change name to "kunal";
    //it will be something like name : "ashish" and naam : "kunal". Strings are immutable in JAVA so are other wrapper objects like Integer.
```

Agr 2 variables ki value same hai, to ye JAVA ke upar hai ki vo heap me 2 alg values create krta hai
ya phir dono variables ko same memory location me point krwata hai

In case of Arrays/Objects, it is not pass by ref., it is pass by the copy of the value of the ref. (basically copy of memory add.)

```java
import java.util.Arrays;

public class Main {
    public static void changeArr(int[] arr){
        arr[0] = 99;
        arr = new int[] {10,20,30,40};
        arr[0] = 500;
        // agr pass by ref. jaisi cheez hoti to myArr ki value {10,20,30,40} ho jaani chahiye thi
        // ya phir at-least myArr[0] 500 ho jaana chahiye tha lekin aisa kuchh nhi hoga
        // c++ me alias bnte time ek hi box ke 2 naam ho jaate hai lekin JAVA me pass by ref. jaisi kuchh cheez nahi hoti
        // that means Arrays/Objects ke case me JAVA ek naya varible banata hai jisme vo same address/pointer hota hai jo argument me pass kiya jaata hai
        // mtlb ab ek hi box ke 2 naam nahi hai 2 alg boxes hai jo same memory ko point kr rhe hai
        // jb arr = new int[] kiya gya to naye wale box ne alg memory ko point krna start kr diya
        // as a result bss shuru me arr[0] = 99 wale change hi original array(myArr) ki value change krenge kyuki uss time tk dono same memory ko point kr rhe the
        // ya phir aisa keh sakte hai ki dono ne same hi referrence store kiya tha heap ki memory ka
        // jaise hi arr = new int[] kiya ab arr ko koi aur referrence value mil gya ek naye array ka, heap me
    }

    public static void main(String[] args) {
        int[] myArr = {1, 2, 3};
        changeArr(myArr);
        System.out.print(Arrays.toString(myArr)); // o/p will be: {99,2,3}
    }
    // Ques: Phir swap(a,b) jaise functions honge hi nahi JAVA me? Hrr baar swap ka code likhna padega?
}
```