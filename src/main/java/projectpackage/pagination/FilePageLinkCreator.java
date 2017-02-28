package projectpackage.pagination;

/**
 * Created by Lenovo on 24.02.2017.
 */
public class FilePageLinkCreator extends PageLinkCreator {

    //Метод создания объекта "Ссылка на страницу"
    public AbstractPaginationLink createPaginationLink(String pageIndex, Integer quantity, Integer offset, Long objectCollectionCount, Integer currentPointer, Object[] sortingParameters) {
        FilesPaginationLink paginationLink = new FilesPaginationLink();
        paginationLink.setPageIndex(pageIndex);

        fillLinkParameters(paginationLink, sortingParameters, offset);

        calculatePaginationLinkDisability(paginationLink, quantity, objectCollectionCount, currentPointer, offset);
        return paginationLink;
    }

    @Override
    void fillLinkParameters(AbstractPaginationLink paginationLink, Object[] sortingParameters, Integer offset) {
        FilesPaginationLink filesPaginationLink = (FilesPaginationLink) paginationLink;
        filesPaginationLink.setQuantity((Integer) sortingParameters[0]);
        filesPaginationLink.setOffset(offset);
        filesPaginationLink.setSort((String)sortingParameters[1]);
        filesPaginationLink.setAscend((Boolean) sortingParameters[2]);
    }
}
