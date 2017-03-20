package projectpackage.model.News;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Lenovo on 02.03.2017.
 */
@Entity
@Table(name = "TAGS")
public class Tag {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "TAG_ID")
    private int id;

    @Column(name = "TAG_DATA")
    private String tagData;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "NEWS_TAGS_MAG", joinColumns = @JoinColumn(name = "TN_TAG_ID"), inverseJoinColumns = @JoinColumn(name = "TN_NEWS_ID"))
    private Set<News> news;
}
