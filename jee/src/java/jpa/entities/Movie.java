/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel.decarval
 */
@Entity
@Table(name = "movie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findById", query = "SELECT m FROM Movie m WHERE m.id = :id"),
    @NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title = :title"),
    @NamedQuery(name = "Movie.findByReleased", query = "SELECT m FROM Movie m WHERE m.released = :released"),
    @NamedQuery(name = "Movie.findByRuntime", query = "SELECT m FROM Movie m WHERE m.runtime = :runtime"),
    @NamedQuery(name = "Movie.findByGenre", query = "SELECT m FROM Movie m WHERE m.genre = :genre"),
    @NamedQuery(name = "Movie.findByPlot", query = "SELECT m FROM Movie m WHERE m.plot = :plot"),
    @NamedQuery(name = "Movie.findByPoster", query = "SELECT m FROM Movie m WHERE m.poster = :poster"),
    @NamedQuery(name = "Movie.findByImdbRating", query = "SELECT m FROM Movie m WHERE m.imdbRating = :imdbRating"),
    @NamedQuery(name = "Movie.findByImdbVotes", query = "SELECT m FROM Movie m WHERE m.imdbVotes = :imdbVotes"),
    @NamedQuery(name = "Movie.findByImdbID", query = "SELECT m FROM Movie m WHERE m.imdbID = :imdbID"),
    @NamedQuery(name = "Movie.findByIdOmdb", query = "SELECT m FROM Movie m WHERE m.idOmdb = :idOmdb")})
public class Movie implements Serializable {
    @Column(name = "idOmdb")
    private Integer idOmdb;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "title")
    private String title;
    @Column(name = "released")
    @Temporal(TemporalType.DATE)
    private Date released;
    @Size(max = 45)
    @Column(name = "runtime")
    private String runtime;
    @Size(max = 45)
    @Column(name = "genre")
    private String genre;
    @Size(max = 1000)
    @Column(name = "plot")
    private String plot;
    @Size(max = 200)
    @Column(name = "poster")
    private String poster;
    @Size(max = 45)
    @Column(name = "imdbRating")
    private String imdbRating;
    @Column(name = "imdbVotes")
    private Integer imdbVotes;
    @Size(max = 30)
    @Column(name = "imdbID")
    private String imdbID;

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

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
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

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
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

    public Integer getIdOmdb() {
        return idOmdb;
    }

    public void setIdOmdb(Integer idOmdb) {
        this.idOmdb = idOmdb;
    }
    
}
