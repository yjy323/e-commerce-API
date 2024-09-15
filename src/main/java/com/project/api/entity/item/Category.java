package com.project.api.entity.item;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Entity
@Getter
public class Category {

  @Id
  @GeneratedValue
  @Column(name = "category_id")
  private Long id;

  String name;

  @OneToMany(mappedBy = "category")
  List<Item> items;

  /**
   * 생성자
   */
  protected Category() {

  }

  private Category(String name) {
    this.name = name;
    this.items = new ArrayList<>();
  }

  public Category createCategory(String name) {
    return new Category(name);
  }
}
