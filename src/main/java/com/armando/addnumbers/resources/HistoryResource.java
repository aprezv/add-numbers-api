package com.armando.addnumbers.resources;

import com.armando.addnumbers.model.jpa.HistoryRecord;
import com.armando.addnumbers.services.HistoryService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2020-10-13.
 */
@RestController
@RequestMapping("/history")
public class HistoryResource {
    private final HistoryService service;

    public HistoryResource(final HistoryService service) {
        this.service = service;
    }


    @GetMapping
    ResponseEntity<Page<HistoryRecord>> getHistory(@RequestParam(value = "_page", defaultValue = "0") final Integer page,
                                                     @RequestParam(value = "_size", defaultValue = "25") final Integer size
                                    ){

        Page<HistoryRecord> historyRecordPage = service.getHistory();

        //Page<HistoryResponse> responsePage = historyRecordPage.map();

        return ResponseEntity.ok(historyRecordPage);
    }
}
