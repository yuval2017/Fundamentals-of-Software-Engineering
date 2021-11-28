public class ShowManagerRealBridge implements ShowManagerBridge {
	@Override
	public int addShow(int projectId, String projectName, String projectDescription, int estimatedTime, String proposerCredentials, String organization) {
		throw new UnsupportedOperationException();
	}


	@Override
	public int registerToShow(int[] studentIds, int lecturerId, int projectId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean loginManageShow(String username, int id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean changeShowHour(int projectId, String status) {	throw new UnsupportedOperationException(); }

	@Override
	public boolean isShowExists(int projectId) {	throw new UnsupportedOperationException(); }

	@Override
	public boolean loginUserShow(String username, String password) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAdmin(String name, int id) { throw new UnsupportedOperationException(); }

	@Override
	public boolean removeAdmin(String name, int id) { throw new UnsupportedOperationException(); }

	@Override
	public boolean adminCreateShow(int lecturerId, String projectName) { throw new UnsupportedOperationException(); }

	@Override
	public boolean addUser(int studentId, String username, String password, int year) { throw new UnsupportedOperationException(); }

	@Override
	public boolean removeUser(int studentId) { throw new UnsupportedOperationException(); }

}
