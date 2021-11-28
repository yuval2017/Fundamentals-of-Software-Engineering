import java.time.LocalDate;

public class ShowProxyBridge implements ShowBridge {

	public ShowRealBridge realBridge;

	@Override
	public boolean addShow(String ShowName, String showDescription, String hallName, LocalDate date, int cardPrice, LocalDate lastDateForReservation) {
		if(realBridge != null){
			return realBridge.addShow(ShowName, showDescription, hallName, date, cardPrice, lastDateForReservation);
		}
		return true;
	}


	@Override
	public boolean registerToShow(String name, String phoneNumber, int[] wantedSeats){
		if(realBridge != null){
			return realBridge.registerToShow(name, phoneNumber, wantedSeats);
		}
		return true;
	}



	@Override
	public boolean loginUser(String username, String password) {
		if(realBridge != null){
			return realBridge.loginUser( username,  password);
		}
		return true;
	}

	@Override
	public boolean addAdmin(String name, String pass) {
		if(realBridge != null){
			return realBridge.addAdmin( name,  pass);
		}
		return true;
	}

	@Override
	public boolean removeAdmin( String username) {
		if(realBridge != null){
			return realBridge.removeAdmin(  username);
		}
		return true;
	}


	@Override
	public boolean addUser( String username, String password) {
		if(realBridge != null){
			return realBridge.addUser(username,password);
		}
		return true;
	}

	@Override
	public LocalDate getShowHour(String name) {
		if(realBridge != null){
			return realBridge.getShowHour(name);
		}
		return null;
	}

	@Override
	public boolean removeUser(String username) {
		if(realBridge != null){
			return realBridge.removeUser( username);
		}
		return true;
	}

}
