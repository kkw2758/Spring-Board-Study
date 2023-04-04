package com.example.project.service;

import com.example.project.dto.BoardForm;
import com.example.project.entity.Article;
import com.example.project.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService{
    // 방법 1
    // private final ArticleRepository articleRepository;

    // 방법 2
    @Autowired
    ArticleRepository articleRepository;

    @Override
    @Transactional // 예상치 못한 에러에 대한 롤백 대비
    public BoardForm save(BoardForm dto) {
        // 현업에서 쓰진 않는다.
        // dto를 Entity로 변경
//        Article article = Article.builder()
//                .id(dto.getId())
//                .title(dto.getTitle())
//                .content(dto.getContent())
//                .build();

        Article article = null;
        // 업데이트 또는 새로운 내용 저장 분기
        // 쓰레기값 검사 Long DB에 Long값은 1부터 저장
        if(dto.getId() != null && dto.getId() >0L) {
            Optional<Article> optionalArticle = articleRepository.findById(dto.getId());
            if (optionalArticle.isPresent()) {
                Article entity = optionalArticle.get();
                entity.setTitle(dto.getTitle());
                entity.setContent(dto.getContent());
                article = articleRepository.save(entity);
            }
        } else {
            article = dtoToEntity(dto);
            article = articleRepository.save(article); // 반환 값은 Entity
        }
        
        // Entity를 dto로 변환
//        BoardForm boardForm = BoardForm.builder()
//                .id(article.getId())
//                .title(article.getTitle())
//                .content(article.getContent())
//                .build();

        BoardForm boardForm = entityToDto(article);

        return boardForm;
    }
}
