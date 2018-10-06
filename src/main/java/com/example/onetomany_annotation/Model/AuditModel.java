package com.example.onetomany_annotation.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class )
@JsonIgnoreProperties(
        value={"createdAt","updateAt"},
                             allowGetters = true
)
public abstract class AuditModel implements Serializable {

  @Temporal( TemporalType.TIMESTAMP )
  @Column(name = "created_at" ,nullable=false,updatable = false)
  @CreatedDate
  private Date createAt;

  @Temporal( TemporalType.TIMESTAMP )
  @Column(name = "update_at",nullable = false)
  @LastModifiedDate
  private Date updateAt;

  @CreatedBy
  protected String createdBy;

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Date getCreateAt() {
    return createAt;
  }


  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

  public Date getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(Date updateAt) {
    this.updateAt = updateAt;
  }
}
