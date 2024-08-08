package com.myBlog.dto;

import com.myBlog.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@Builder
public class ArticleDTO {

    private String title;
    private String content;
    private LocalDateTime createTime;
    private Member member;

}
