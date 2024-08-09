package com.myBlog.service;

import com.myBlog.dto.ArticleDTO;
import com.myBlog.entity.Article;
import com.myBlog.entity.Member;
import com.myBlog.repository.ArticleRepository;
import com.myBlog.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;


    // 포스트 등록
    public void saveArticle(ArticleDTO articleDTO, Member member) {
        Article article = Article.createArticle(articleDTO, member);
        articleRepository.save(article);
    }

}
