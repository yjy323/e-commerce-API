package com.project.api.entity.cart;

import com.project.api.entity.item.Item;
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
public class CartItem {

  @Id
  @GeneratedValue
  @Column(name = "cart_item_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "cart_id")
  private Cart cart;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id")
  private Item item;

  private Long price;

  private Long count;

  /**
   * 생성자
   */
  protected CartItem() {
  }

  private CartItem(Cart cart,
      Item item,
      Long price,
      Long count) {
    this.cart = cart;
    this.item = item;
    this.price = price;
    this.count = count;
  }

  public CartItem AddCartItem(Cart cart,
      Item item,
      Long price,
      Long count) {
    return new CartItem(cart, item, price, count);
  }
}
