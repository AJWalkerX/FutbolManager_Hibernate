package com.ajwalker.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblfixture")
public class Fixture extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToOne
    private League league;

    @Override
    public String toString() {
        return "Fixture{" +
                "description='" + description + '\'' +
                ", id=" + id +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, description); //Burda ne yaptığını ANLA!!!!
    }
}
//