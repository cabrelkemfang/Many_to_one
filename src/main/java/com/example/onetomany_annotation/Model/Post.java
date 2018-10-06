package com.example.onetomany_annotation.Model;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post extends AuditModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private  Long id;

  private String title;

  private String description;

  private String content;

  public Post(String title, String description, String content) {
    this.title = title;
    this.description = description;
    this.content = content;
  }

  public Post() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
