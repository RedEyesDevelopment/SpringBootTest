package tests.pagination;

import org.junit.Test;
import projectpackage.support.PaginationTool;
import tests.AbstractTest;

/**
 * Created by Lenovo on 01.03.2017.
 */
public class PaginationTests extends AbstractTest {
    @Test
    public void getFileListPagesForPaginationPurposes(){
        Long filesCount = 77L;
        System.out.println("****************************************************************");
        System.out.println("PAGINATION TESTS:");
        System.out.println("****************************************************************");
        System.out.println("First iteration, where offset=0");
        System.out.println(PaginationTool.getFilesPageCollection(filesCount,5,0,"uploadDate",true));
        System.out.println("****************************************************************");
        System.out.println("Second iteration, where offset=35");
        System.out.println(PaginationTool.getFilesPageCollection(filesCount,5,35,"uploadDate",true));
        System.out.println("****************************************************************");
        System.out.println("Third iteration, where offset=75");
        System.out.println(PaginationTool.getFilesPageCollection(filesCount,5,75,"uploadDate",true));
        System.out.println("****************************************************************");
    }

    @Test
    public void getFileListPagesForPaginationPurposesBorderCase(){
        Long filesCount = 77L;
        System.out.println("****************************************************************");
        System.out.println("PAGINATION TESTS:");
        System.out.println("****************************************************************");
        System.out.println("First iteration, where offset=50");
        System.out.println(PaginationTool.getFilesPageCollection(filesCount,5,50,"uploadDate",true));
        System.out.println("****************************************************************");
        System.out.println("Second iteration, where offset=55");
        System.out.println(PaginationTool.getFilesPageCollection(filesCount,5,55,"uploadDate",true));
        System.out.println("****************************************************************");
        System.out.println("Third iteration, where offset=60");
        System.out.println(PaginationTool.getFilesPageCollection(filesCount,5,60,"uploadDate",true));
        System.out.println("****************************************************************");
    }
}
