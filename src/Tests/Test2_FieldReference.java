
/** Test2_FieldReference
 *
 * @author      Rahmadi Trimananda <rahmadi.trimananda @ uci.edu>
 * @version     1.0
 * @since       2016-10-03
 */
public class Test2_FieldReference {

	private int a;
	private double b;

	public Test2_FieldReference() {}

	public void LiveCode() {

		int c, d, e;
		c = 5;
		d = c + 3;
		e = d + 6;
		a = c + d + e;
	}
	
	public void DeadCode() {

		double x, y, z;
		x = 1.03;
		y = x + 2.06;
		z = y - x;	// Dead!
		b = x + y;
	}


	public static void main(String... args) {

		Test2_FieldReference test = new Test2_FieldReference();
		test.LiveCode();
		test.DeadCode();
	}
}