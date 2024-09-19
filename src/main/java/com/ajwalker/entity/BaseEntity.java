package com.ajwalker.entity;

import com.ajwalker.utility.enums.EState;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@MappedSuperclass
public class BaseEntity {

    private EState state;
    private LocalDate createAt;
    private LocalDate updateAt;

}