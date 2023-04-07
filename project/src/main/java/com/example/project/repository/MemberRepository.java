package com.example.project.repository;

import com.example.project.entity.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {
    @Query(value = "SELECT a FROM Member a Where a.id = :id")
    Optional<Member> findById(@Param("id") String id);
}
