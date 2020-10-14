package com.armando.addnumbers.services;

import com.armando.addnumbers.model.http.AddNumbersResult;
import com.armando.addnumbers.model.jpa.HistoryRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created on 2020-10-14.
 */
public interface HistoryService {
    Page<HistoryRecord> getHistory(Pageable pageable);

    Page<HistoryRecord> getHistory();

    void saveToHistory(AddNumbersResult result);
}
