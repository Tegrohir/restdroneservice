package nl.hu.iac.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DroneServiceImpl {
	private List<Drone> drones = new ArrayList<>();

	public DroneServiceImpl() {
		drones.add(new Drone(new BigInteger("1"), "MotorFrame 0.1", "Motor 8000", "Transmitter 9000",
				"Receiver 7000", "Propeller Series 5300", new BigInteger("38"), "Wes-034"));
	}

	public Drone getDroneById(BigInteger Id) {
		for (Drone drone : drones) {
			if (drone.getDroneId().equals(Id)) {
				return drone;
			}
		}
		return null;
	}

	public List<Drone> getDrones() {
		return drones;
	}

	public boolean remove(BigInteger droneId) {
		return drones.remove(getDroneById(droneId));
	}

	public Drone add(Drone drone) {
		BigInteger newId = new BigInteger("1");
		if (drones.size() != 0)
			newId = drones.get(drones.size()-1).getDroneId();

		drone.setDroneId(newId);
		if (drones.add(drone)) {
			return drone;
		} else {
			return null;
		}
	}


	public Drone update(Drone drone) {
		for (Drone target:drones){
			if (drone.getDroneId().compareTo(target.getDroneId()) == 0){
//			if(drone.getDroneId().equals(target.getDroneId())){
				target.setMotorFrame(drone.getMotorFrame());
				target.setMotor(drone.getMotor());
				target.setMotor(drone.getMotor());
				target.setTransmitter(drone.getTransmitter());
				target.setReceiver(drone.getReceiver());
				target.setPropellers(drone.getPropellers());
				target.setNumberOfPropellers(drone.getNumberOfPropellers());
				target.setBatteries(drone.getBatteries());

				return target;
			}
		}
		return null;
	}
}
