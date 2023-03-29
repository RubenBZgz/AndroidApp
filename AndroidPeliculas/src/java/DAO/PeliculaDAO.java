package DAO;

import static com.sun.media.jfxmediaimpl.MediaUtils.error;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;
import interfaces.IDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Pelicula;
import model.cPeli;
import utils.ConnectionFactory;
import utils.MotorSQL;

public class PeliculaDAO
        implements IDAO<Pelicula, Integer> {

    private final String SQL_FINDALL
            = "SELECT * FROM `pelicula` WHERE 1=1 ";
    
    private final String SQL_FIND_ONE
            = "SELECT * FROM `pelicula` WHERE idPelicula=";

    private final String SQL_ADD
            = "INSERT INTO `pelicula` (`titulo`, `tematica`, `trailer`, `anio`, `edadRecomendada`, `butacasLibres`, `butacasOcupadas`, `calificacion`, `vecesPuntuado`) VALUES ";

    private final String SQL_DELETE = "DELETE FROM `pelicula` WHERE idPelicula=";

    private final String SQL_UPDATE = "UPDATE `pelicula` SET ";
    
    private final String SQL_TOP10 = "SELECT * FROM pelicula ORDER BY vecesPuntuado DESC LIMIT 10";
    
    private final String SQL_TEMATICAS = "SELECT tematica FROM pelicula GROUP BY tematica";
    
    private final String SQL_FILTRADO_TITULO = "SELECT * FROM pelicula WHERE titulo LIKE ";
    
    private final String SQL_FILTRADO_TEMATICA = "SELECT * FROM pelicula WHERE tematica LIKE ";
    
    private final String SQL_FILTRADO_AMBAS = "SELECT * FROM pelicula WHERE titulo LIKE ";
    
    private final String SQL_PUNTUAR = "UPDATE `pelicula` SET `calificacion` = ";
    
    private final String SQL_HISTORICO = "SELECT * FROM `pelicula` ORDER BY idPelicula ASC LIMIT 4;";
    
    private final String SQL_PELICULAS_CINE = "SELECT cine.nombre, pelicula.titulo FROM cine, cpeli, pelicula WHERE pelicula.idPelicula = cpeli.idPelicula AND cine.idCine = cpeli.idCine AND pelicula.idPelicula = ";
    //SELECT pelicula.titulo FROM pelicula, cpeli WHERE cpeli.idPelicula = pelicula.idPelicula;
    
    //SELECT pelicula.titulo, pelicula.tematica, pelicula.trailer, pelicula.anio, pelicula.edadRecomendada, pelicula.butacasLibres, pelicula.butacasOcupadas, pelicula.calificacion, pelicula.vecesPuntuado FROM pelicula, cpeli WHERE cpeli.idPelicula = pelicula.idPelicula AND pelicula.idPelicula = 1
    
    //SELECT cine.nombre, pelicula.titulo, pelicula.tematica, pelicula.trailer, pelicula.anio, pelicula.edadRecomendada, pelicula.butacasLibres, pelicula.butacasOcupadas, pelicula.calificacion, pelicula.vecesPuntuado FROM pelicula, cpeli WHERE cpeli.idPelicula = pelicula.idPelicula AND cine.idCine = cpeli.idCine AND pelicula.idPelicula = 1;
    private MotorSQL motorSql;

    public PeliculaDAO() {
        motorSql = ConnectionFactory.selectDb();
    }

    @Override
    public ArrayList<Pelicula> findAll(Pelicula bean) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        String sql= SQL_FINDALL;
        try {
            //1º) 
            motorSql.connect();
            if (bean != null) {
                if (bean.getIdPelicula() != 0) {
                    sql += "AND idPelicula='" + bean.getIdPelicula() + "'";
                }
                if (bean.getTitulo() != null) {
                    sql += "AND titulo='" + bean.getTitulo() + "'";
                }
                if (bean.getTematica() != null) {
                    sql += "AND tematica='" + bean.getTematica() + "'";
                }
                if (bean.getTrailer() != null) {
                    sql += "AND trailer='" + bean.getTrailer() + "'";
                }
                if (bean.getAnio() != 0) {
                    sql += "AND anio='" + bean.getAnio() + "'";
                }
                if (bean.getEdadRecomendada() != 0) {
                    sql += "AND edadRecomendada='" + bean.getEdadRecomendada() + "'";
                }
                if (bean.getButacasLibres() != 0) {
                    sql += "AND butacasLibres='" + bean.getButacasLibres() + "'";
                }
                if (bean.getButacasOcupadas() != 0) {
                    sql += "AND butacasOcupadas='" + bean.getButacasOcupadas() + "'";
                }
                if (bean.getCalificacion() != 0) {
                    sql += "AND calificacion='" + bean.getCalificacion() + "'";
                }
                if (bean.getVecesPuntuado() != 0) {
                    sql += "AND vecesPuntuado='" + bean.getVecesPuntuado() + "'";
                }
            }
            sql += ";";

            System.out.println(sql);
            ResultSet rs = motorSql.
                    executeQuery(sql);

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();

                pelicula.setIdPelicula(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setTematica(rs.getString(3));
                pelicula.setTrailer(rs.getString(4));
                pelicula.setAnio(rs.getInt(5));
                pelicula.setEdadRecomendada(rs.getInt(6));
                pelicula.setButacasLibres(rs.getInt(7));
                pelicula.setButacasOcupadas(rs.getInt(8));
                pelicula.setCalificacion(rs.getInt(9));
                pelicula.setVecesPuntuado(rs.getInt(10));

                peliculas.add(pelicula);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return peliculas;
    }
    
    public ArrayList<Pelicula> findOne (int idPelicula) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        String sql= SQL_FIND_ONE + idPelicula;
        try {
            //1º) 
            motorSql.connect();
            sql += ";";

            System.out.println(sql);
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();

                pelicula.setIdPelicula(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setTematica(rs.getString(3));
                pelicula.setTrailer(rs.getString(4));
                pelicula.setAnio(rs.getInt(5));
                pelicula.setEdadRecomendada(rs.getInt(6));
                pelicula.setButacasLibres(rs.getInt(7));
                pelicula.setButacasOcupadas(rs.getInt(8));
                pelicula.setCalificacion(rs.getInt(9));
                pelicula.setVecesPuntuado(rs.getInt(10));
                pelicula.setImagen(rs.getString(11));

                peliculas.add(pelicula);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return peliculas;
    }
    
    public ArrayList<Pelicula> top10 () {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        String sql= SQL_TOP10;
        try {
            //1º) 
            motorSql.connect();
            sql += ";";

            System.out.println(sql);
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();

                pelicula.setIdPelicula(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setTematica(rs.getString(3));
                pelicula.setTrailer(rs.getString(4));
                pelicula.setAnio(rs.getInt(5));
                pelicula.setEdadRecomendada(rs.getInt(6));
                pelicula.setButacasLibres(rs.getInt(7));
                pelicula.setButacasOcupadas(rs.getInt(8));
                pelicula.setCalificacion(rs.getInt(9));
                pelicula.setVecesPuntuado(rs.getInt(10));

                peliculas.add(pelicula);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return peliculas;
    }

    public ArrayList<String> tematicas () {
        //ArrayList<Pelicula> peliculas = new ArrayList<>();
        ArrayList<String> tematicas = new ArrayList<>();
        String sql= SQL_TEMATICAS;
        try {
            //1º) 
            motorSql.connect();
            sql += ";";

            System.out.println(sql);
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                tematicas.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return tematicas;
    }
    
    public ArrayList<Pelicula> filtradoTitulo (String titulo) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        String sql= SQL_FILTRADO_TITULO + "'%" + titulo + "%'";
        try {
            //1º) 
            motorSql.connect();
            sql += ";";

            System.out.println(sql);
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();

                pelicula.setIdPelicula(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setTematica(rs.getString(3));
                pelicula.setTrailer(rs.getString(4));
                pelicula.setAnio(rs.getInt(5));
                pelicula.setEdadRecomendada(rs.getInt(6));
                pelicula.setButacasLibres(rs.getInt(7));
                pelicula.setButacasOcupadas(rs.getInt(8));
                pelicula.setCalificacion(rs.getInt(9));
                pelicula.setVecesPuntuado(rs.getInt(10));

                peliculas.add(pelicula);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return peliculas;
    }
    
    public ArrayList<Pelicula> filtradoTematica (String titulo) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        String sql= SQL_FILTRADO_TEMATICA + "'%" + titulo + "%'";
        try {
            //1º) 
            motorSql.connect();
            sql += ";";

            System.out.println(sql);
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();

                pelicula.setIdPelicula(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setTematica(rs.getString(3));
                pelicula.setTrailer(rs.getString(4));
                pelicula.setAnio(rs.getInt(5));
                pelicula.setEdadRecomendada(rs.getInt(6));
                pelicula.setButacasLibres(rs.getInt(7));
                pelicula.setButacasOcupadas(rs.getInt(8));
                pelicula.setCalificacion(rs.getInt(9));
                pelicula.setVecesPuntuado(rs.getInt(10));

                peliculas.add(pelicula);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return peliculas;
    }
    
    public ArrayList<Pelicula> filtradoAmbas (String titulo, String tematica) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        String sql= SQL_FILTRADO_AMBAS + "'%" + titulo + "%'" + 
                " AND tematica LIKE " + "'%" + tematica + "%'";
        System.out.println(sql);
        try {
            //1º) 
            motorSql.connect();
            sql += ";";

            System.out.println(sql);
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();

                pelicula.setIdPelicula(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setTematica(rs.getString(3));
                pelicula.setTrailer(rs.getString(4));
                pelicula.setAnio(rs.getInt(5));
                pelicula.setEdadRecomendada(rs.getInt(6));
                pelicula.setButacasLibres(rs.getInt(7));
                pelicula.setButacasOcupadas(rs.getInt(8));
                pelicula.setCalificacion(rs.getInt(9));
                pelicula.setVecesPuntuado(rs.getInt(10));

                peliculas.add(pelicula);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return peliculas;
    }
    
    public ArrayList<Pelicula> puntuar (int idPelicula, int puntuacion) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        
        try {
            //1º) 
            motorSql.connect();
            
            //      OBTENER PELICULA PARA SACAR LAS VECES PUNTUADA Y SU CALIFICACION
            /*ResultSet rs = motorSql.executeQuery(SQL_FIND_ONE + idPelicula);

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();

                pelicula.setIdPelicula(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setTematica(rs.getString(3));
                pelicula.setTrailer(rs.getString(4));
                pelicula.setAnio(rs.getInt(5));
                pelicula.setEdadRecomendada(rs.getInt(6));
                pelicula.setButacasLibres(rs.getInt(7));
                pelicula.setButacasOcupadas(rs.getInt(8));
                pelicula.setCalificacion(rs.getInt(9));
                pelicula.setVecesPuntuado(rs.getInt(10));
                pelicula.setImagen(rs.getString(11));

                peliculas.add(pelicula);

            }

            double calificacion = peliculas.get(0).getCalificacion();
            int vecesPuntuado = peliculas.get(0).getVecesPuntuado();
            vecesPuntuado += 1;
            double calificacionBuena = ((calificacion * vecesPuntuado+puntuacion)/vecesPuntuado);*/
            
            
            String sql= SQL_PUNTUAR + puntuacion  + " WHERE `idPelicula` = " + idPelicula;
            sql += ";";
            System.out.println(sql);
            int result = motorSql.execute(sql);
            /*ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();

                pelicula.setIdPelicula(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setTematica(rs.getString(3));
                pelicula.setTrailer(rs.getString(4));
                pelicula.setAnio(rs.getInt(5));
                pelicula.setEdadRecomendada(rs.getInt(6));
                pelicula.setButacasLibres(rs.getInt(7));
                pelicula.setButacasOcupadas(rs.getInt(8));
                pelicula.setCalificacion(rs.getInt(9));
                pelicula.setVecesPuntuado(rs.getInt(10));
                pelicula.setImagen(rs.getString(11));

                peliculas.add(pelicula);

            }*/
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return peliculas;
    }
    
    public ArrayList<Pelicula> historico () {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        String sql= SQL_HISTORICO;
        System.out.println(sql);
        try {
            //1º) 
            motorSql.connect();
            sql += ";";

            System.out.println(sql);
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();

                pelicula.setIdPelicula(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setTematica(rs.getString(3));
                pelicula.setTrailer(rs.getString(4));
                pelicula.setAnio(rs.getInt(5));
                pelicula.setEdadRecomendada(rs.getInt(6));
                pelicula.setButacasLibres(rs.getInt(7));
                pelicula.setButacasOcupadas(rs.getInt(8));
                pelicula.setCalificacion(rs.getInt(9));
                pelicula.setVecesPuntuado(rs.getInt(10));
                pelicula.setImagen(rs.getString(11));

                peliculas.add(pelicula);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return peliculas;
    }
    
    public ArrayList<cPeli> peliculasCine (int idPelicula) {
        ArrayList<cPeli> peliculas = new ArrayList<>();
        String sql= SQL_PELICULAS_CINE + idPelicula;
        try {
            //1º) 
            motorSql.connect();
            sql += ";";

            System.out.println(sql);
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                cPeli cPeli = new cPeli();
                cPeli.setNombreCine(rs.getString(1));
                cPeli.setNombrePelicula(rs.getString(2));

                peliculas.add(cPeli);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return peliculas;
    }
    
    @Override
    public int add(Pelicula bean) {
        int resp = 0;
        try {
            motorSql.connect();

            String sql = SQL_ADD + "('"
                    + bean.getTitulo() + "', '"
                    + bean.getTematica() + "', '"
                    + bean.getTrailer() + "', '"
                    + bean.getAnio()+ "', '"
                    + bean.getAnio() + "', '"
                    + bean.getEdadRecomendada() + "', '"
                    + bean.getButacasLibres()+ "', '"
                    + bean.getButacasOcupadas()+ "', '"
                    + bean.getCalificacion()+ "', '"
                    + bean.getVecesPuntuado()+ "');";

//                    + bean.getsPuntuacion() + "',"
//                    + "CURRENT_DATE)";
            resp = motorSql.execute(sql);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();

        }
        if (resp > 0) {
            System.out.println("Película insertada con exito.");
        }
        return resp;
    }

    @Override
    public int delete(Integer idPelicula) {
        int resp = 0;
        motorSql.connect();
        try {
            String sql = SQL_DELETE + idPelicula;
            //desactivo la restriccion de claves foráneas para borrado
            motorSql.execute("SET FOREIGN_KEY_CHECKS=0;");
            resp = motorSql.execute(sql);
            //vuelvo a activar la restricción de claves foráneas
            motorSql.execute("SET FOREIGN_KEY_CHECKS=1;");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();

        }
        if (resp > 0) {
            System.out.println("Borrado con exito.");
        } else {
            System.out.println("No se pudo borrar.");
        }
        return resp;
    }

    @Override
    public int update(Pelicula bean) {
        int resp = 0;
        String sql;
        try {
            motorSql.connect();

            if (bean == null) {
                System.out.println("Introduzca datos a modificar");
            } else {

                sql = SQL_UPDATE;
                if (bean.getIdPelicula() != 0) {
                    sql += "AND idPelicula='" + bean.getIdPelicula() + "'";
                }
                if (bean.getTitulo() != null) {
                    sql += "AND titulo='" + bean.getTitulo() + "'";
                }
                if (bean.getTematica() != null) {
                    sql += "AND tematica='" + bean.getTematica() + "'";
                }
                if (bean.getTrailer() != null) {
                    sql += "AND trailer='" + bean.getTrailer() + "'";
                }
                if (bean.getAnio() != 0) {
                    sql += "AND anio='" + bean.getAnio() + "'";
                }
                if (bean.getEdadRecomendada() != 0) {
                    sql += "AND edadRecomendada='" + bean.getEdadRecomendada() + "'";
                }
                if (bean.getButacasLibres() != 0) {
                    sql += "AND butacasLibres='" + bean.getButacasLibres() + "'";
                }
                if (bean.getButacasOcupadas() != 0) {
                    sql += "AND butacasOcupadas='" + bean.getButacasOcupadas() + "'";
                }
                if (bean.getCalificacion() != 0) {
                    sql += "AND calificacion='" + bean.getCalificacion() + "'";
                }
                if (bean.getVecesPuntuado() != 0) {
                    sql += "AND vecesPuntuado='" + bean.getVecesPuntuado() + "'";
                }

                sql += " WHERE `ID_Pelicula`=" + bean.getIdPelicula() + ";";
                System.out.println(sql);
                resp = motorSql.execute(sql);
            }

        } catch (Exception e) {

        } finally {
            motorSql.disconnect();
        }

        if (resp > 0) {
            System.out.println("Pelicula actualizada con éxito.");
        } else {
            System.out.println("No se pudo actualizar.");
        }
        return resp;
    }

    public static void main(String[] args) {
        /*PRUEBAS UNITARIAS - TEST*/
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        
        //Findall - filtra segun campos que no son null o 0
        //ArrayList lstPeliculas = peliculaDAO.findAll(new Pelicula());
        //ArrayList lstPeliculas = peliculaDAO.findAll(new Pelicula("Interstellar", null, null, null, 0, 500, 0, 0, null, null));
        //System.out.println(lstPeliculas.toString());
        
        /*ArrayList lstPeliculas = peliculaDAO.findOne(4);
        System.out.println(lstPeliculas.toString());*/
        
        //     FILTRADO TITULO
        /*ArrayList lstPeliculas = peliculaDAO.filtradoTitulo("ava");
        System.out.println(lstPeliculas.toString());*/
        
        /*      FILTRADO TEMATICAS
        ArrayList lstPeliculas = peliculaDAO.tematicas();
        System.out.println(lstPeliculas.toString());*/
        
        /*      FILTRADO AMBAS
        ArrayList lstPeliculas = peliculaDAO.filtradoAmbas("Cre", "Acción");
        System.out.println(lstPeliculas.toString());*/
        
        /*      PUNTUAR
        ArrayList lstPeliculas = peliculaDAO.puntuar(4, 4);
        System.out.println(lstPeliculas.toString());*/
        
        /*      HISTORICO
        ArrayList lstPeliculas = peliculaDAO.historico();
        System.out.println(lstPeliculas.toString());*/
        
        ArrayList lstPeliculas = peliculaDAO.peliculasCine(4);
        System.out.println(lstPeliculas.toString());
        
        
        //Pelicula peliprueba = new Pelicula("Joshua y los teleñecos", "www", "abc", "2015", 90, 5, 6, 9, 5.3, null);

       //Add de registro
       //peliculaDAO.add(peliprueba);

        //Update del registro con id pelicula 1
        //peliculaDAO.update(new Pelicula("Titulo cambiado", null, null, null, 0, 0, 0, 1, null));

        //Delete del registro 2
        //peliculaDAO.delete(2);
    }
}
