package com.example.project.api;

import com.example.project.dto.BoardForm;
import com.example.project.entity.Article;
import com.example.project.repository.ArticleRepository;
import com.example.project.service.ArticleService;
import com.example.project.service.ArticleService1;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class ArticleController {
    @Autowired
    private ArticleService1 articleService;

    @GetMapping("/api/board")
    public List<Article> list() {
        return articleService.list();
    }

    @GetMapping("/api/board/{id}")
    public Article view(@PathVariable Long id) {
        return articleService.view(id);
    }

    @PostMapping("/api/board")
    public ResponseEntity<Article> write(@RequestBody BoardForm dto) {
        Article created = articleService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/api/board/{id}")
    public ResponseEntity<Article> edit(@PathVariable Long id, @RequestBody BoardForm dto) {
        Article updated = articleService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/api/board/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {
        // 삭제할 대상 찾기
        Article deleted = articleService.delete(id);

        return(deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).body(deleted):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        return(deleted != null) ?
//                ResponseEntity.status(HttpStatus.NO_CONTENT).build():
//                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

/*    @Autowired
    private final ArticleService articleService;

    @Autowired
    private final ArticleRepository articleRepository;

    @GetMapping("/api/board")
    public List<Article> list() {
        return articleRepository.findAll();
    }

    @GetMapping("/api/board/{id}")
    public Article view(@PathVariable Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    // 글등록하기
    @PostMapping("/api/board")
    public Article write(@RequestBody BoardForm dto) {
        Article article = dto.toEntity();
        return articleRepository.save(article);

    }

    @PatchMapping("/api/board/{id}")
    public ResponseEntity<Article> edit(@PathVariable Long id, @RequestBody BoardForm dto){
        // 수정할 엔티티 생성
        Article article = dto.toEntity();
        log.info("id:{}, article: {}", id, article.toString());
        // 대상 엔티티 조회
        Article target = articleRepository.findById(id).orElse(null);
        // 잘못된 정보 처리
        if (target == null || id != article.getId()) {
            log.info("잘못된 요청: {}, article: {}", id, article.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        // 업데이트 및 정상 응답
        target.patch(article);
        Article updated = articleRepository.save(article);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    // 글삭제하기
    @DeleteMapping("/api/board/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {
        // 삭제할 대상 찾기
        Article target = articleRepository.findById(id).orElse(null);
        // 잘못된 요청 처리
        if (target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        // 삭제 처리
        articleRepository.delete(target);
        // 데이터 변환
        return ResponseEntity.status(HttpStatus.OK).build();
    }*/
}
