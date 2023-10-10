package com.example.demo.repository;

import com.example.demo.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {
    @Query("SELECT ojb FROM KhachHang ojb WHERE ojb.ma = ?1")
    public KhachHang findByMa (String ma);
}
