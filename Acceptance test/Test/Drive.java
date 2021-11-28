public class Drive {

	public static ShowManagerBridge getBridge(){
		ShowManagerProxyBridge bridge = new ShowManagerProxyBridge();
		bridge.realBridge = null; // Change this when real bridge is ready
		return bridge;
	}
}
