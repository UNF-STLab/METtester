import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class iniTest {
	@Test
	   public void initial_test1() {
	     int a[] = {1,2,1,2,1};
	     int b[] = {4,2,3,2,5};
	     MethodCollection2 tf = new MethodCollection2();
	     int initial_output = tf.dot_product(a,b);
		 assertEquals(20,initial_output);
	   }
	@Test
	   public void initial_test2() {
	     int a[] = {1,2,1,2,1};
	     MethodCollection2 tf = new MethodCollection2();
	     int initial_output =  tf.add_values(a);
		 assertEquals(7,initial_output);
	   }
}
