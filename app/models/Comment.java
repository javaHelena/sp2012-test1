package models;

import play.db.ebean.Model;

import javax.persistence.Entity;

/**
 * @author : Helena Hjertén
 */
@Entity
public class Comment extends Model {
    
    public String greeting;
    public String author;

    public static Finder<Long,Comment> find = new Finder<Long,Comment>(
            Long.class, Comment.class
    );

}
