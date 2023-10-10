package com.example.demo.repository;

import com.example.demo.entity.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CuaHangRepository extends JpaRepository<CuaHang, UUID> {
    @Query("SELECT ojb FROM CuaHang ojb WHERE ojb.ma = ?1")
    public CuaHang findByMa(String ma);
}
