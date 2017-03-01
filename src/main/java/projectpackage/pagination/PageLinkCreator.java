package projectpackage.pagination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 24.02.2017.
 */
public abstract class PageLinkCreator {
    abstract AbstractPaginationLink createPaginationLink(String pageIndex, Integer quantity, Integer offset, Long objectCollectionCount, Integer currentPointer, Object[] sortingParameters);

    abstract void fillLinkParameters(AbstractPaginationLink paginationLink, Object[] sortingParameters, Integer offset);

    //Метод для генерации постраничного списка
    public List<AbstractPaginationLink> generatePageLinks(Integer objectCollectionStartingPoint, Long objectCollectionCount, Integer currentPointer, Integer objectsOnPage, Object[] sortingParameters) {
        List<AbstractPaginationLink> paginationLinks = new ArrayList<>();
        Integer pagesCount;
        if ((objectCollectionCount / objectsOnPage) < AbstractPaginationLink.MAXPAGESSHOW) {
            pagesCount = Math.toIntExact(objectCollectionCount / objectsOnPage);
        } else pagesCount = AbstractPaginationLink.MAXPAGESSHOW;

        int startingIterateValue;
        int endingIterateValue;

        Integer halfOfPages = pagesCount / 2;
        if ((currentPointer - (halfOfPages * objectsOnPage)) < objectsOnPage) {
            startingIterateValue = 0;
            endingIterateValue = startingIterateValue + (pagesCount * objectsOnPage);
        } else if ((objectCollectionCount - currentPointer) < (halfOfPages * objectsOnPage)) {
            Long lastPageOffset = (objectCollectionCount / objectsOnPage) * objectsOnPage;
            Long startingresult = lastPageOffset - (objectsOnPage * pagesCount);
            startingIterateValue = Math.toIntExact(startingresult+objectsOnPage);
            endingIterateValue = Math.toIntExact(lastPageOffset+objectsOnPage);
        } else {
            startingIterateValue = currentPointer - (halfOfPages * objectsOnPage);
            endingIterateValue = startingIterateValue + (pagesCount * objectsOnPage);
        }

        for (int i = startingIterateValue; i < endingIterateValue; i += objectsOnPage) {
            AbstractPaginationLink recentAbstractPaginationLink = createPaginationLink(String.valueOf((i / objectsOnPage) + 1), objectsOnPage, i, objectCollectionCount, currentPointer, sortingParameters);
            paginationLinks.add(recentAbstractPaginationLink);
        }
        return paginationLinks;
    }

    //Метод вычисления параметра disabled,active для ссылки
    static void calculatePaginationLinkDisability(AbstractPaginationLink paginationLink, Integer objectsPerPage, Long objectCollectionCount, Integer currentPointer, Integer currentPageLinkOffset) {
        if (currentPointer.equals(currentPageLinkOffset) && !(paginationLink.getPageIndex().equals("first") || paginationLink.getPageIndex().equals("last"))) {
            paginationLink.setActive(true);
        }

        Long lastPageOffset = (objectCollectionCount / objectsPerPage) * objectsPerPage;
        if (lastPageOffset.equals(objectCollectionCount)) lastPageOffset = objectCollectionCount - objectsPerPage;

        if ((currentPointer >= lastPageOffset && paginationLink.getPageIndex().equals("last")) || (currentPointer.equals(0) && currentPageLinkOffset.equals(0) && paginationLink.getPageIndex().equals("first"))) {
            paginationLink.setDisabled(true);
        }
    }
}
