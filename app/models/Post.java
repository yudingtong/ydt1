package models;

import java.util.Date;

import javax.persistence.*;
import io.ebean.annotation.CreatedTimestamp;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.*;
import play.data.format.Formats;
/**
 * 角色
 */
@Entity
public class Post extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    /**
     * title
     */
    
    public Node node;
    
    public User1 member;
    
    public String last_reply_by;
    
    /*
     * 时间
     */
    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedTimestamp
    public Date last_touched;
    
    public String title;
    
    public String url;
    
    /*
     * 时间
     */
    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedTimestamp
    public Date created;
    
    public String content;
    
    public String content_rendered;
    
    /*
     * 时间
     */
    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedTimestamp
    public Date last_modified;
    
    public int replies;
    
    public String memo;
    

//    public Discuss(String title,String content,int userId) {
//        this.title = title;
//        this.content = content;
//        this.userid=userId;
//    }

    public static Finder<String, Post> find = new Finder<String, Post>(
            Post.class
    );
}
