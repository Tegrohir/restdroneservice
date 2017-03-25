package nl.hu.iac.service;


public class ServiceProvider {
	private static DroneServiceImpl droneService = new DroneServiceImpl();
	public static DroneServiceImpl getDroneService() {
		return droneService;
	}
}