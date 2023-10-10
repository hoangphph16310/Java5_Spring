package com.example.demo.repository;

import com.example.demo.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SanPhamRepository  extends JpaRepository<SanPham, UUID> {
    @Query("SELECT ojb FROM SanPham ojb WHERE ojb.ma = ?1")
    public SanPham findByMa (String ma);
}
