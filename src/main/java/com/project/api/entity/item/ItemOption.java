package com.project.api.entity.item;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class ItemOption {

  @Id
  @GeneratedValue
  @Column(name = "item_option_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id")
  private Item item;

  private String name;

  private Long price;

  /**
   * 생성자
   */
  protected ItemOption() {

  }

  private ItemOption(Item item, String name, Long price) {
    this.item = item;
    this.name = name;
    this.price = price;
  }

  public ItemOption createItemOption(Item item, String name, Long price){
    return new ItemOption(item, name, price);
  }
}
