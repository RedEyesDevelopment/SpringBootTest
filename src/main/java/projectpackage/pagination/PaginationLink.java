package projectpackage.pagination;

/**
 * Created by Lenovo on 24.02.2017.
 */
public class PaginationLink {
    public static final int MAXPAGESSHOW = 5;
    private String pageIndex;
    private String pageLink;
    private boolean disabled;

    public PaginationLink() {
        disabled=false;
    }

    public String getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(String pageIndex) {
        this.pageIndex = pageIndex;
    }

    public String getPageLink() {
        return pageLink;
    }

    public void setPageLink(String pageLink) {
        this.pageLink = pageLink;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaginationLink that = (PaginationLink) o;

        if (isDisabled() != that.isDisabled()) return false;
        if (!getPageIndex().equals(that.getPageIndex())) return false;
        return getPageLink().equals(that.getPageLink());
    }

    @Override
    public int hashCode() {
        int result = getPageIndex().hashCode();
        result = 31 * result + getPageLink().hashCode();
        result = 31 * result + (isDisabled() ? 1 : 0);
        return result;
    }
}
