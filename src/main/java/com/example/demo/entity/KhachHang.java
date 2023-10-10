package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "KhachHang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ho")
    private String ho;
    @Column(name = "TenDem")
    private String tenDem;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "NgaySinh")
    private String ngaySinh;
    @Column(name = "Sdt")
    private String sdt;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "ThanhPho")
    private String thanhPho;
    @Column(name = "QuocGia")
    private String quocGia;

}

