package igc.tech.com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlbumDaoImpl extends JdbcTemplate implements AlbumDao {

    @Override
    public List procAlbum(String albumId, String albumCaption,
                           String detail, String type, String commonId, String imageId, String user, String flag) {
        // TODO Auto-generated method stub

        String procName = "proc_album";

        SimpleJdbcCall call = new SimpleJdbcCall(this);

        call = call.withProcedureName(procName);
        call.addDeclaredParameter(new SqlParameter("IN_FLAG", Types.CHAR));

        call.addDeclaredParameter(new SqlParameter("IN_ALBUM_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_ALBUM_CAPTION", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_DETAIL", Types.VARCHAR));
        call.addDeclaredParameter(new SqlParameter("IN_TYPE", Types.CHAR));
        call.addDeclaredParameter(new SqlParameter("IN_COMMON_ID", Types.NUMERIC));
        call.addDeclaredParameter(new SqlParameter("IN_IMAGE_ID", Types.VARCHAR));

        call.addDeclaredParameter(new SqlParameter("IN_USER", Types.VARCHAR));

        Map<String, Object> inp = new HashMap<String, Object>();

        inp.put("IN_FLAG", flag);

        inp.put("IN_ALBUM_ID", albumId);
        inp.put("IN_ALBUM_CAPTION", albumCaption);
        inp.put("IN_DETAIL", detail);
        inp.put("IN_TYPE", type);
        inp.put("IN_COMMON_ID", commonId);
        inp.put("IN_IMAGE_ID", imageId);

        inp.put("IN_USER", user);

        Map<String, Object> resultMap = call.execute(inp);

        String keyName = resultMap.keySet().toArray()[0].toString();

        return (ArrayList<Map>) resultMap.get(keyName);


    }

}
