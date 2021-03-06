package igc.tech.com.model;

/**
 * Created by Ganga on 4/15/2016.
 */
public class AmenityModel {
    
    private String amenityId, parentAmenityId, amenityDesc, active, webPrior, mobPrior, icon, image;

    public String getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(String amenityId) {
        this.amenityId = amenityId;
    }

    public String getParentAmenityId() {
        return parentAmenityId;
    }

    public void setParentAmenityId(String parentAmenityId) {
        this.parentAmenityId = parentAmenityId;
    }

    public String getAmenityDesc() {
        return amenityDesc;
    }

    public void setAmenityDesc(String amenityDesc) {
        this.amenityDesc = amenityDesc;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getWebPrior() {
        return webPrior;
    }

    public void setWebPrior(String webPrior) {
        this.webPrior = webPrior;
    }

    public String getMobPrior() {
        return mobPrior;
    }

    public void setMobPrior(String mobPrior) {
        this.mobPrior = mobPrior;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "AmenityModel{" +
                "amenityId='" + amenityId + '\'' +
                ", parentAmenityId='" + parentAmenityId + '\'' +
                ", amenityDesc='" + amenityDesc + '\'' +
                ", active='" + active + '\'' +
                ", webPrior='" + webPrior + '\'' +
                ", mobPrior='" + mobPrior + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
