package jpa.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-20T20:58:45")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile SingularAttribute<Movie, Integer> id;
    public static volatile SingularAttribute<Movie, Date> released;
    public static volatile SingularAttribute<Movie, String> genre;
    public static volatile SingularAttribute<Movie, Integer> idOmdb;
    public static volatile SingularAttribute<Movie, String> imdbRating;
    public static volatile SingularAttribute<Movie, String> title;
    public static volatile SingularAttribute<Movie, Integer> imdbVotes;
    public static volatile SingularAttribute<Movie, String> poster;
    public static volatile SingularAttribute<Movie, String> runtime;
    public static volatile SingularAttribute<Movie, String> imdbID;
    public static volatile SingularAttribute<Movie, String> plot;

}