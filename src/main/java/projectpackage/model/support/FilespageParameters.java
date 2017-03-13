package projectpackage.model.support;

import lombok.Data;

/**
 * Created by Lenovo on 13.03.2017.
 */
@Data
public class FilespageParameters {
    private int quantity;
    private int offset;
    private String sort;
    private boolean ascend;
}
