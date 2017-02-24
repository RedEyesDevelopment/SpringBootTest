package projectpackage.support;

import projectpackage.pagination.PagesCollection;
import projectpackage.pagination.PaginationLink;
import projectpackage.service.FilesService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 24.02.2017.
 */
public class PaginationTool {
    //Публичный метод построения объекта-хранилища для списка ссылок на странице файлов
    public static PagesCollection getFilesPageCollection(FilesService filesService, Integer quantity, Integer offset, String sort, boolean ascend) {
        Long filesCount = filesService.count();
        PagesCollection pagesCollection = new PagesCollection(filesCount);

        PaginationLink firstPaginationLink = createPaginationLink("first", quantity, 0, sort, ascend, 0, filesCount, offset);

        Integer pagesCount = Math.toIntExact(filesCount % quantity);
        PaginationLink lastPaginationLink = createPaginationLink("last", quantity, pagesCount*quantity, sort, ascend, 0, filesCount, offset);


        pagesCollection.add(firstPaginationLink);
        for (PaginationLink paginationLink:generatePageLinks(0, filesCount, offset, quantity, sort, ascend)){
            pagesCollection.add(paginationLink);
        }
        pagesCollection.add(lastPaginationLink);

        return pagesCollection;
    }

//Метод для генерации постраничного списка
    private static List<PaginationLink> generatePageLinks(Integer objectCollectionStartingPoint, Long objectCollectionCount, Integer currentPointer, Integer objectsOnPage, String sortingParameter, Boolean ascendParameter) {
        List<PaginationLink> paginationLinks = new ArrayList<>();
        Integer pagesCount;
        if ((objectCollectionCount % objectsOnPage)< PaginationLink.MAXPAGESSHOW){
            pagesCount = Math.toIntExact(objectCollectionCount % objectsOnPage);
        } else pagesCount = PaginationLink.MAXPAGESSHOW;
            for (int i = 1; i < pagesCount; i++) {
                PaginationLink recentPaginationLink = createPaginationLink(String.valueOf(i),objectsOnPage,i*objectsOnPage, sortingParameter, ascendParameter, objectCollectionStartingPoint, objectCollectionCount, currentPointer);
                paginationLinks.add(recentPaginationLink);
            }
        return paginationLinks;
    }

    //Метод создания объекта "Ссылка на страницу"
    private static PaginationLink createPaginationLink(String pageIndex, Integer quantity, Integer offset, String sort, Boolean ascend, Integer objectCollectionStartingPoint, Long objectCollectionCount, Integer currentPointer) {
        PaginationLink paginationLink = new PaginationLink();
        paginationLink.setPageIndex(pageIndex);
        paginationLink.setPageLink(createFilesLink(quantity, offset, sort, ascend));
        paginationLink.setDisabled(calculatePaginationLinkDissability(quantity, objectCollectionCount, currentPointer, offset));
        return paginationLink;
    }

    //Метод вычисления параметра disabled для ссылки
    private static boolean calculatePaginationLinkDissability(Integer filesPerPage, Long objectCollectionCount, Integer currentPointer, Integer currentPageLinkOffset){
        if (currentPointer.equals(currentPageLinkOffset) || (objectCollectionCount-currentPointer)<filesPerPage){
            return true;
        }
        return false;
    }

    //Метод наполнения массива текстовой ссылки для списка файлов
    private static String createFilesLink(int quantity, int offset, String sort, boolean ascend) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("@{/fileapi/filelist(for=${");
        arrayList.add(String.valueOf(quantity));
        arrayList.add("},show=${");
        arrayList.add(String.valueOf(offset));
        arrayList.add("},sort=${");
        arrayList.add(sort);
        arrayList.add("},ascend=${");
        arrayList.add(String.valueOf(ascend));
        arrayList.add("})})");
        return buildLink(arrayList);
    }

    //Построение ссылки по массиву
    private static String buildLink(ArrayList<String> stringsToAppend) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String nextString : stringsToAppend) {
            stringBuilder.append(nextString);
        }
        return stringBuilder.toString();
    }
}
