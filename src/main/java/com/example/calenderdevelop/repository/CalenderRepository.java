package com.example.calenderdevelop.repository;

import com.example.calenderdevelop.entity.Calender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalenderRepository extends JpaRepository<Calender, Long> {
}
