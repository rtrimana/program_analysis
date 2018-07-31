
/** Test1_ReturnStatement
 *
 * @author      Rahmadi Trimananda <rahmadi.trimananda @ uci.edu>
 * @version     1.0
 * @since       2016-10-03
 */
public class Test1_ReturnStatement {

	public Test1_ReturnStatement() {}

	public String LiveCode() {

		int a = 3;
		String b = "I have " + Integer.toString(a) + " balloons";
		return b;
	}
	
	public int DeadCode() {
		int x, y, z;
		x = 1;
		y = x + 2;
		z = y +4;	// Dead!
		return 1;
	}

	public static void main(String[] args) {

		Test1_ReturnStatement test = new Test1_ReturnStatement();
		System.out.println("Test: " + test.LiveCode());
		System.out.println("Test: " + test.DeadCode());
	}
}
