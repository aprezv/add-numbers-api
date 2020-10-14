package com.armando.addnumbers.model.http;

import lombok.Data;

/**
 * Created on 2020-10-13.
 */
@Data
public class AddNumbersRequest {
    private int[] addend1;
    private int[] addend2;
}
