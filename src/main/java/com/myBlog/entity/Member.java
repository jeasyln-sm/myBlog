package com.myBlog.entity;

import com.myBlog.constant.Role;
import com.myBlog.dto.MemberDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;


    public static Member createMember(MemberDTO memberDTO, PasswordEncoder passwordEncoder) {
        Member member = Member.builder()
                .role(Role.USER)
                .email(memberDTO.getEmail())
                .address(memberDTO.getAddress())
                .name(memberDTO.getName())
                .password(passwordEncoder.encode(memberDTO.getPassword()))
                .build();

        return member;
    }

}
