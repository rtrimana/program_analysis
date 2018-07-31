
/** Test5_ConditionalStatement
 *
 * @author      Rahmadi Trimananda <rahmadi.trimananda @ uci.edu>
 * @version     1.0
 * @since       2016-10-03
 */

public class Test5_ConditionalStatement {

	public Test5_ConditionalStatement() {}

	public int LiveCode() {

		int a, b;
		a = 5;
		b = 4;
		
		if (a == b)
			return a + b;
		else
			return a - b;
	}
	
	public int DeadCode() {

		int c, d;
		c = 5;	// Dead!
		d = 4;  // Dead!
		
		if (true)
			return 1;
		else {
			d = d + 3;
			return d;
		}
	}

	public static void main(String[] args){

		Test5_ConditionalStatement test = new Test5_ConditionalStatement();
		System.out.println("Test: " + test.LiveCode());
		System.out.println("Test: " + test.DeadCode());

	}


}
