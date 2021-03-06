package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BedTypeModel {
    private String bedTypeId, bedTypeDesc, bedDimension, capacity, active;

    public String getBedTypeId() {
        return bedTypeId;
    }

    public void setBedTypeId(String bedTypeId) {
        this.bedTypeId = bedTypeId;
    }

    public String getBedTypeDesc() {
        return bedTypeDesc;
    }

    public void setBedTypeDesc(String bedTypeDesc) {
        this.bedTypeDesc = bedTypeDesc;
    }

    public String getBedDimension() {
        return bedDimension;
    }

    public void setBedDimension(String bedDimension) {
        this.bedDimension = bedDimension;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
