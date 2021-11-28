import javax.xml.crypto.Data;
import java.time.LocalDate;

public interface ShowBridge {

	boolean addShow(String ShowName, String showDescription, String hallName, LocalDate date, int cardPrice, LocalDate lastDateForReservation);

	boolean registerToShow(String name, String phoneNumber, int[] wantedSeats);

	boolean loginUser(String username, String password);

	LocalDate getShowHour(String name);
	boolean addAdmin(String name, String id);
	boolean removeAdmin(String name);

	boolean addUser(String username, String password);
	boolean removeUser(String name);

}


