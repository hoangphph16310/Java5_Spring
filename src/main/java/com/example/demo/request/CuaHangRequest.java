package com.example.demo.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CuaHangRequest {
   @NotBlank(message = "Không được để trống")
   private String ma;
    @NotBlank(message = "Không được để trống")
   private String ten;
    @NotBlank(message = "Không được để trống")
   private String diaChi;
    @NotBlank(message = "Không được để trống")
   private String thanhPho;
    @NotBlank(message = "Không được để trống")
   private String quocGia;
}
