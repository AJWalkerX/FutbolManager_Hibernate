package com.ajwalker.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@Builder
@Data
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
