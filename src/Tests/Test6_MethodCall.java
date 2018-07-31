
/** Test6_MethodCall
 *
 * @author      Rahmadi Trimananda <rahmadi.trimananda @ uci.edu>
 * @version     1.0
 * @since       2016-10-03
 */

public class Test6_MethodCall {

	public Test6_MethodCall() {}
	
	private int TestCall(int a) {

		return a + 35;
	}

	public int LiveCode() {

		int b, c;
		b = 5;
		c = b + 7;
		c = TestCall(c);
		
		return c;
	}
	
	public int DeadCode() {

		int b, c;
		b = 5;
		c = b + 7;	// Dead!
		c = TestCall(b);
		
		return c;		
	}

	public static void main(String[] args){

		Test6_MethodCall test = new Test6_MethodCall();
		System.out.println("Test: " + test.LiveCode());
		System.out.println("Test: " + test.DeadCode());
		
	}

}