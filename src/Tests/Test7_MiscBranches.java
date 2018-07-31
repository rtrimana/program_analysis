
/** Test7_MiscBranches
 *
 * @author      Rahmadi Trimananda <rahmadi.trimananda @ uci.edu>
 * @version     1.0
 * @since       2016-10-03
 */

public class Test7_MiscBranches {

	public Test7_MiscBranches() {}

	public int field;

	public int LiveCode(int x) {

		int a, b;
		a = 5;
		b = 4;
		int c = x/0;	// Division-by-zero
		int d = field;	// Field dereference
		field = b;
		
		if (a == b)
			return a + b;
		
		while (a > 0) {
			System.out.println("Decrement a!");
			a = a - 1;
		}
		
		switch (b) {
			case 0: System.out.println("b is zero!"); break;
			case 1: System.out.println("b is one!"); break;
			default: System.out.println("b is > one!"); break;
		}
		
		for(int i=0; i < 3; i++) {
			System.out.println("Entering for loop!");
		}
		
		return 4;
	}
	
	public int DeadCode(int e) {

		int c, d;
		c = 5;	// Dead!
		d = 4;
		int f = e/0;
		
		if (c == d)
			return 1;
		
		while (d > 0) {
			System.out.println("Decrement a!");
			d = d - 1;
		}
		
		switch (d) {
			case 0: System.out.println("d is zero!"); break;
			case 1: System.out.println("d is one!"); break;
			default: System.out.println("d is > one!"); break;
		}
		
		for(int i=0; i < 3; i++) {
			System.out.println("Entering for loop!");
		}
		
		return 5;
	}
	
	public static void main(String[] args) {
		
		Test7_MiscBranches test = new Test7_MiscBranches();
		System.out.println("Return value: " + test.LiveCode(23));
		System.out.println("Return value: " + test.DeadCode(5));
	}
}
