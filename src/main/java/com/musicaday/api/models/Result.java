package com.musicaday.api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    private String selectedAnswer;

    private boolean correct;

    private LocalDateTime answeredAt;

    private int attempts; // Optional

    private double score; // May be useful if time-based answers are implemented
}