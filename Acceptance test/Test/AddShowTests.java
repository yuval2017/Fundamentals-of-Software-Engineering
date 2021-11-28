import junit.framework.Assert;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;

public class AddShowTests extends ShowTests {

	private ShowBridge bridge;
	@Override
	public void setUp() {


	}


	@Test
	public void testSuccessfulAdd(){

		loginUser("Azam Maraee", "121");
		Assert.assertTrue(addShow("Agam Habarburim", "Lovely ballete show.", "Habima",LocalDate.of(2022,1,20),40,LocalDate.of(2022,1,10)));

	}

	@Test
	public void testBadAdd(){

		loginUser("Azam Maraee", "121");
		Assert.assertFalse(addShow("Agam Habarburim", "Lovely ballete show.", "Habima",LocalDate.of(2022,1,20),40,LocalDate.of(2021,5,10)));

	}

	@Test
	public void testSadAdd(){

		loginUser("Azam Maraee", "121");
		Assert.assertTrue(addShow("Agam Habarburim", "Lovely ballete show.", "Habima",LocalDate.of(2022,1,20),Integer.MAX_VALUE+1,LocalDate.of(2021,5,10)));

	}
	@Test
	public void testHiddenAssumptionAAdd(){

		loginUser("Azam Maraee", "121");
		Assert.assertTrue(addShow("Agam Habarburim", "Lovely ballete show.", "Habima",LocalDate.of(2022,1,20),40,LocalDate.of(2022,1,10)));

	}
	@Test
	public void testBadHiddenAssumptionAAdd(){
		loginUser("Yuval", "123");
		Assert.assertFalse(addShow("Agam Habarburim", "Lovely ballete show.", "Habima",LocalDate.of(2022,1,20),40,LocalDate.of(2022,1,10)));

	}

	@Test
	public void testHiddenAssumptionBAdd(){
		loginUser("Azam Maraee", "121");
		addShow("Agam Habarburim", "Lovely ballete show.", "Habima",null,40,LocalDate.of(2022,1,10));
		Assert.assertNull(getShowHour("Agam Habarburim"));
	}
	@Test
	public void testBadHiddenAssumptionBAdd(){
		loginUser("Azam Maraee", "121");
		addShow("Agam Habarburim", "Lovely ballete show.", "Habima",null,40,LocalDate.of(2022,1,10));
		Assert.assertNotNull(getShowHour("Agam Habarburim"));
	}


}
