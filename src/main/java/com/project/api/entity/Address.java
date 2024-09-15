package com.project.api.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {

  private String city;
  private String district;
  private String street;

  protected Address() {
  }

  public Address(String city, String district, String street) {
    this.city = city;
    this.district = district;
    this.street = street;
  }
}
