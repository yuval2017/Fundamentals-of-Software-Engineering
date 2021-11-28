import org.junit.Assert;
import org.junit.Test;

public class LoginSystemTests extends ShowTests {

	@Override
	public void setUp() throws Exception{
		super.setUp();
	}

	@Test
	public void testLogin(){

			Assert.assertTrue(loginUser("Bar", "123"));

	}

	@Test
	public void testSadLogin(){

			Assert.assertFalse(loginUser("Yuval", "124"));

	}

	@Test
	public void testBadLogin(){

		String Injection = "' Or 'x' => 'x";
		Assert.assertFalse(loginUser(Injection, Injection));

	}
}
