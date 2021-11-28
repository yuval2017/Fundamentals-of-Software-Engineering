import org.junit.Assert;
import org.junit.Test;

public class LoginSystemTests extends  ShowManagerTests {

	@Override
	public void setUp() throws Exception{
		super.setUp();
	}

	@Test
	public void testLogin(){
		try{
			Assert.assertTrue(loginUserShow("matanel", "1234"));
		} catch (Exception e){
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testSadLogin(){
		try{
			Assert.assertFalse(loginUserShow("orel", "1234"));
		} catch (Exception e){
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testBadLogin(){

		String sqlInjection = "' Or 'a' = 'a";
		try{
			Assert.assertFalse(loginUserShow(sqlInjection, sqlInjection));
		} catch (Exception e){
			Assert.fail(e.getMessage());
		}
	}
}
