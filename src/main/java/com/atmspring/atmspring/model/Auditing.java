package com.atmspring.atmspring.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
@Data
public class Auditing implements Serializable {
    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updateAt;

}
