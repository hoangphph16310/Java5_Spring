package com.example.demo.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class NhanVienRequest {
    @NotBlank(message = "Không được để trống !")
    private String ma;
    @NotBlank(message = "Không được để trống !")
    private String ho;
    private String tenDem;
    @NotBlank(message = "Không được để trống !")
    private String ten;
    @Min(value = 0, message = "Giới tính không hợp lệ")
    @Max(value = 1, message = "Giới tính không hợp lệ")
    private Integer gioiTinh;
    @NotBlank(message = "Vui lòng chọn ngày sinh !")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String ngaySinh;
    @NotBlank(message = "Không được để trống !")
    private String matKhau;
    @NotBlank(message = "Không được để trống !")
    private String diaChi;
    @NotBlank(message = "Không được để trống !")
    private String sdt;

}
