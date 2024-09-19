package com.ajwalker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@AllArgsConstructor
@Data
@MappedSuperclass
public class BaseEntity {

    private int state;
    @Column(name = "create_at")
    private LocalDate createAt;
    @Column(name = "update_at")
    private LocalDate updateAt;

    public BaseEntity() {
        this.state = 1;
        this.createAt = LocalDate.now();
        this.updateAt = LocalDate.now();
    }
}
