package Bo;

import java.util.ArrayList;

import Bean.MovieBean;
import Dao.MovieDao;

public class MovieBo {
	ArrayList<MovieBean> listMovies;
	MovieDao mDao = new MovieDao();
	
	public ArrayList<MovieBean> GetMovies(){
		listMovies = mDao.GetMovies();
		return listMovies;
	}
	
	public MovieBean GetMovie(int movieID) {
		MovieBean mBean = mDao.GetMovie(movieID);
		return mBean;
	}
	
	public void SetMovie(String poster, String summary, 
			String name, String starring, String genre, String director,
			boolean isRelease) {
		mDao.SetMovie(poster, summary, name, starring, genre, director, isRelease);
	}
	
	public void DeleteMovie(int movieID) {
		mDao.DeleteMovie(movieID);
	}
}
