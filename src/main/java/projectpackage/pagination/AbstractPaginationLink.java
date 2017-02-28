package projectpackage.pagination;

/**
 * Created by Lenovo on 24.02.2017.
 */
public interface AbstractPaginationLink {
    public static final int MAXPAGESSHOW = 5;
    public String getPageIndex();
    public void setDisabled(boolean disabled);
    public void setActive(boolean active);
    public String toString();
}
