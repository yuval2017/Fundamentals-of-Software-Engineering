import junit.framework.Assert;
import org.junit.Test;

public class RegistrationSystemTests extends ShowTests {

	@Override
	public void setUp() {


	}

	@Test
	public void testRegistrationForShow(){

		int[] seats = {20, 21,22};
		Assert.assertTrue(registerToShow("Bar", "0527715033", seats));


	}

	@Test
	public void testBadRegistrationForShow(){

		int[] seats = {20, 21,22};
		Assert.assertFalse(registerToShow("Amir", "0594856325", seats));
	}


	@Test
	public void testSadRegistrationForShow(){

		int[] seats = {20, 21,22};
		Assert.assertTrue(registerToShow("Bar", "0527715033", seats));
		Assert.assertTrue(registerToShow("Yuval", "0545682459", seats));
	}


}
