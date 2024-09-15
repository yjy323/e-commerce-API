package com.project.api.member;

import static org.junit.jupiter.api.Assertions.*;

import com.project.api.entity.member.Member;
import com.project.api.repository.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberTest {

  @Autowired
  MemberRepository memberRepository;

  @Test
  @Rollback(value = false)
  public void createMemberTest() throws Exception {
    //Given
    String email = "example@example.com";
    String password = "qwer1234";
    String phoneNumber = "010-1234-5678";
    Member member = Member.createMember(email, password, phoneNumber);

    //When
    Long memberId = memberRepository.save(member).getId();

    //Then
    assertEquals(member, memberRepository.findById(memberId).get());
  }
}