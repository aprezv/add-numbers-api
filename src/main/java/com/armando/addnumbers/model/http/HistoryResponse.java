package com.armando.addnumbers.model.http;

import lombok.Data;

import java.util.Date;

/**
 * Created on 2020-10-13.
 */
@Data
public class HistoryResponse {
    private Date createdDate;
    private int[] addend1;
    private int[] addend2;
    private int[] result;
}
