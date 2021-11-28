import javax.xml.crypto.Data;
import java.time.LocalDate;

public class ShowRealBridge implements ShowBridge {
	@Override
	public boolean addShow(String ShowName, String showDescription, String hallName, LocalDate date, int cardPrice, LocalDate lastDateForReservation) {
		return true;
	}


	@Override
	public boolean registerToShow(String name, String phoneNumber, int[] wantedSeats) {
		return true;
	}

	@Override
	public boolean loginUser(String username, String password) {
		return true;
	}

	@Override
	public boolean addAdmin(String name, String password) { return true; }

	@Override
	public boolean removeAdmin( String username) { return true;}

	@Override
	public boolean addUser( String username, String password) { return true; }

	@Override
	public boolean removeUser(String username) { return true; }

	@Override
	public LocalDate getShowHour(String name) { return null;}
}
