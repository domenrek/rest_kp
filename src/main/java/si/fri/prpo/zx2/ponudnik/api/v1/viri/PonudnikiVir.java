package si.fri.prpo.zx2.ponudnik.api.v1.viri;

import si.fri.prpo.zx2.ponudnik.entitete.Ponudnik;
import si.fri.prpo.zx2.ponudnik.vrsta.QueueManager;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@Path("ponudniki")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Model
public class PonudnikiVir {

    @Inject
    private QueueManager queueManager;

    private ArrayList<Ponudnik> ponudniki = new ArrayList<Ponudnik>(Arrays.asList(
            new Ponudnik("Spar restavracija", "Ljubljana" ),
            new Ponudnik("Gostilna", "Selo"),
            new Ponudnik("Kitajska restavracija", "Hong Kong"),
            new Ponudnik( "Picerija", "Ljubljana"),
            new Ponudnik("McDonalds", "Ljubljana")
            ));

    @GET
    public ArrayList<Ponudnik> vrniPonudnike() {
        return ponudniki;
        //return Response.status(Response.Status.OK).entity(ponudniki).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("json")
    public Response vrniPonudnikeJson() {
        return Response.status(Response.Status.OK).entity(ponudniki).build();
    }

    @Path("{id}")
    @GET
    public Response vrniPonudnika(@PathParam("id") int id) {
        return Response.status(Response.Status.OK).entity(ponudniki.get(id)).build();
    }

    @POST
    @Transactional
    public Response dodajPonudnika(Ponudnik ponudnik) throws IOException {
        ponudniki.add(ponudnik);
    //    queueManager.posljiObvestiloODodanemPonudniku(ponudniki.indexOf(ponudnik));
        return Response.status(Response.Status.CREATED).entity(ponudnik).build();
    }
}
