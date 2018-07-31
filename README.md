# program_analysis
An example of how we can use the Soot environment to do program analysis in Java

###Please supply `rt.jar` file in the second class path while running the transform. It can usually be found at `$JAVA_HOME/jre/lib/rt.jar`  

The first assignment of Program Analysis class - Fall 2016

# What we're trying to do?

We will write an optimization pass. We will implement a dead code elimination pass with the following characteristics:
1) This pass tries to detect recursively the presence of essential/anchor statements:
	- Method invocations
	- Field references (including global fields)
	- Array references
	- Return statements (also preserves void returns)
	- Conditional branches, e.g. loops (while, for, etc.), if-statements (including switch-case)
2) In a recursive manner, the method goTagStatement will try to tag statements as LIVE or DEAD with the 
	following conditions:
	- Essential/anchor statements are always LIVE
	- Other statements, i.e. non-essentials, that are chained in some way with the essential/anchor statements
	  are tagged as LIVE
	- Otherwise, those other statements are tagged as DEAD
3) Some special conditions:
	- Field and array references are always considered as LIVE
	- Field and array dereferences depend on the variables dereferencing the field / array. If the variable is
	  connected in some way and pass its value to other variables that end up being connected with an 
	  essential/anchor statement, then it is LIVE. It is DEAD otherwise.
4) Optimized code behaves the same as the original code for executions in which the original code does not throw 
any exceptions. This means that we can safely optimize away statements that could cause exceptions, e.g. 
division-by-zero, etc., but they are never chained to any of the essential/anchor statements.



# How to run the optimization:

_**Note: USE JAVA Version 7 ONLY**_ 

1. Extract tar ball.
2. Navigate to src folder `cd src/`.
3. Modify the Makefile accordingly by setting up the path to rt.jar and setting up the path to soot.2.5.0.jar 
4. Use the GNU Make utility to run `make`.



# Directory structure (important files/folders):


1. src/ folder has all the src code for the project.
2. `Adapter.java` loads the target class and applies the transform to it.
3. `Buster.java` contains the actual code for the transformation.
4. `RJUtils.java` contains some static methods for testing for live anchor statements.
5. `Status.java` contains a tag implementation for use in buster to tage code as dead or alive.
6. src/Tests folder contains all the test files we used as test suite for this pass.

By Rahmadi Trimananda and Joel Bandi
