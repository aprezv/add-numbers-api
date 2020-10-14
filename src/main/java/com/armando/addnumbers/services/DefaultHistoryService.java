package com.armando.addnumbers.services;

import com.armando.addnumbers.model.http.AddNumbersResult;
import com.armando.addnumbers.model.jpa.HistoryRecord;
import com.armando.addnumbers.repositories.HistoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created on 2020-10-13.
 */
@Service
public class DefaultHistoryService implements HistoryService {
    private final HistoryRepository historyRepository;

    public DefaultHistoryService(final HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public Page<HistoryRecord> getHistory(Pageable pageable){
        return historyRepository.findAll(pageable);
    }

    @Override
    public Page<HistoryRecord> getHistory(){
        return getHistory(Pageable.unpaged());
    }

    @Override
    public void saveToHistory(AddNumbersResult result) {

        HistoryRecord historyRecord =
                HistoryRecord.builder()
                        .addend1(result.getAddend1())
                        .addend2(result.getAddend2())
                        .result(result.getResult())
                        .build();

        historyRepository.save(historyRecord);
    }

}
