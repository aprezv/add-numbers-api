package com.armando.addnumbers.model.converters;

import org.springframework.util.StringUtils;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created on 2020-10-13.
 */
public class IntArrayConverter implements AttributeConverter<int[], String> {
    @Override
    public String convertToDatabaseColumn(int[] arr) {
        if(arr == null)
            return "";

        return Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
    }

    @Override
    public int[] convertToEntityAttribute(String dbData) {
        if(StringUtils.isEmpty(dbData))
            return new int[0];

        return Arrays.stream(dbData.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
