package projectpackage.model.AuthEntities;

import projectpackage.i18n.WebLocale;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Lenovo on 17.02.2017.
 */
@Entity
@Table(name = "SESSIONS")
public class UserSession {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "SESSION_ID")
    private long id;

    @Column(name = "SESSION_USER_ID")
    private long userId;

    @Transient
    transient private String username;

    @Transient
    transient private String fullname;

    @Column(name = "FILES_QUANTITY")
    private int filesQuantity;

    @Column(name = "FILES_OFFSET")
    private int filesOffset;

    @Column(name = "FILES_SORT")
    private String filesSortParameter;

    @Column(name = "FILES_ASCEND")
    private boolean filesAscend;

    @Column(name = "USER_LOCALE")
    @Enumerated(EnumType.STRING)
    private WebLocale locale;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getFilesQuantity() {
        return filesQuantity;
    }

    public void setFilesQuantity(int filesQuantity) {
        this.filesQuantity = filesQuantity;
    }

    public int getFilesOffset() {
        return filesOffset;
    }

    public void setFilesOffset(int filesOffset) {
        this.filesOffset = filesOffset;
    }

    public String getFilesSortParameter() {
        return filesSortParameter;
    }

    public void setFilesSortParameter(String filesSortParameter) {
        this.filesSortParameter = filesSortParameter;
    }

    public boolean isFilesAscend() {
        return filesAscend;
    }

    public void setFilesAscend(boolean filesAscend) {
        this.filesAscend = filesAscend;
    }

    public WebLocale getLocale() {
        return locale;
    }

    public void setLocale(WebLocale locale) {
        this.locale = locale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSession that = (UserSession) o;

        return getUserId() == that.getUserId();
    }

    @Override
    public int hashCode() {
        return (int) (getUserId() ^ (getUserId() >>> 32));
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "id=" + id +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", filesQuantity=" + filesQuantity +
                ", filesOffset=" + filesOffset +
                ", filesSortParameter='" + filesSortParameter + '\'' +
                ", filesAscend=" + filesAscend +
                ", locale=" + locale +
                '}';
    }
}
