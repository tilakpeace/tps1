package igc.tech.com.resource;

import igc.tech.com.dao.AlbumDao;
import igc.tech.com.dao.RegionDao;
import igc.tech.com.exception.NoContentException;
import igc.tech.com.exception.NotImplementedException;
import igc.tech.com.mapper.AlbumMapper;
import igc.tech.com.mapper.RegionMapper;
import igc.tech.com.model.AlbumModel;
import igc.tech.com.model.ErrorMessage;
import igc.tech.com.model.RegionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;
import java.util.Map;

@Component
@Path("/album")
public class AlbumResource {

    @Autowired
    AlbumDao albumDao;

    ErrorMessage errorMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        List<AlbumModel> albumModels= new AlbumMapper().mapList(albumDao.procAlbum(null, null, null, null,null,null,null, "a"));

        if (albumModels.isEmpty()) {

            throw new NoContentException("Data not Found!!!!");

        }

        return Response.status(Status.OK).entity(albumModels)
                .type(MediaType.APPLICATION_JSON).build();

    }

    @Path("/{albumId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("albumId") String albumId) {

        List<AlbumModel> albumModels= new AlbumMapper().mapList(albumDao.procAlbum(albumId, null, null, null,null,null,null, "s"));

        if (albumModels.isEmpty()) {

            throw new NoContentException("Data not Found!!!!");

        }

        AlbumModel albumModel=albumModels.get(0);

        return Response.status(Status.OK).entity(albumModel)
                .type(MediaType.APPLICATION_JSON).build();

    }


    @Path("/type/{type}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByType(@PathParam("type") String type) {

        AlbumModel albumModel=new AlbumModel();
        albumModel.setType(type);

        List<AlbumModel> albumModels= new AlbumMapper().mapList(albumDao.procAlbum(null, null, null, type,null,null,null, "s"));

        if (albumModels.isEmpty()) {

            throw new NoContentException("Data not Found!!!!:"+type);

        }

        albumModel.setAlbums(new AlbumMapper().mapListSetNull(false,false,false,true,false,false,false,false,albumModels));

        return Response.status(Status.OK).entity(albumModel)
                .type(MediaType.APPLICATION_JSON).build();

    }

   /* @Path("/country/{countryId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByHotelDetailId(@PathParam("countryId") String countryId) {


        List<Map> list = regionDao.procRegion(null, null, null, null, "h");

        if (list.isEmpty()) {

            throw new NoContentException("data not found!!!!");

        }

        RegionModel regionModel = new RegionMapper().mapRow(list.get(0));

        regionModel.setRegions(new RegionMapper().mapList(regionDao.procRegion(null, null, regionModel.getCountryID(), null, "f")));

        return Response.status(Status.OK).entity(regionModel)
                .type(MediaType.APPLICATION_JSON).build();
    }
*/
  /*  @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertData(RegionModel region) {

        Map databaseResponse = (Map) regionDao.procRegion(null,
                region.getRegionName(), region.getCountryID(),
                region.getUser(), "i").get(0);

        if (!databaseResponse.get("STATUS").equals("SUCCESS")) {

            throw new NotImplementedException(databaseResponse.get("MSG").toString());
        }

        return Response.status(Status.OK).entity(databaseResponse)
                .type(MediaType.APPLICATION_JSON).build();

    }*/

    /*@PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateData(*//*@PathParam("regionID") String regionID,*//*
                               RegionModel regionModel) {
        *//*
         * GETTING DATA FROM GETBYID METHOD TO CHECK THE EMPTY CONTENT FOR
		 * PROVIDED UPDATE ID
		 *//*
        Response rsp = getById(regionModel.getRegionId());

        if (rsp.getStatus() == 200) {
            @SuppressWarnings("unchecked")
            Map databaseResponse =(Map) regionDao.procRegion(
                    regionModel.getRegionId(), regionModel.getRegionName(), regionModel.getCountryID(),
                    regionModel.getUser(), "u").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE
        else {

            return rsp;
        }

    }*/

    /*@DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteData(*//*@PathParam("regionID") String regionID,*//*
                               RegionModel regionModel) {
        *//*
         * GETTING DATA FROM GETBYID METHOD TO CHECK THE EMPTY CONTENT FOR
		 * PROVIDED UPDATE ID
		 *//*

        Response rsp = getById(regionModel.getRegionId());

        if (rsp.getStatus() == 200) {
            @SuppressWarnings("unchecked")
            Map databaseResponse =(Map) regionDao.procRegion(
                    regionModel.getRegionId(), null, null, regionModel.getUser(), "d").get(0);

            return Response.status(Status.OK).entity(databaseResponse)
                    .type(MediaType.APPLICATION_JSON).build();

        }

        // RETURNING RESPONSE
        else {
            return rsp;
        }

    }*/

}
