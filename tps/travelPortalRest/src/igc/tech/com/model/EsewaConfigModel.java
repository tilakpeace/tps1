package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Ganga on 7/17/2016.
 */
@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EsewaConfigModel {

    private String esewaConfigId, serviceCode, successUrl, failUrl, interfaceUrl, verifyApiUrl, type, active;


    public EsewaConfigModel() {
    }

    public EsewaConfigModel(String esewaConfigId, String serviceCode, String successUrl, String failUrl, String interfaceUrl, String verifyApiUrl, String type, String active) {
        this.esewaConfigId = esewaConfigId;
        this.serviceCode = serviceCode;
        this.successUrl = successUrl;
        this.failUrl = failUrl;
        this.interfaceUrl = interfaceUrl;
        this.verifyApiUrl = verifyApiUrl;
        this.type = type;
        this.active = active;
    }

    public String getEsewaConfigId() {
        return esewaConfigId;
    }

    public void setEsewaConfigId(String esewaConfigId) {
        this.esewaConfigId = esewaConfigId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getFailUrl() {
        return failUrl;
    }

    public void setFailUrl(String failUrl) {
        this.failUrl = failUrl;
    }

    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
    }

    public String getVerifyApiUrl() {
        return verifyApiUrl;
    }

    public void setVerifyApiUrl(String verifyApiUrl) {
        this.verifyApiUrl = verifyApiUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "EsewaConfigModel{" +
                "esewaConfigId='" + esewaConfigId + '\'' +
                ", serviceCode='" + serviceCode + '\'' +
                ", successUrl='" + successUrl + '\'' +
                ", failUrl='" + failUrl + '\'' +
                ", interfaceUrl='" + interfaceUrl + '\'' +
                ", verifyApiUrl='" + verifyApiUrl + '\'' +
                ", type='" + type + '\'' +
                ", active='" + active + '\'' +
                '}';
    }
}
