package nl.hu.iac.service;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Tegrohir on 24-3-2017.
 */
public class DroneServiceImplTest {
    DroneServiceImpl droneServiceImpl = ServiceProvider.getDroneService();

    @Test
    public void testGetDroneById() throws Exception {
        assertTrue(droneServiceImpl.getDroneById(new BigInteger("1")).equals(createTestDrone()));
    }

    @Test
    public void testGetDrones() throws Exception {
        assertTrue(droneServiceImpl.getDrones().get(0).equals(createTestDrone()));
    }

    @Test
    public void testAdd() throws Exception {
        Drone testDrone = createTestDrone();
        testDrone.setBatteries("Wes-038");
        int size = droneServiceImpl.getDrones().size();
        Drone newDrone = droneServiceImpl.add(testDrone);
        assertEquals(testDrone.getBatteries(), newDrone.getBatteries());
        assertTrue(droneServiceImpl.getDrones().size() == size + 1);
        //cleanup
        droneServiceImpl.remove(newDrone.getDroneId());
    }

    @Test
    public void testUpdate() throws Exception {
        Drone testDrone = createTestDrone();
        testDrone.setBatteries("Cha-038");
        testDrone.setReceiver("NNE-501");
        Drone updatedDrone = droneServiceImpl.update(testDrone);
        assertEquals(testDrone.getBatteries(), updatedDrone.getBatteries());
        assertEquals(testDrone.getReceiver(), updatedDrone.getReceiver());
        //cleanup
        droneServiceImpl.update(createTestDrone());
    }

    @Test
    public void testRemove() throws Exception {
        int size = droneServiceImpl.getDrones().size();
        droneServiceImpl.remove(new BigInteger("1"));
        assertEquals(size - 1, droneServiceImpl.getDrones().size());
        //cleanup
        droneServiceImpl.add(createTestDrone());
    }

    private Drone createTestDrone() {
        Drone testDrone = new Drone(new BigInteger("1"), "MotorFrame 0.1", "Motor 8000",
                "Transmitter 9000","Receiver 7000", "Propeller Series 5300",
                new BigInteger("38"), "Wes-034");
        return testDrone;
    }
}