package com.example.calenderdevelop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name="calender")
public class Calender extends BaseEntity {
    @Id

    private Long id;


}
