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

        if (getUserId() != that.getUserId()) return false;
        if (getFilesQuantity() != that.getFilesQuantity()) return false;
        if (getFilesOffset() != that.getFilesOffset()) return false;
        if (isFilesAscend() != that.isFilesAscend()) return false;
        if (getFilesSortParameter() != null ? !getFilesSortParameter().equals(that.getFilesSortParameter()) : that.getFilesSortParameter() != null)
            return false;
        return getLocale() == that.getLocale();
    }

    @Override
    public int hashCode() {
        int result = (int) (getUserId() ^ (getUserId() >>> 32));
        result = 31 * result + getFilesQuantity();
        result = 31 * result + getFilesOffset();
        result = 31 * result + (getFilesSortParameter() != null ? getFilesSortParameter().hashCode() : 0);
        result = 31 * result + (isFilesAscend() ? 1 : 0);
        result = 31 * result + getLocale().hashCode();
        return result;
    }
}
