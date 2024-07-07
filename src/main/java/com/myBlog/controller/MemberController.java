package com.myBlog.controller;

import com.myBlog.dto.MemberDTO;
import com.myBlog.repository.MemberRepository;
import com.myBlog.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;
    private final MemberRepository repository;

    // 회원 등록
    @GetMapping("/member/new")
    public String createMember(Model model) {
        model.addAttribute("MemberDTO", new MemberDTO());
        return "member/memberForm";
    }
}
