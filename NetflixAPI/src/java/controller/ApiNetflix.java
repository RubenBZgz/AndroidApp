package controller;

import DAO.PeliculaDAO;
import DAO.UsuarioDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Cine;
import model.Pelicula;
import model.Usuario;

@Path("peliculas")
public class ApiNetflix {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public JsonArray listarPeliculas() {
        PeliculaDAO peliculaDao = new PeliculaDAO();
        ArrayList<Pelicula> peliculas = peliculaDao.findAll(null);
        String resp = Pelicula.toArrayJSon(peliculas);
        JsonParser parser = new JsonParser();
        JsonElement tradeElement = parser.parse(resp);
        JsonArray trade = tradeElement.getAsJsonArray();
        return trade;
        //return null;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Producto> getProductos() {
        return productoDAO.findAll();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Pelicula> getPeliculas() {
        Pelicula pelicula = new Pelicula();
      
        return PeliculaDAO.findAll(pelicula);
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarCine(@PathParam("id") int idCine) {
        CineDAO cineDao = new CineDAO();
        Cine cine = new Cine();
        cine.setIdCine(idCine);
        ArrayList<Cine> cines = cineDao.findAll(cine);
        return Cine.toArrayJSon(cines);
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String login(Usuario usuario) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        ArrayList<Usuario> usuarios = usuarioDao.findAll(usuario);
        return Usuario.toObjectJSon(usuarios.get(0));
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario register(Usuario usuario) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        ArrayList<Usuario> usuarios = usuarioDao.findAll(null);
        for (Usuario usuarioRespuesta : usuarios) {
            if (usuarioRespuesta.getEmail().equals(usuario.getEmail())) {
                return null;
            }
        }
        usuarioDao.add(usuario);
        return usuario;
    }

//CONVERTIR A JSON con librería
    public static String toArrayJSon(ArrayList<Usuario> usuarios) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(usuarios);
        return resp;
    }
    
    

}
