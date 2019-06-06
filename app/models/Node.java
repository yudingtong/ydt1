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
public class Node extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    /**
     * title
     */
    public String avatar_large;
    
    public String name;
    
    public String avatar_normal;
    
    public String title;
    
    public String url;
    
    public int topics;
    
    public String footer;
    
    public String header;
    
    public String title_alternative;
    
    public String avatar_mini;
    
    public int stars;
    
    public Boolean root;
    
    public String parent_node_name;
    
    
    
    /*
     * 时间
     */
    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedTimestamp
    public Date createtime;
    
    public String memo;
    

//    public Discuss(String title,String content,int userId) {
//        this.title = title;
//        this.content = content;
//        this.userid=userId;
//    }

    public static Finder<String, Node> find = new Finder<String, Node>(
            Node.class
    );
}
