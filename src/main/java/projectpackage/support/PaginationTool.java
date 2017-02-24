package projectpackage.support;

import projectpackage.pagination.FilePageLinkCreator;
import projectpackage.pagination.PagesCollection;
import projectpackage.pagination.PaginationLink;
import projectpackage.service.FilesService;

/**
 * Created by Lenovo on 24.02.2017.
 */
public class PaginationTool {
    //Публичный метод построения объекта-хранилища для списка ссылок на странице файлов
    public static PagesCollection getFilesPageCollection(FilesService filesService, Integer quantity, Integer offset, String sort, boolean ascend) {
        FilePageLinkCreator filePageLinkCreator = new FilePageLinkCreator();

        Long filesCount = filesService.count();
        PagesCollection pagesCollection = new PagesCollection(filesCount);
        Object[] sortingParameters;
        sortingParameters= new Object[]{sort, ascend};

        PaginationLink firstPaginationLink = filePageLinkCreator.createPaginationLink("first", quantity, 0, filesCount, offset, sortingParameters);
        pagesCollection.add(firstPaginationLink);

        for (PaginationLink paginationLink : filePageLinkCreator.generatePageLinks(0, filesCount, offset, quantity, sortingParameters)) {
            pagesCollection.add(paginationLink);
        }

        Integer pagesCount = Math.toIntExact(filesCount / quantity);
        System.out.println("last page offset: pagescount="+pagesCount+" quantity="+quantity+ " result is="+pagesCount*quantity);
        PaginationLink lastPaginationLink = filePageLinkCreator.createPaginationLink("last", quantity, pagesCount * quantity, filesCount, offset, sortingParameters);
        pagesCollection.add(lastPaginationLink);

        return pagesCollection;
    }

}
