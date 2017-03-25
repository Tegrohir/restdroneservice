package nl.hu.iac.rest;

import java.math.BigInteger;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import nl.hu.iac.service.ServiceProvider;
import nl.hu.iac.service.Drone;
import nl.hu.iac.service.DroneServiceImpl;

@Path("/drones")
public class RestDroneService {
	
	@GET
	@Path("/{droneId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Drone getDrone(@PathParam("droneId") int intId) {
		BigInteger droneId = new BigInteger(Integer.toString((intId)));
		DroneServiceImpl droneServiceImpl = ServiceProvider.getDroneService();
		return droneServiceImpl.getDroneById(droneId);
	}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Drone> getAllDrones() {
		DroneServiceImpl droneServiceImpl = ServiceProvider.getDroneService();
		return droneServiceImpl.getDrones();
	}

	@POST
	@Consumes ({MediaType.APPLICATION_JSON})
	@Produces ({MediaType.APPLICATION_JSON})
	public Drone createDrone(Drone drone) {
		DroneServiceImpl droneServiceImpl = ServiceProvider.getDroneService();
		return droneServiceImpl.add(drone);
	}
	
	@PUT
	@Consumes ({MediaType.APPLICATION_JSON})
	@Produces ({MediaType.APPLICATION_JSON})
	public Drone updateDrone(Drone drone) {
		DroneServiceImpl droneServiceImpl = ServiceProvider.getDroneService();
		return droneServiceImpl.update(drone);
	}

	@DELETE
	@Path("/{droneId}")
	@Produces({MediaType.APPLICATION_JSON})
	public boolean deleteDrone(@PathParam("droneId") int intId) {
		BigInteger droneId = new BigInteger(Integer.toString((intId)));
		DroneServiceImpl droneServiceImpl = ServiceProvider.getDroneService();
		return droneServiceImpl.remove(droneId);
	}
}