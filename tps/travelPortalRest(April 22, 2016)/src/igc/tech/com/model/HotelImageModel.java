package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by IGC TECHNOLOGY on 2/14/2016.
 */

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class HotelImageModel {

    private String hotelImageId, HotelDetailId, caption, fileName,
            thumbnail, imageUrl,
            fileType, active;

    public String getHotelImageId() {
        return hotelImageId;
    }

    public void setHotelImageId(String hotelImageId) {
        this.hotelImageId = hotelImageId;
    }

    public String getHotelDetailId() {
        return HotelDetailId;
    }

    public void setHotelDetailId(String hotelDetailId) {
        HotelDetailId = hotelDetailId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
