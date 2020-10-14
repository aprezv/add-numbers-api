package com.armando.addnumbers.model.http;

import lombok.Builder;
import lombok.Data;

/**
 * Created on 2020-10-13.
 */
@Data
@Builder
public class AddNumbersResult {
    private int[] addend1;
    private int[] addend2;
    private int[] result;
}
