package si.fri.prpo.zx2.ponudnik.api.v1.viri;

import si.fri.prpo.zx2.ponudnik.entitete.Jedilnik;
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

@Path("jedilnik")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Model
public class JedilnikVir {

    private ArrayList<Jedilnik> jedilnik = new ArrayList<Jedilnik>(Arrays.asList(
            new Jedilnik("Ponedeljek", "Porova juha","Govedina in pire krompir","Jabolčni štrudl" ),
            new Jedilnik("Torek", "Gobova juha", "Ocvrti sir in pomfi", "Sladoled"),
            new Jedilnik("Sreda", "Spomladanski zavitek", "Palačinke", "Mešani Kompot"),
            new Jedilnik( "Četrtek", "Goveja juha", "Pizza","Tiramisu"),
            new Jedilnik("Petek", "Zelenjavna juha", "Losos in krompirjeva solata", "Prekmurska gibanica")
    ));

    @GET
    public Response vrniJedilnik() {
        return Response.status(Response.Status.OK).entity(jedilnik).build();
    }

    @Path("{id}")
    @GET
    public Response vrniPonudnika(@PathParam("id") int id) {
        return Response.status(Response.Status.OK).entity(jedilnik.get(id-1)).build();
    }

    @Path("cena")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String vrniCeno() {
        return "5.60€";
                //Response.status(Response.Status.OK).build("5.60€")
    }
}
