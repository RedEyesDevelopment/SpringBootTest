package projectpackage.pagination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 24.02.2017.
 */
public abstract class PageLinkCreator {
    abstract PaginationLink createPaginationLink(String pageIndex, Integer quantity, Integer offset, Long objectCollectionCount, Integer currentPointer, Object[] sortingParameters);

    //Метод для генерации постраничного списка
    public List<PaginationLink> generatePageLinks(Integer objectCollectionStartingPoint, Long objectCollectionCount, Integer currentPointer, Integer objectsOnPage, Object[] sortingParameters) {
        List<PaginationLink> paginationLinks = new ArrayList<>();
        Integer pagesCount;
        if ((objectCollectionCount / objectsOnPage) < PaginationLink.MAXPAGESSHOW) {
            pagesCount = Math.toIntExact(objectCollectionCount / objectsOnPage);
        } else pagesCount = PaginationLink.MAXPAGESSHOW;

        int startingIterateValue;
        int endingIterateValue;

        Integer halfOfPages = pagesCount / 2;
        if ((currentPointer - (halfOfPages * objectsOnPage)) < objectsOnPage) {
            startingIterateValue = 0;
        } else startingIterateValue = currentPointer - (halfOfPages * objectsOnPage);
        endingIterateValue = startingIterateValue + (pagesCount * objectsOnPage);

        for (int i = startingIterateValue; i < endingIterateValue; i+=objectsOnPage) {
            PaginationLink recentPaginationLink = createPaginationLink(String.valueOf((i/objectsOnPage)+1), objectsOnPage, i, objectCollectionCount, currentPointer, sortingParameters);
            paginationLinks.add(recentPaginationLink);
        }
        return paginationLinks;
    }

    //Построение ссылки по массиву
    static String buildLink(ArrayList<String> stringsToAppend) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String nextString : stringsToAppend) {
            stringBuilder.append(nextString);
        }
        return stringBuilder.toString();
    }

    //Метод вычисления параметра disabled для ссылки
    static boolean calculatePaginationLinkDissability(Integer objectsPerPage, Long objectCollectionCount, Integer currentPointer, Integer currentPageLinkOffset) {
        if (currentPointer.equals(currentPageLinkOffset) || (objectCollectionCount - currentPointer) < objectsPerPage) {
            return true;
        }
        return false;
    }
}
