package com.project.api.entity.order;

import com.project.api.entity.member.Member;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import lombok.Getter;

@Entity
@Getter
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue
  @Column(name = "order_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private Member member;

  @OneToMany(mappedBy = "order")
  private List<OrderItem> orderItems;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "delivery_id")
  private Delivery delivery;

  private Long totalPrice;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  private LocalDateTime orderDate;

  /**
   * 생성자
   */
  protected Order() {
  }

  private Order(Member member,
      List<OrderItem> orderItems,
      Delivery delivery,
      Long totalPrice) {
    this.member = member;
    this.orderItems = orderItems;
    this.delivery = delivery;
    this.totalPrice = totalPrice;

    // 기본값
    this.status = OrderStatus.ORDER;
    this.orderDate = LocalDateTime.now(ZoneOffset.UTC);
  }

  private Order createOrder(Member member,
      List<OrderItem> orderItems,
      Delivery delivery,
      Long totalPrice) {
    return new Order(member, orderItems, delivery, totalPrice);
  }
}
