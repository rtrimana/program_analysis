import soot.options.*;

import soot.*;
import soot.jimple.*;
import soot.toolkits.scalar.*;
import soot.util.*;
import soot.toolkits.graph.*;
import java.util.*;

/** Class RJUtils is a class that provides some methods
 *  to help the transform class do dead code elimination.
 *  This class mainly provides detection to the units
 *  in a body to recognize any of these essential/anchor
 *  statements:
 *
 *  1) Method invocation
 *  2) Array reference
 *  3) Field reference (both global and local)
 *  4) Return statement
 *  5) Conditional branches, e.g. if-statement, 
 *     loops (while, for, etc.), switch-case, etc.
 *
 * @author      Rahmadi Trimananda <rahmadi.trimananda @ uci.edu>
 * @version     1.0
 * @since       2016-10-02
 */
public class RJUtils
{
	/**
	 * Class static methods
	 */
	public static boolean isMethodInvocation(Stmt stmt) {
		
		return stmt.containsInvokeExpr();
	}

	public static boolean isArrayReference(Stmt stmt) {
		
		if (stmt.containsArrayRef() && isImportantReference(stmt))
			return true;
		else
			return false;
	}

	/**
	 * [isFieldReference] detects field references
	 * <p>
	 * Global variables are declared as global fields
	 * so global assignments fall into this category
	 * as well.
	 */
	public static boolean isFieldReference(Stmt stmt) {

		if (stmt.containsFieldRef() && isImportantReference(stmt))
			return true;
		else
			return false;	
		//return stmt.containsFieldRef();
	}
	
	public static boolean isReturnStatement(Stmt stmt) {
		
		if (stmt instanceof ReturnStmt)
			return true;
		else
			return false;
	}
	
	public static boolean isReturnVoidStatement(Stmt stmt) {
		
		if (stmt instanceof ReturnVoidStmt)
			return true;
		else
			return false;
	}
	
	public static boolean isGotoStatement(Stmt stmt) {
		
		if (stmt instanceof GotoStmt)
			return true;
		else
			return false;
	}

	public static boolean isConditionalStatement(Stmt stmt) {
		
		if (stmt instanceof IfStmt)
			return true;
		else
			return false;
	}
	
	public static boolean isSwitchStatement(Stmt stmt) {
		
		if ((stmt instanceof LookupSwitchStmt) ||
			(stmt instanceof TableSwitchStmt))
			return true;
		else
			return false;
	}

	public static boolean isAnchor(Stmt stmt) {
		return (isMethodInvocation(stmt)	|| 
				isArrayReference(stmt) 		|| 
				isFieldReference(stmt)		|| 
				isReturnStatement(stmt) 	|| 
				isGotoStatement(stmt) 		|| 
				isConditionalStatement(stmt)||
				isSwitchStatement(stmt)		||
				isReturnVoidStatement(stmt));
	}

	/** [isImportantReference] Detects if we have field or array reference (LHS)
	 *  <p>
	 *  Such a variable is to be removed!
	 */
	public static boolean isImportantReference(Stmt stmt) {
		
		List<ValueBox> listvb = stmt.getDefBoxes();
		
		if(!(listvb.size() == 0)){

			for(ValueBox vb: listvb) {
				System.out.println("Def: " + vb.getValue());
				if ((vb.getValue() instanceof ArrayRef) || (vb.getValue() instanceof FieldRef)) {
					
					// If LHS is an ArrayRef or FieldRef then this is an anchor!
					return true;

				}
			}

		}
		return false;
	}

}
