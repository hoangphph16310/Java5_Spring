package com.example.demo.repository;

import com.example.demo.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {
    @Query("SELECT ojb FROM ChucVu ojb WHERE ojb.ma = ?1")
    public ChucVu findByMa (String ma);
}
