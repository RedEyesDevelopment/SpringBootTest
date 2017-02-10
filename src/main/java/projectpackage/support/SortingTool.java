package projectpackage.support;

import org.springframework.data.domain.Sort;

/**
 * Created by Admin on 10.02.2017.
 */
public class SortingTool {

    //    Static sorting method - creates sort class with parameter and boolean isAscend?
    public static Sort getSort(String sortingParameter, Boolean ascend){
        Sort.Direction direction;
        if (ascend) {
            direction = Sort.Direction.ASC;
        } else {
            direction = Sort.Direction.DESC;
        }
        Sort sort = new Sort(new Sort.Order(direction, sortingParameter));
        return sort;
    }
}
