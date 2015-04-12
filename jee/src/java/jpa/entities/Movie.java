/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author K-LED
 */
@Entity
@Table(name = "movie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findById", query = "SELECT m FROM Movie m WHERE m.id = :id"),
    @NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title = :title"),
    @NamedQuery(name = "Movie.findByYear", query = "SELECT m FROM Movie m WHERE m.year = :year"),
    @NamedQuery(name = "Movie.findByRated", query = "SELECT m FROM Movie m WHERE m.rated = :rated"),
    @NamedQuery(name = "Movie.findByReleased", query = "SELECT m FROM Movie m WHERE m.released = :released"),
    @NamedQuery(name = "Movie.findByRuntime", query = "SELECT m FROM Movie m WHERE m.runtime = :runtime"),
    @NamedQuery(name = "Movie.findByGenre", query = "SELECT m FROM Movie m WHERE m.genre = :genre"),
    @NamedQuery(name = "Movie.findByDirector", query = "SELECT m FROM Movie m WHERE m.director = :director"),
    @NamedQuery(name = "Movie.findByWriter", query = "SELECT m FROM Movie m WHERE m.writer = :writer"),
    @NamedQuery(name = "Movie.findByActors", query = "SELECT m FROM Movie m WHERE m.actors = :actors"),
    @NamedQuery(name = "Movie.findByPlot", query = "SELECT m FROM Movie m WHERE m.plot = :plot"),
    @NamedQuery(name = "Movie.findByLanguage", query = "SELECT m FROM Movie m WHERE m.language = :language"),
    @NamedQuery(name = "Movie.findByCountry", query = "SELECT m FROM Movie m WHERE m.country = :country"),
    @NamedQuery(name = "Movie.findByAwards", query = "SELECT m FROM Movie m WHERE m.awards = :awards"),
    @NamedQuery(name = "Movie.findByPoster", query = "SELECT m FROM Movie m WHERE m.poster = :poster"),
    @NamedQuery(name = "Movie.findByMetascore", query = "SELECT m FROM Movie m WHERE m.metascore = :metascore"),
    @NamedQuery(name = "Movie.findByImdbRating", query = "SELECT m FROM Movie m WHERE m.imdbRating = :imdbRating"),
    @NamedQuery(name = "Movie.findByImdbVotes", query = "SELECT m FROM Movie m WHERE m.imdbVotes = :imdbVotes"),
    @NamedQuery(name = "Movie.findByImdbID", query = "SELECT m FROM Movie m WHERE m.imdbID = :imdbID"),
    @NamedQuery(name = "Movie.findByType", query = "SELECT m FROM Movie m WHERE m.type = :type")})
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "title")
    private String title;
    @Column(name = "year")
    @Temporal(TemporalType.DATE)
    private Date year;
    @Size(max = 45)
    @Column(name = "rated")
    private String rated;
    @Column(name = "released")
    @Temporal(TemporalType.DATE)
    private Date released;
    @Size(max = 45)
    @Column(name = "runtime")
    private String runtime;
    @Size(max = 45)
    @Column(name = "genre")
    private String genre;
    @Size(max = 45)
    @Column(name = "director")
    private String director;
    @Size(max = 45)
    @Column(name = "writer")
    private String writer;
    @Size(max = 45)
    @Column(name = "actors")
    private String actors;
    @Size(max = 45)
    @Column(name = "plot")
    private String plot;
    @Size(max = 45)
    @Column(name = "language")
    private String language;
    @Size(max = 45)
    @Column(name = "country")
    private String country;
    @Size(max = 45)
    @Column(name = "awards")
    private String awards;
    @Size(max = 45)
    @Column(name = "poster")
    private String poster;
    @Column(name = "metascore")
    private Integer metascore;
    @Size(max = 45)
    @Column(name = "imdbRating")
    private String imdbRating;
    @Column(name = "imdbVotes")
    private Integer imdbVotes;
    @Column(name = "imdbID")
    private Integer imdbID;
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    @OneToMany(mappedBy = "idMovie")
    private Collection<Favorite> favoriteCollection;

    public Movie() {
    }

    public Movie(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Integer getMetascore() {
        return metascore;
    }

    public void setMetascore(Integer metascore) {
        this.metascore = metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Integer getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(Integer imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public Integer getImdbID() {
        return imdbID;
    }

    public void setImdbID(Integer imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<Favorite> getFavoriteCollection() {
        return favoriteCollection;
    }

    public void setFavoriteCollection(Collection<Favorite> favoriteCollection) {
        this.favoriteCollection = favoriteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Movie[ id=" + id + " ]";
    }
    
}
