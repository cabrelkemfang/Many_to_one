package com.example.onetomany_annotation.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment extends AuditModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String text;

  @ManyToOne(fetch = FetchType.LAZY,optional=false)
  @JoinColumn(name = "post_id",nullable = false)
  //@OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private Post post;

  public Comment() {
  }

  public Comment(String text, Post post) {
    this.text = text;
    this.post = post;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }
}
