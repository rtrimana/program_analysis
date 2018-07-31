
/** Test4_GlobalAssignment
 *
 * @author      Rahmadi Trimananda <rahmadi.trimananda @ uci.edu>
 * @version     1.0
 * @since       2016-10-03
 */

public class Test4_GlobalAssignment {

	public Test4_GlobalAssignment() {}

	public void LiveCode() {

		int a, b;
		a = 5;
		b = 4;
		GlobalVariable.globalA = a + b;
	}
	
	public String DeadCode() {

		String s;
		s = GlobalVariable.globalB;	// Dead!
		
		return GlobalVariable.globalB;
	}

	public static void main(String... args){

		Test4_GlobalAssignment test = new Test4_GlobalAssignment();
		test.LiveCode();
		System.out.println("Test: " + test.DeadCode());

	}
}