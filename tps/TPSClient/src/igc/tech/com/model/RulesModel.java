package igc.tech.com.model;

/**
 * Created by Ganga on 4/1/2016.
 */
public class RulesModel {
    private String rulesId, rulesDesc, type, hotelDetailId;

    public String getRulesId() {
        return rulesId;
    }

    public void setRulesId(String rulesId) {
        this.rulesId = rulesId;
    }

    public String getRulesDesc() {
        return rulesDesc;
    }

    public void setRulesDesc(String rulesDesc) {
        this.rulesDesc = rulesDesc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHotelDetailId() {
        return hotelDetailId;
    }

    public void setHotelDetailId(String hotelDetailId) {
        this.hotelDetailId = hotelDetailId;
    }

    @Override
    public String toString() {
        return "RulesModel{" +
                "rulesId='" + rulesId + '\'' +
                ", rulesDesc='" + rulesDesc + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
