package projectpackage.pagination;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 24.02.2017.
 */
public class PagesCollection implements Serializable{
    private List<AbstractPaginationLink> pages;
    private long count;

    public PagesCollection(Long itemsCount) {
        count = itemsCount;
        pages = new ArrayList<>();
    }

    public List<AbstractPaginationLink> getPages() {
        return pages;
    }

    public long getCount() {
        return count;
    }

    public void add(AbstractPaginationLink paginationLink){
        pages.add(paginationLink);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("PagesCollection{" +
                "count=" + count);
        sb.append("\n");
        sb.append("PaginationLinks: ");
        sb.append("\n");
        for (AbstractPaginationLink paginationLink:pages){
            sb.append(paginationLink);
            sb.append("\n");
        }
        sb.append("PagesCollection:Finish");
        return sb.toString();
    }
}
