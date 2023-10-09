package com.example.demo.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KhachHangRequest {
    @NotBlank(message = "Không được để trống !")
    private String ma;
    @NotBlank(message = "Không được để trống !")
    private String ho;
    private String tenDem;
    @NotBlank(message = "Không được để trống !")
    private String ten;
    @NotBlank(message = "Vui lòng chọn ngày sinh !")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String ngaySinh;
    @NotBlank(message = "Không được để trống !")
    private String sdt;
    @NotBlank(message = "Không được để trống !")
    private String diaChi;
    @NotBlank(message = "Không được để trống !")
    private String thanhPho;
    @NotBlank(message = "Không được để trống !")
    private String quocGia;

}
