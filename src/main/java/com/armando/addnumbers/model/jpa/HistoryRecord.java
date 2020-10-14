package com.armando.addnumbers.model.jpa;

import com.armando.addnumbers.model.converters.IntArrayConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created on 2020-10-13.
 */
@Data
@Entity
@Table(name = "history")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoryRecord {
    @Id
    @GeneratedValue
    private Long id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Convert(converter = IntArrayConverter.class)
    private int[] addend1;

    @Convert(converter = IntArrayConverter.class)
    private int[] addend2;

    @Convert(converter = IntArrayConverter.class)
    private int[] result;
}
