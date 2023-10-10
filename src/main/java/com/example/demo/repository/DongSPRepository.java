package com.example.demo.repository;

import com.example.demo.entity.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DongSPRepository extends JpaRepository<DongSP, UUID> {
    @Query("SELECT ojb FROM DongSP ojb WHERE ojb.ma = ?1")
    public DongSP findByMa (String ma);
}
