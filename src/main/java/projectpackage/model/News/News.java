//TODO CREATE NEWS MODEL, REPS, SERVICES, SQL TABLES, CONTOLLER, PAGES

//package projectpackage.model.News;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//import java.util.HashSet;
//import java.util.Set;
//
//import static javax.persistence.GenerationType.IDENTITY;
//
///**
// * Created by Lenovo on 02.03.2017.
// */
//@Entity
//@Table(name = "NEWS")
//public class News {
//
//    @Id
//    @GeneratedValue(strategy = IDENTITY)
//    @Column(name = "NEWS_ID")
//    private int id;
//
//    @Column(name="NEWS_AUTHOR_ID")
//    private int authorId;
//
//    @Column(name = "NEWS_POSTED_DATE")
//    private Timestamp postedDate;
//
//    @Column(name = "NEWS_DATA")
//    private String data;
//
//    private Set<News> news = new HashSet<>();
//}
