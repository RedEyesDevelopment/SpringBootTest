package projectpackage.pagination;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 24.02.2017.
 */
public class PagesCollection implements Serializable{
    private List<PaginationLink> pages;
    private long count;

    public PagesCollection(Long itemsCount) {
        count = itemsCount;
        pages = new ArrayList<>();
    }

    public List<PaginationLink> getPages() {
        return pages;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void add(PaginationLink paginationLink){
        pages.add(paginationLink);
    }
}
