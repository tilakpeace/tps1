package igc.tech.com.dao;

import igc.tech.com.model.RoomAmenityModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface RoomAmenityDao {

    public List procRoomAmenity(RoomAmenityModel roomAmenityModel,
                                String user,
                                String flag);

}
