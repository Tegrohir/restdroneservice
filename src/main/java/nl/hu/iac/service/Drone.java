package nl.hu.iac.service;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;

/**
 * Created by Tegrohir on 22-3-2017.
 */
@XmlRootElement
public class Drone {
    private BigInteger droneId;
    private String motorFrame;
    private String motor;
    private String transmitter;
    private String receiver;
    private String propellers;
    private BigInteger numberOfPropellers;
    private String batteries;

    public Drone() {
        super();
    }

    public Drone(BigInteger droneId, String motorFrame, String motor, String transmitter, String receiver, String propellers, BigInteger numberOfPropellers, String batteries) {
        super();
        this.droneId = droneId;
        this.motorFrame = motorFrame;
        this.motor = motor;
        this.transmitter = transmitter;
        this.receiver = receiver;
        this.propellers = propellers;
        this.numberOfPropellers = numberOfPropellers;
        this.batteries = batteries;
    }

    public BigInteger getDroneId() {
        return droneId;
    }

    @XmlAttribute
    public void setDroneId(BigInteger droneId) {
        this.droneId = droneId;
    }

    public String getMotorFrame() {
        return motorFrame;
    }

    public void setMotorFrame(String motorFrame) {
        this.motorFrame = motorFrame;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getTransmitter() {
        return transmitter;
    }

    public void setTransmitter(String transmitter) {
        this.transmitter = transmitter;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPropellers() {
        return propellers;
    }

    public void setPropellers(String propellers) {
        this.propellers = propellers;
    }

    public BigInteger getNumberOfPropellers() {
        return numberOfPropellers;
    }

    public void setNumberOfPropellers(BigInteger numberOfPropellers) {
        this.numberOfPropellers = numberOfPropellers;
    }

    public String getBatteries() {
        return batteries;
    }

    public void setBatteries(String batteries) {
        this.batteries = batteries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drone drone = (Drone) o;

        return droneId.equals(drone.droneId);
    }

    @Override
    public int hashCode() {
        return droneId.hashCode();
    }

    @Override
    public String toString() {
        return "Drone{" +
                "droneId=" + droneId +
                ", motorFrame='" + motorFrame + '\'' +
                ", motor='" + motor + '\'' +
                ", transmitter='" + transmitter + '\'' +
                ", receiver='" + receiver + '\'' +
                ", propellers='" + propellers + '\'' +
                ", numberOfPropellers=" + numberOfPropellers +
                ", batteries='" + batteries + '\'' +
                '}';
    }

}
