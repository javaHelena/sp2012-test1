package models;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * @author : Helena Hjertén
 */
@Entity
public class Comment extends Model {
    
    @Id
    public Long id;

    @Required
    public String greeting;

    @Required
    public String author;
    
    public Comment(String greeting, String author){
        this.greeting = greeting;
        this.author = author;
    }
    
    public static List<Comment> all(){
        return find.all();
    }

    public static void create(Comment comment) {
        comment.save();
    }

    public static Finder<Long,Comment> find = new Finder<Long,Comment>(
            Long.class, Comment.class
    );



}
