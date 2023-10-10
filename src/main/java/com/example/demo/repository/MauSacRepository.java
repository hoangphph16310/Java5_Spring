package com.example.demo.repository;

import com.example.demo.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, UUID> {
    @Query("SELECT ojb FROM MauSac ojb WHERE ojb.ma = ?1")
    public MauSac findByMa (String ma);
}
