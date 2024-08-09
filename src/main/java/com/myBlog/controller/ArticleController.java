package com.myBlog.controller;

import com.myBlog.dto.ArticleDTO;
import com.myBlog.entity.Member;
import com.myBlog.service.ArticleService;
import com.myBlog.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final MemberService memberService;


    // 포스트 등록 -> 폼으로 이동
    @GetMapping("/article/new")
    public String createArticle(Model model) {
        model.addAttribute("articleDTO", new ArticleDTO());
        return "article/articleForm";
    }

    // 포스트 등록
    @PostMapping("/article/new")
    public String createArticle(@ModelAttribute("articleDTO") ArticleDTO articleDTO,
                                BindingResult bindingResult,
                                Principal principal) {
        if(bindingResult.hasErrors()) {
            return "article/articleForm";
        }

        if(principal == null) {
            return "redirect:/member/login";
        }

        String userEmail = principal.getName();
        Member member = memberService.findByEmail(userEmail);

        articleService.saveArticle(articleDTO, member);

        return "redirect:/";
    }
}
