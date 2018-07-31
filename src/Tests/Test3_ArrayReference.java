
/** Test3_ArrayReference
 *
 * @author      Rahmadi Trimananda <rahmadi.trimananda @ uci.edu>
 * @version     1.0
 * @since       2016-10-03
 */
public class Test3_ArrayReference {

	public Test3_ArrayReference() {}

	public int test;

	public void LiveCode() {

		int a = 5, b = 3, c[] = {2,3};
		c[0] = a;
		c[1] = b;
	}
	
	public int[] DeadCode() {

		int d, f[] = {1, 2, 3};
		int g = test;
		f[0] = g;
		d = f[0];	// Dead!

		return f;
	}


	public static void main(String... args){

		Test3_ArrayReference test = new Test3_ArrayReference();
		test.LiveCode();
		System.out.println("Test: " + test.DeadCode());
	}
}
