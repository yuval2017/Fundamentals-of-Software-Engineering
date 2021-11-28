public class ShowManagerProxyBridge implements ShowManagerBridge {

	public ShowManagerRealBridge realBridge;

	@Override
	public int addShow(int projectId, String projectName, String projectDescription, int estimatedTime, String proposerCredentials, String organization) {
		if(realBridge != null){
			return realBridge.addShow(projectId, projectName, projectDescription, estimatedTime, proposerCredentials, organization);
		}
		throw new UnsupportedOperationException();
	}


	@Override
	public int registerToShow(int[] studentIds, int lecturerId, int projectId) {
		if(realBridge != null){
			return realBridge.registerToShow(studentIds, lecturerId, projectId);
		}
		throw new UnsupportedOperationException();
	}


	@Override
	public boolean loginManageShow(String username, int id) {
		if(realBridge != null){
			return realBridge.loginManageShow(username, id);
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean changeShowHour(int projectId, String status) {
		return false;
	}


	@Override
	public boolean isShowExists(int projectId) {
		if(realBridge != null){
			return realBridge.isShowExists(projectId);
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean loginUserShow(String username, String password) {
		return false;
	}

	@Override
	public boolean addAdmin(String name, int id) {
		return false;
	}

	@Override
	public boolean removeAdmin(String name, int id) {
		return false;
	}

	@Override
	public boolean adminCreateShow(int lecturerId, String projectName) {
		return false;
	}

	@Override
	public boolean addUser(int studentId, String username, String password, int year) {
		return false;
	}

	@Override
	public boolean removeUser(int studentId) {
		return false;
	}

}
