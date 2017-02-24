package projectpackage.pagination;

import java.util.ArrayList;

/**
 * Created by Lenovo on 24.02.2017.
 */
public class FilePageLinkCreator extends PageLinkCreator {

    //Метод создания объекта "Ссылка на страницу"
    public PaginationLink createPaginationLink(String pageIndex, Integer quantity, Integer offset, Long objectCollectionCount, Integer currentPointer, Object[] sortingParameters) {
        PaginationLink paginationLink = new PaginationLink();
        paginationLink.setPageIndex(pageIndex);

        String sort = (String) sortingParameters[0];
        Boolean ascend = (Boolean) sortingParameters[1];

        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("@{/fileapi/filelist(for=");
        arrayList.add(String.valueOf(quantity));
        arrayList.add(",show=");
        arrayList.add(String.valueOf(offset));
        arrayList.add(",sort=");
        arrayList.add(sort);
        arrayList.add(",ascend=");
        arrayList.add(String.valueOf(ascend));
        arrayList.add(")}");
        paginationLink.setPageLink(buildLink(arrayList));

        paginationLink.setDisabled(calculatePaginationLinkDissability(quantity, objectCollectionCount, currentPointer, offset));
        return paginationLink;
    }
}
