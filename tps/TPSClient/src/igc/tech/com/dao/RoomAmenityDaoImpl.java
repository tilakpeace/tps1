package igc.tech.com.dao;

import igc.tech.com.model.RoomAmenityModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class RoomAmenityDaoImpl extends JdbcTemplate implements RoomAmenityDao {

    @Override
    public List procRoomAmenity(RoomAmenityModel roomAmenityModel, String user, String flag) {


        String procName = "proc_room_amenity";
        SimpleJdbcCall call = new SimpleJdbcCall(this);
        call = call.withProcedureName(procName);

        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_room_amenity_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_room_detail_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_amenity_id", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("in_active", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("in_hotel_detail_id", Types.NUMERIC));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);
        inp.put("in_room_amenity_id", roomAmenityModel.getRoomAmenityId());
        inp.put("in_room_detail_id", roomAmenityModel.getRoomDetailId());
        inp.put("in_amenity_id", roomAmenityModel.getAmenityId());
        inp.put("in_active", roomAmenityModel.getActive());
        inp.put("in_hotel_detail_id", roomAmenityModel.getHotelDetailId());

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);



        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }
}
