package com.example.calenderdevelop.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String comments;

    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name= "calender_id")
    private Calender calender;

    public Comment() {
    }

    public Comment(String comments, User user, Calender calender) {
        this.comments = comments;
        this.user = user;
        this.calender = calender;
    }
}
