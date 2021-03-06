package igc.tech.com.resource;

import igc.tech.com.dao.ActivityDao;
import igc.tech.com.dao.AmenityDao;
import igc.tech.com.mapper.ActivityMapper;
import igc.tech.com.mapper.AmenityMapper;
import igc.tech.com.model.ActivityModel;
import igc.tech.com.model.AmenityModel;
import igc.tech.com.model.ErrorMessage;
import igc.tech.com.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/amenity")
public class AmenityResource {

   @Autowired
   AmenityDao amenityDao;

    ErrorMessage errorMessage;

    ResponseModel responseModel;

    @Path("/mobNav")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response mobNav( ) throws Exception {


       List<AmenityModel>  amenityModels=  new AmenityMapper().mapList(amenityDao.procAmenity(new AmenityModel(),null,"nav_mob")) ;

        return Response.status(Response.Status.OK).entity(amenityModels)
                .type(MediaType.APPLICATION_JSON).build();


    }


    @Path("/webNav")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response webNav( ) throws Exception {

        List<AmenityModel>  amenityModels=  new AmenityMapper().mapList(amenityDao.procAmenity(new AmenityModel(),null,"nav_web")) ;


        return Response.status(Response.Status.OK).entity(amenityModels)
                .type(MediaType.APPLICATION_JSON).build();


    }





}
