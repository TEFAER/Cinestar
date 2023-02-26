package dao;

import java.util.ArrayList;
import java.util.List;

import bean.Pelicula;

public class PeliculaDAO {
	db.Db db= new db.Db("CineStar");

	public Object getPeliculas(int id, boolean bLista) {
	db.Sentencia( String.format("call sp_getPeliculas(%s)", id));
	String[ ][ ] peliculas = db.getRegistros();
	if(peliculas ==null)return null;
	if (!bLista) return peliculas;
	
	List<Pelicula> lstPeliculas = new ArrayList<>();
	for(String[ ] pelicula : peliculas)
		lstPeliculas.add(new Pelicula(pelicula));
	
	return lstPeliculas;
	
	
	} 
}