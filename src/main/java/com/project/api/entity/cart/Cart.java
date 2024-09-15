package com.project.api.entity.cart;

import com.project.api.entity.member.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Entity
@Getter
public class Cart {

  @Id
  @GeneratedValue
  @Column(name = "cart_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

  @OneToMany(mappedBy = "cart")
  private List<CartItem> cartItems;

  private Long totalPrice;

  /**
   * 생성자
   */
  protected Cart() {
  }

  private Cart(Member member,
      List<CartItem> cartItems,
      Long totalPrice) {

    this.member = member;

    if (cartItems == null) {
      this.cartItems = new ArrayList<>();
    } else {
      this.cartItems = cartItems;
    }

    this.totalPrice = totalPrice;
  }

  public Cart createCart(Member member,
      List<CartItem> cartItems,
      Long totalPrice) {
    return new Cart(member, cartItems, totalPrice);
  }
}
