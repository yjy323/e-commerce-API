package com.project.api.entity.item;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Entity
@Getter
public class Item {

  @Id
  @GeneratedValue
  @Column(name = "item_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private Category category;

  private String name;

  /*
   * DB에서 이미지를 처리하는 방법을 학습하고 구체화 한다.
   * */
  private String image;

  private String contents;

  @OneToMany(mappedBy = "item")
  private List<ItemOption> options;

  private Long price;

  private Long salePrice;

  private Long quantity;

  @Enumerated(EnumType.STRING)
  private ItemStatus status;

  private LocalDateTime createDate;

  /*
   * 생성자
   * */
  protected Item() {

  }

  private Item(Category category,
      String name,
      String image,
      String contents,
      List<ItemOption> options,
      Long price,
      Long quantity) {
    this.category = category;
    this.name = name;
    this.image = image;
    this.contents = contents;

    if (options == null) {
      this.options = new ArrayList<>();
    } else {
      this.options = options;
    }

    this.price = price;
    this.salePrice = this.price;
    this.quantity = quantity;

    // 기본값
    this.status = ItemStatus.SALES;
    this.createDate = LocalDateTime.now(ZoneOffset.UTC);
  }

  public Item createItem(Category category,
      String name,
      String image,
      String contents,
      List<ItemOption> options,
      Long price,
      Long quantity) {
    return new Item(category, name, image, contents, options, price, quantity);
  }
}
