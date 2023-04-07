package com.example.project.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class Member extends BaseEntity {
    @Id
    @GeneratedValue
    private Long idx;
    @Column
    private String id;
    private String pw;
}
