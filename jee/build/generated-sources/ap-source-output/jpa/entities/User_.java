package jpa.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entities.Favorite;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-17T11:40:43")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> username;
    public static volatile CollectionAttribute<User, Favorite> favoriteCollection;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, String> lastname;
    public static volatile SingularAttribute<User, String> role;
    public static volatile SingularAttribute<User, String> password;

}