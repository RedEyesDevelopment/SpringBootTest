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

    @Column(name = "FILE_UPLOADED")
    private Timestamp uploadDate;

    @Column(name = "FILE_AUTHOR")
    private User author;

    @Column(name = "USER_ENABLED")
    private boolean enabled;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileOnServer that = (FileOnServer) o;

        if (enabled != that.enabled) return false;
        if (!filename.equals(that.filename)) return false;
        return author.equals(that.author);

    }

    @Override
    public int hashCode() {
        int result = filename.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + (enabled ? 1 : 0);
        return result;
    }
}
