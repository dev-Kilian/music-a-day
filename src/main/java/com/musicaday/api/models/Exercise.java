package com.musicaday.api.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title; // Question title
    private String description; // Optional
    private String type; // Rhythm, intervals, theory, melody...
    private String difficulty; // Optional but could be used to differentiate between easier, better-known concepts and more complex ones
    private String imageUrl;
    private String videoUrl;
    private String audioUrl;
    private String correctAnswer;
    
    @ElementCollection
    private List<String> answers; // Set of answers, one of them being the correct one

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL)
    private List<Result> results = new ArrayList<>();

    
}
