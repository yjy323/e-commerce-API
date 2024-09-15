package com.project.api.entity.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import lombok.Getter;

@Entity
@Getter
public class Member {

  @Id
  @GeneratedValue
  @Column(name = "member_id")
  private Long id;

  @NotBlank(message = "이메일을 입력하세요.")
  @Email(message = "유효하지 않은 이메일 형식입니다.")
  private String email;

  /*
   * 비밀번호 규칙 구체화
   * */
  @NotBlank(message = "비밀번호를 입력하세요.")
  private String password;

  @NotBlank(message = "휴대폰 번호를 입력하세요.")
  @Pattern(regexp = "01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$",
      message = "유효하지 않은 휴대폰 번호 형식입니다.")
  private String phoneNumber;

  @Enumerated(EnumType.STRING)
  private MemberStatus status;

  private LocalDateTime joinDate;

  private LocalDateTime deleteDate;


  /*
   * 생성자
   * */
  protected Member() {
  }

  private Member(String email, String password, String phoneNumber) {
    this.email = email;
    this.password = password;
    this.phoneNumber = phoneNumber;

    // 기본값
    this.status = MemberStatus.ACTIVE;
    this.joinDate = LocalDateTime.now(ZoneOffset.UTC);
    this.deleteDate = null;
  }

  public static Member createMember(String email, String password, String phoneNumber) {
    return new Member(email, password, phoneNumber);
  }
}
