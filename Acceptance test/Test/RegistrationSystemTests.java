import junit.framework.Assert;
import org.junit.Test;

public class RegistrationSystemTests extends ShowManagerTests {

	@Override
	public void setUp() throws Exception{


	}

	@Test
	public void testRegistrationForProject(){

		try{
			int[] ids = {209261023, 208214478};
			Assert.assertTrue(registerToShow(ids, 318764780, 1) > 0);
		} catch (Exception e){
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testSadRegistrationForProject(){

		try{
			int[] ids = {209261023, 208214478};
			Assert.assertFalse(registerToShow(ids, 208892355, 123) > 0);
		} catch (Exception e){
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testBadRegistrationForProject(){
		try{
			int[] maliciousIds = {209261023, 208214478};
			int maliciousLecturerId = 127371283;
			int maliciousProjectId = 1982361287;
			Assert.assertFalse(registerToShow(maliciousIds , maliciousLecturerId , maliciousProjectId) > 0);
		} catch (Exception e){
			Assert.fail(e.getMessage());
		}
	}




}
