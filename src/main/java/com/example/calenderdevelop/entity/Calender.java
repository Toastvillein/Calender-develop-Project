package com.example.calenderdevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name="calender")
public class Calender extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false,columnDefinition = "longtext")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Calender() {
    }

    public Calender(String username, String title, String contents,User user) {
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.user = user;
    }

    public void updateCal(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
