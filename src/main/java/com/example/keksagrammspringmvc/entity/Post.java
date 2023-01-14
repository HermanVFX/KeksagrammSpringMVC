package com.example.keksagrammspringmvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "app_post")
public class Post {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "post_head")
    private String postHead;

    @Column(name = "post_text")
    private String postText;

    @Column(name = "post_date")
    private Date date = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
