import soot.options.*;
import soot.*;
import soot.jimple.*;
import soot.jimple.internal.*;
import soot.toolkits.scalar.*;
import soot.util.*;
import soot.toolkits.graph.*;
import soot.tagkit.*;
import java.util.*;

/** Class Buster executes dead code elimination
 *  procedure. Basically, it does that in 3 steps:
 *
 *  1) Iterating through the code and tagging the lines as DEAD ...
 *  2) Until we find an essential statement and we add a LIVE tag
 *  3) We recursively check for non-essential statements that are
 *     connected to this essential statement and backtrack until
 *     we arrive at a stopping condition, e.g. the initial
 *     declaration of the variable, a non Local object, or a statement
 *     whose variable references the statement itself (to avoid having
 *     an infinite loop because of self referencing).
 *  4) We iterate over the body one more time and we delete the
 *     statements, whose final tag is DEAD.
 *
 * @author      Joel Bandi <jbandi @ uci.edu>
 * @author		Rahmadi Trimananda <rahmadi.trimananda @ uci.edu>
 * @version     1.0
 * @since       2016-10-05
 */


public class Buster extends BodyTransformer
{
	/**
	 * Class constants
	 */
    public static final String version = "v2.0.0";
    public static String version() {
        return ("Buster version " + Buster.version);
    }

    public final static String LIVESTATUS = "live";
    public final static String DEADSTATUS = "dead";

    public Buster() { }



	/** [internalTransform] Entry point for the transform
	 *  <p>
	 *  - Iterate through all Stmts in body and call goTagStatement on every anchor it finds 
	 * </p>
	 */
    protected void internalTransform(Body body, String phaseName, Map options){
		
		UnitGraph ugraph = new ExceptionalUnitGraph(body);
		LocalDefs locdef = new SimpleLocalDefs(ugraph);
		LocalUses locuse = new SimpleLocalUses(body, locdef);
		Stmt stmt;

		for(Unit unit : body.getUnits()) {

			stmt = (Stmt)unit;
			if (RJUtils.isAnchor(stmt)) {
				
				stmt.addTag(new Status(Buster.LIVESTATUS));
				goTagStatements(stmt, locdef, locuse);

			} else { 

				// Assume DEAD if not already marked LIVE
				if (!stmt.hasTag(Buster.LIVESTATUS)) {
					stmt.addTag(new Status(Buster.DEADSTATUS));
				}
			}
		}
		bustDeadCode(body,locuse);		
    }




	/** [goTagStatements] Recursively tagging statements
	 *  <p>
	 *  - Working backward starting from the essential anchor statements
	 *  - Statements connected to essential statements are tagged as LIVE
	 * </p>
	 */
	private void goTagStatements(Stmt stmt, LocalDefs locdef, LocalUses locuse) {

		stmt.addTag(new Status(Buster.LIVESTATUS));
		List<ValueBox> listvb = stmt.getUseBoxes();

		for(ValueBox vb : listvb) {
			if (vb.getValue() instanceof Local) {
				
				Local loc = (Local) vb.getValue();
				List<Unit> listUnit = locdef.getDefsOfAt(loc, stmt);
				for(Unit unit : listUnit) {
					
					// Skip if this is the same stmt object
					if (stmt == unit){
						continue;
					}
					goTagStatements((Stmt) unit, locdef, locuse);
				}

			} else {

				continue;			
			}
		}
		System.out.println();
	}




	/** [bustDeadCode] Iterates throught all the tagged stmt in the body and removes 'dead' tagged stmts
	 *  <p>
	 *  - It goes through each Stmt and checks the last tag attached to the stmt and deletes it if it's "dead"
	 * </p>
	 */
	private void bustDeadCode(Body body, LocalUses locuse){
		
		Chain units = body.getUnits();
		Iterator stmtIter = units.snapshotIterator();
		Stmt stmt;

		// Iterate over the body again and check the labels
		while(stmtIter.hasNext()) {

			stmt = (Stmt) stmtIter.next();
			List<Tag> listTag = stmt.getTags();

			// Remove the dead ones, Checking only the last tag
			String status = listTag.get(listTag.size() - 1).getName();
			
			if (status.equals(Buster.DEADSTATUS)) {

				units.remove(stmt);
			}
		}
	}
}
