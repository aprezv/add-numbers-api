package com.armando.addnumbers.resources;

import com.armando.addnumbers.model.http.AddNumbersRequest;
import com.armando.addnumbers.model.http.AddNumbersResult;
import com.armando.addnumbers.services.AddNumbersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2020-10-13.
 */
@RestController
@RequestMapping("/add")
public class AddNumbersResource {
    private final AddNumbersService service;

    public AddNumbersResource(final AddNumbersService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<AddNumbersResult> add(@RequestBody final AddNumbersRequest request){
        AddNumbersResult response = service.add(request);
        return ResponseEntity.ok(response);
    }
}
