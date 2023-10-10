package com.example.demo.repository;

import com.example.demo.entity.NhaSX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NhaSXRepository extends JpaRepository<NhaSX, UUID> {
    @Query("SELECT ojb FROM NhaSX ojb WHERE ojb.ma = ?1")
    public NhaSX findByMa (String ma);
}
