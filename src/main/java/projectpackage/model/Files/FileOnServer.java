package projectpackage.model.Files;

import org.springframework.data.domain.Sort;
import projectpackage.model.AuthEntities.User;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Admin on 10.02.2017.
 */
@Entity
@Table(name = "FILES")
public class FileOnServer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "FILE_ID")
    private int id;

    @Column(name = "FILE_NAME")
    private String filename;

    @Column(name = "FILE_EXTENSION")
    private String extension;

    @Column(name = "FILE_ALT")
    private String alternative;

    @Column(name = "FILE_UPLOADED")
    private Timestamp uploadDate;

    @Column(name = "FILE_AUTHOR")
    private User author;

    @Column(name = "USER_ENABLED")
    private boolean enabled;

    @Column(name = "FILE_NOT_DELETABLE")
    private boolean notDeletable;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public Timestamp getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Timestamp uploadDate) {
        this.uploadDate = uploadDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isNotDeletable() {
        return notDeletable;
    }

    public void setNotDeletable(boolean notDeletable) {
        this.notDeletable = notDeletable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileOnServer that = (FileOnServer) o;

        if (!filename.equals(that.filename)) return false;
        if (extension != null ? !extension.equals(that.extension) : that.extension != null) return false;
        return alternative.equals(that.alternative);

    }

    @Override
    public int hashCode() {
        int result = filename.hashCode();
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        result = 31 * result + alternative.hashCode();
        return result;
    }
}
