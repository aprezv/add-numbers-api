package com.armando.addnumbers.repositories;

import com.armando.addnumbers.model.jpa.HistoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on 2020-10-13.
 */
@Repository
public interface HistoryRepository extends JpaRepository<HistoryRecord, Long> {
}
