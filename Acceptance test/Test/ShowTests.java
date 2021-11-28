import junit.framework.TestCase;

import java.time.LocalDate;

public class ShowTests extends TestCase {

	private ShowBridge bridge;


	public void setUp() throws Exception{
		super.setUp();

		bridge = new ShowProxyBridge();
		addShow("Zero motivation", "Army comedy show", "Hacameri",LocalDate.of(2022,1,20),60,LocalDate.of(2021,5,10));
		addShow("The cobler", "Poor cobler's life changing after he finds special show fixing machine", "Habima", LocalDate.of(2022,1,20),45,LocalDate.of(2021,5,10));
		addAdmin("Azam Maraee", "121");
		addUser("Bar","123");
		addUser("Yuval","123");
	}

	@Override
	public void tearDown() throws Exception{

		super.tearDown();
		removeUser("Bar");
		removeUser("Yuval");
		removeAdmin( "Azam Maraee");

	}

	protected boolean addShow(String ShowName, String showDescription, String hallName, LocalDate date, int cardPrice, LocalDate lastDateForReservation){
		return bridge.addShow(ShowName, showDescription, hallName, date, cardPrice, lastDateForReservation);
	}


	protected boolean registerToShow(String name, String phone, int[] seats){
		return bridge.registerToShow(name, phone, seats);
	}


	protected boolean addUser( String username, String password){
		return bridge.addUser( username, password);
	}
	protected boolean addAdmin(String name,String password){
		return bridge.addAdmin(name, password );
	}
	protected boolean removeUser(String name){
		return bridge.removeUser(name);
	}
	protected boolean removeAdmin(String name){
		return bridge.removeAdmin(name);
	}
	protected LocalDate getShowHour(String name){
		return bridge.getShowHour( name);
	}
	protected boolean loginUser(String username, String password){
		return bridge.loginUser(username, password);
	}

}
