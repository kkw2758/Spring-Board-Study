package com.example.project.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // 엔티티는 아니지만 나를 상속받으면 아래 필드 추가해준다
@EntityListeners({AuditingEntityListener.class}) // 데이터가 변경이 생기면 변경사항을 모니터링
@Setter
@Getter
public abstract class BaseEntity {
    @CreatedDate // 데이터가 새로들어올때
    @Column(updatable = false)  // 작성일 변경되면 안되기때문에 updatable = false 설정
    private LocalDateTime regDate;

    @LastModifiedDate // 데이터가 마지막 변경이 되면 업데이트
    private LocalDateTime modDate;
}
