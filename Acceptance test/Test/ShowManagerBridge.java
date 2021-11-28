public interface ShowManagerBridge {

	int addShow(int projectId, String ShowName, String projectDescription, int estimatedTime, String proposerCredentials, String organization);
	// Returns the project's status as a string
	int registerToShow(int[] studentIds, int lecturerId, int projectId);
	boolean loginManageShow(String username, int id);
	boolean changeShowHour(int projectId, String status);
	boolean isShowExists(int projectId);
	boolean loginUserShow(String username, String password);
	boolean addAdmin(String name, int id);
	boolean removeAdmin(String name, int id);
	boolean adminCreateShow(int lecturerId, String projectName);
	boolean addUser(int studentId, String username, String password, int year);
	boolean removeUser(int studentId);

}


