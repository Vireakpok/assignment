package com.spring.boot.books.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {

  @Id
  @GeneratedValue(
      strategy = GenerationType.AUTO
  )
  private Integer id;
  @Column(nullable = false, unique = true)
  private String name;
  @ManyToMany(mappedBy = "roles")
  private List<User> users;
}
