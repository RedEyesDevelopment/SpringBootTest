package projectpackage.model.News;

import projectpackage.model.Files.FileOnServer;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Lenovo on 02.03.2017.
 */
@Entity
@Table(name = "NEWS")
public class News {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "NEWS_ID")
    private int id;

    @Column(name="NEWS_NAME")
    private String name;

    @Column(name="NEWS_AUTHOR")
    private int authorId;

    @Column(name = "NEWS_POSTED")
    private Timestamp postedDate;

    @Column(name="NEWS_DESCR")
    private String description;

    @Column(name = "NEWS_DATA")
    private String data;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "NEWS_TAGS_MAG", joinColumns = @JoinColumn(name = "TN_NEWS_ID"), inverseJoinColumns = @JoinColumn(name = "TN_TAG_ID"))
    private Set<Tag> tags = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="NEWS_AUTHOR")
    private FileOnServer image;

    @Column(name="NEWS_ENABLED")
    private Boolean enabled;
}
