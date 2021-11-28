import junit.framework.TestCase;

public class ShowManagerTests extends TestCase {

	private ShowManagerBridge bridge;
	private int MLProjectCode;
	private int QCProjectCode;

	public void setInterface(boolean isReal) {
		bridge = isReal ? new ShowManagerRealBridge() : new ShowManagerProxyBridge();
	}

	public void setUp() throws Exception{
		super.setUp();

		bridge = Drive.getBridge();

		MLProjectCode = bridge.addShow(999,"Machine Learning", "Reverse Propagation Algorithm", 99, "John Doe", "BGU");
		bridge.adminCreateShow(313754389, "Machine Learning");

		QCProjectCode = bridge.addShow(1, "Quantum Cryptography", "Defending against quantum adversary", 2, "Or Sattath", "BGU");
		bridge.adminCreateShow(318764780, "Quantum Cryptography");
		bridge.changeShowHour(1, "Approved");

		bridge.addAdmin("Azam Maraee", 208892355);
		bridge.addUser(208214478, "matanel", "1234", 4);
		bridge.addUser(209261023, "orel", "1234", 2);
	}

	@Override
	public void tearDown() throws Exception{

		super.tearDown();
		bridge.removeUser(208214478);
		bridge.removeUser(209261023);
		bridge.removeAdmin("John Doe", 313754389);
		bridge.removeAdmin("Or Sattath", 318764780);
		bridge.removeAdmin("Azam Maraee", 208892355);

	}

	protected int addShow(int projectId, String projectName, String projectDescription, int estimatedTime, String proposerCredentials, String organization){
		return bridge.addShow(projectId, projectName, projectDescription, estimatedTime, proposerCredentials, organization);
	}

	protected boolean isShowExists(int projectId){
		return bridge.isShowExists(projectId);
	}


	protected int registerToShow(int[] studentIds, int lecturerId, int projectId){
		return bridge.registerToShow(studentIds, lecturerId, projectId);
	}


	protected boolean addUser(int studentId, String username, String password, int year){
		return bridge.addUser(studentId, username, password, year);
	}

	protected boolean removeUser(int studentId){
		return bridge.removeUser(studentId);
	}

	protected boolean loginUserShow(String username, String password){
		return bridge.loginUserShow(username, password);
	}

}
