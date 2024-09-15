package com.project.api.entity.member;

import com.project.api.entity.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Getter;

@Entity
@Getter
public class MemberAddress {

  @Id
  @GeneratedValue
  @Column(name = "member_address_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

  private String postcode;

  @Embedded()
  private Address address;

  private String recipientName;

  private String recipientPhoneNumber;

  private String request;

  private boolean isDefault;

  private LocalDateTime addDate;

  protected MemberAddress() {
  }

  private MemberAddress(Member member,
      String postcode,
      Address address,
      String recipientName,
      String recipientPhoneNumber,
      String request) {
    this.member = member;
    this.postcode = postcode;
    this.address = address;
    this.recipientName = recipientName;
    this.recipientPhoneNumber = recipientPhoneNumber;
    this.request = request;
    this.isDefault = false;
    this.addDate = LocalDateTime.now();
  }
}
