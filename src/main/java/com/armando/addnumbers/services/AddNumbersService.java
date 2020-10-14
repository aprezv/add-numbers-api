package com.armando.addnumbers.services;

import com.armando.addnumbers.model.http.AddNumbersRequest;
import com.armando.addnumbers.model.http.AddNumbersResult;

/**
 * Created on 2020-10-14.
 */
public interface AddNumbersService {
    AddNumbersResult add(AddNumbersRequest request);
}
