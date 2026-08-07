Classes aur Objects ki definition to pta hi hai ya google bhi krr sakte hai

for detailed notes refer to [this](https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/lectures/17-oop/notes/classes.txt)

Variables which an object can access are called `instance variables`. Variables inside the object.<br>
Variables which are used to point to the object are called `reference variables`.<br>
The dot operator links the name of the object with the name of an instance variable.

`new` keyword dynamically allocates memory to the object at `runtime` & returns a `reference` to it.

`runtime` means the program is running after all the compilation, it's a process now.

```
Box mybox; // declare reference to object
mybox = new Box(); // allocate a Box object
```

The first line declares mybox as a reference to an object of type Box. At this point, mybox does not yet refer to an
actual object. The next line allocates an object and assigns a reference to it to mybox. After the second line executes,
you can use mybox as if it were a Box object. But in reality, mybox simply holds, in essence, the memory address of the
actual Box object.<br>
`The key to Java’s safety is that you cannot manipulate references as you can actual pointers.
Thus, you cannot cause an object reference to point to an arbitrary memory location or manipulate it like an integer.`

A Closer Look at new:<br>
```
classname x = new classname ( );
```
Here, x is a variable of the class type being created. The classname is the name of the class that is being
instantiated. The class name followed by parentheses specifies the constructor for the class. A constructor defines
what occurs when an object of a class is created.

```
Box b1 = new Box();
Box b2 = b1;
```
b1 and b2 will both refer to the same object. The assignment of b1 to b2 did not allocate any memory or copy any part
of the original object. It simply makes b2 refer to the same object as does b1. Thus, any changes made to the object
through b2 will affect the object to which b1 is referring, since they are the same object.<br>
When you assign one object reference variable to another object reference variable, you are not creating a copy of the
object, you are only making a copy of the reference.
## Making a constructor
If you don't create your own constructor then you will get a default constructor Student(), with no parameters.<br>
But if you have created your own constructor then you can't use this default constructor anymore unless you create your own default constructor.

Once defined, the constructor is automatically called when the object is created, before the new operator completes.<br>
Constructors look a little strange because they have no return type, not even void.<br>
This is because the implicit return type of a class’ constructor is the class type itself.

Any class will have a default constructor, does not matter if we declare it in the class or not. If we inherit a class,
then the derived class must call its super class constructor. It is done by default in derived class.<br>
If it does not have a default constructor in the derived class, the JVM will invoke its default constructor and call
the super class constructor by default. If we have a parameterised constructor in the derived class still it calls the
default super class constructor by default. In this case, if the super class does not have a default constructor,
instead it has a parameterised constructor, then the derived class constructor should call explicitly call the
parameterised super class constructor.
```java
class Student{
    int roll;
    String name;
    float marks = 49f; // default value of every object if no-one modifies it.
    
    Student(int r,String s){
        // Constructor, a special function with name same as className
        this.roll = r;
        this.name = s;
        // 'this' will refer to the reference variable which has called the constructor
        // but w/o 'this' the code will work fine. Like roll = r, name = s... will do the job,
        // then why to use 'this'??
        // if the parameters in the constructor have the same name as the variables, 
        // Student(int roll,String name), then you have to do this.roll = roll && this.name = name;
        // otherwise the object will not get initialized and will show the default value, roll = 0, name = null;
    }
    
    // default constructor
    
    Student(){
        // calling constructor from another constructor
        this(12,"ashish");
        // internally it is same as: new Student(12,"ashish")
    }
}
```
There is `Constructor overloading` same as Method overloading.

> You might be wondering why you do not need to use new for such things as integers or characters.

The answer is that Java’s primitive types are not implemented as objects.
Rather, they are implemented as “normal” variables.<br>
This is done in the interest of efficiency.
Primitives are stored in stack memory.

### The this Keyword:
Sometimes a method will need to refer to the object that invoked it. To allow this, Java defines the `this` keyword.
`this` can be used inside any method to refer to the current object. That is, `this` is always a reference to the object on
which the method was invoked.

### final Keyword:
A field can be declared as `final`. Doing so prevents its contents from being modified, making it, essentially, a constant.
**This means that you must initialize a final field when it is declared**.<br>
`final` sirf variables hi nahi hote, classes bhi `final` hote hai, jaise `String`, `Integer` etc.

It is a common coding convention to choose all uppercase identifiers for final fields:
````     
final int FILE_OPEN = 2;
````

Unfortunately, `final` guarantees immutability only when instance variables are `primitive` types, not reference types.
If an instance variable of a reference type has the `final` modifier, `the value of that instance variable` (the reference
to an object) will never change—it will always refer to the same object—but the value of the object itself can change.
E.g.
```java
final Student kunal = new Student();

kunal.name = "something"; 
// this is valid,as final will allow to change 'value' of the reference type datatype
// but you can't do something like this: 
Student x = new Student();
kunal = x; // this is not allowed, or kunal = new Student();
```
### The finalize( ) Method:
Sometimes an object will need to perform some action when it is destroyed.<br>
To handle such situations, Java provides a mechanism called `finalization`. By using finalization,
you can define specific actions that will occur when an object is just about to be reclaimed by the garbage collector.
To add a `finalizer` to a class, you simply define the `finalize()` method. The Java run time calls that method whenever
it is about to recycle an object of that class. Right before an asset is freed, the Java run time calls the finalize( )
method on the object.

Like `Constructor` are special functions in class `finalize()` is also like that, a destructor.

To `finalize()` class level prr likha jaata hai, let's say Student class me constructor ke sath ek `finalize(){}` method bhi likh diya gya, to ye function hrr baar call hoga jb bhi
Student class ka `koi bhi` object destroy hoga(garbage collector ke zariye)

````
protected void finalize( ) {
    // finalization code here
}
````
