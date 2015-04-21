package jpa.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-21T07:42:56")
@StaticMetamodel(Favorite.class)
public class Favorite_ { 

    public static volatile SingularAttribute<Favorite, Integer> id;
    public static volatile SingularAttribute<Favorite, String> status;
    public static volatile SingularAttribute<Favorite, Integer> idUser;
    public static volatile SingularAttribute<Favorite, Integer> idMovie;

}