import junit.framework.Assert;
import org.junit.Test;

public class AddShowPManagerTests extends ShowManagerTests {

	@Override
	public void setUp() throws Exception{


	}


	@Test
	public void testSuccessfulAdd(){

		try{
			Assert.assertTrue(addShow(4,
					"Quantum Computing",
					"The Hadamard Gate",
					1,
					"Or Sattath", "BGU") > 0);
			Assert.assertTrue(isShowExists(4));
		}
		catch (Exception e){
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testBadAdd(){

		try {
			Assert.assertTrue(addShow(100,
					"Machine Learning",
					"Reverse Propagation Algorithm",
					99,
					"John Doe", "BGU") <= 0);
			Assert.assertFalse(isShowExists(100));
		}
		catch (Exception e){
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testSadAdd(){

		try {
			Assert.assertTrue(addShow(0,
					"DROP TABLE *",
					"DROP TABLE *",
					10000,
					"DROP TABLE *", "DROP TABLE *") <= 0);
			Assert.assertFalse(isShowExists(0));
		}
		catch (Exception e){
			Assert.fail(e.getMessage());
		}
	}



}
