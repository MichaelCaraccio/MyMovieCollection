package jpa.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entities.Movie;
import jpa.entities.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-19T17:09:03")
@StaticMetamodel(Favorite.class)
public class Favorite_ { 

    public static volatile SingularAttribute<Favorite, Integer> id;
    public static volatile SingularAttribute<Favorite, String> status;
    public static volatile SingularAttribute<Favorite, String> favoritecol;
    public static volatile SingularAttribute<Favorite, User> idUser;
    public static volatile SingularAttribute<Favorite, Movie> idMovie;

}