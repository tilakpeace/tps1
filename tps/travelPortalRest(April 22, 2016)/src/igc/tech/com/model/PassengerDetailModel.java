package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by tilak on 3/21/2016.
 */
@XmlRootElement(name = "PassengerDetail")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class PassengerDetailModel {

    private PassengerModel passengerModel;


    public PassengerModel getPassengerModel() {
        return passengerModel;
    }

    @XmlElement(name = "Passenger")
    public void setPassengerModel(PassengerModel passengerModel) {
        this.passengerModel = passengerModel;
    }

    @Override
    public String toString() {
        return "PassengerDetailModel{" +
                "passengerModel=" + passengerModel +
                '}';
    }
}
