package jpa.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entities.Favorite;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-12T15:35:21")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile SingularAttribute<Movie, String> genre;
    public static volatile SingularAttribute<Movie, Integer> metascore;
    public static volatile SingularAttribute<Movie, Integer> imdbVotes;
    public static volatile SingularAttribute<Movie, String> runtime;
    public static volatile SingularAttribute<Movie, Integer> imdbID;
    public static volatile SingularAttribute<Movie, String> type;
    public static volatile SingularAttribute<Movie, String> director;
    public static volatile SingularAttribute<Movie, String> country;
    public static volatile SingularAttribute<Movie, String> plot;
    public static volatile SingularAttribute<Movie, Integer> id;
    public static volatile SingularAttribute<Movie, Date> released;
    public static volatile SingularAttribute<Movie, String> imdbRating;
    public static volatile SingularAttribute<Movie, String> title;
    public static volatile CollectionAttribute<Movie, Favorite> favoriteCollection;
    public static volatile SingularAttribute<Movie, String> awards;
    public static volatile SingularAttribute<Movie, String> poster;
    public static volatile SingularAttribute<Movie, String> actors;
    public static volatile SingularAttribute<Movie, Date> year;
    public static volatile SingularAttribute<Movie, String> language;
    public static volatile SingularAttribute<Movie, String> writer;
    public static volatile SingularAttribute<Movie, String> rated;

}