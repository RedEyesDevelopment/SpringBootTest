package projectpackage.pagination;

/**
 * Created by Lenovo on 24.02.2017.
 */
public class FilesPaginationLink implements AbstractPaginationLink{
    private int quantity;
    private int offset;
    private String sort;
    private boolean ascend;
    private boolean disabled;
    private boolean active;
    private String pageIndex;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public boolean isAscend() {
        return ascend;
    }

    public void setAscend(boolean ascend) {
        this.ascend = ascend;
    }

    public String getPageIndex(){
        return pageIndex;
    }

    public void setPageIndex(String index){
        pageIndex=index;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "FilesPaginationLink{" +
                "quantity=" + quantity +
                ", offset=" + offset +
                ", sort='" + sort + '\'' +
                ", ascend=" + ascend +
                ", disabled=" + disabled +
                ", active=" + active +
                ", pageIndex='" + pageIndex + '\'' +
                '}';
    }
}
