package igc.tech.com.dao;

import igc.tech.com.model.ExtraBedModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface ExtraBedDao {

    public List procExtraBed(ExtraBedModel extraBedModel,
                             String user,
                             String flag);

}
