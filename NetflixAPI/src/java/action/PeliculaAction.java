package action;

import DAO.PeliculaDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Pelicula;

public class PeliculaAction implements interfaces.Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {

            case "FIND_ALL":
                cadDestino = findAll(request, response);
                break;
        }
        return cadDestino;
    }
    private String findAll(HttpServletRequest request, 
                                HttpServletResponse response) {
        int idPelicula = 0;
        PeliculaDAO peliculaDao = new PeliculaDAO();
        Pelicula pelicula = new Pelicula();
        String sinopsis = request.getParameter("SINOPSIS");
        if(request.getParameter("ID_PELICULA")!=null){
            idPelicula = Integer.parseInt(request.
                    getParameter("ID_PELICULA"));
        }
        if(sinopsis!=null && sinopsis.length()>0){
            pelicula.setSinopsis(sinopsis);
        }
        if(idPelicula>0){
            pelicula.setId(idPelicula);
        }
        ArrayList<Pelicula> peliculas = peliculaDao.
                findAll(pelicula);
        return Pelicula.toArrayJSon(peliculas);
        //return Pelicula.toCadena(peliculas.get(0));

    }

    
}
