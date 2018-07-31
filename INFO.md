### There are two work flows :

1. .java -----`Soot Framework( standalone)/ custom Transform built using soot`--------> Intermediate representation-------`javac compiler`------------>.class, bytecode files
2. `Maunally set scene and manually add classes, methods and units and other artifacts`------>Intermediate representation------->, .class, .bytecode



### There are four main types of intermediate representations
1. Baf
2. Jimple (Important)
3. Shimple
4. Grimp


### Fundamental Soot objects

1. #### Body
    Every code in java resides in a method. Main method is often the entry point in a piece of code remember? There are four kinds of Body in Soot - namely, 
        
        1.BafBody
        2.JimpleBody
        3.ShimpleBody
        4.GrimpBody
    one for each intermediate representation.

2. #### Chain
    Also, recall that a chain is a list-like data structure providing constant-time access to chain elements, including insertion and removal.
    There are three types of elements in Soot

        1.unit
        2.local
        3.trap

    There are three types of chains in Soot 

        1.units chain
        2.locals chain
        3.traps chain

    Different types of chain elements here are

    1. ##### Local

        Local is nothing but a variable in the program.
        The collection of Locals is stored in the localChain and accessible via body.getLocals().
        Each intermediate representation may define its own implementation of Local; 
        however, it must always be possible, 
        for every Local r0, to call r0.getName(), r0.getType(), r0.setName() and r0.setType.
        Note that local variables must be typed.

    2. ##### Traps

        To support Java exception handling, Soot Body's define the notion of traps. The idea is that in Java bytecode, exception handlers are represented by a tuple (exception, start, stop, handler); between the start and stop units (including start, but not including stop), if the exception is thrown, execution continues at handler.

    3. ##### Units

        Units are statements in the method. It can literally be anything and there are multiple interpretation of the assignment.
        The methods actually make up the body. Each IR has different representation of the a unit.
        
            1. `jimple` has a `Stmt` implementation of the `unit`
            2. `Grimp` provides a `Inst` implementation of the `unit`

        There are different types of `unit` implementations in the same IR itself, for different kinds of statements in the code.
        for example in jimple (whichc provides an `Stmt` implementation)  provides an `AssignStmt` for statements/units which are assignments like below

        ```
        x = y + 6;
        ```

3. #### Value

    The lines of code are represented as units in Soot. But the the data this code is acting on is represented as Values objects 
    There can be many different types of Values 

        1. Locals
        2. Constants
        3. Expressions(Expr)
        4. ParameterRefs, CaughtExceptionRefs and ThisRefs.