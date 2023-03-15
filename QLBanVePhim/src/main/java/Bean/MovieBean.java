package Bean;

import java.util.Date;

public class MovieBean {
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStarring() {
		return starring;
	}
	public void setStarring(String starring) {
		this.starring = starring;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(java.sql.Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public boolean isRelease() {
		return isRelease;
	}
	public void setRelease(boolean isRelease) {
		this.isRelease = isRelease;
	}
	
	int movieID;
	String poster;
	String summary;
	String name;
	String starring;
	String genre;
	int ticketID;
	String director;
	java.sql.Date releaseDate;
	boolean isRelease;
	
	public MovieBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieBean(int movieID, String poster, String summary, String name, String starring, String genre,
			int ticketID, String director, java.sql.Date releaseDate, boolean isRelease) {
		super();
		this.movieID = movieID;
		this.poster = poster;
		this.summary = summary;
		this.name = name;
		this.starring = starring;
		this.genre = genre;
		this.ticketID = ticketID;
		this.director = director;
		this.releaseDate = releaseDate;
		this.isRelease = isRelease;
	}
	
	
	
}
