package com.example.demo.config;

import com.example.demo.request.NhanVienRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoBeanConfig
{
    @Bean("HoangPH")
    public NhanVienRequest getBeanNV1() {
//        NhanVienRequest nv = new NhanVienRequest("PH16310", "Phạm", "Huy", "Hoàng", 1, "2002-08-20", "Vĩnh Phúc", "0348321819");
        NhanVienRequest nv = new NhanVienRequest();
        return nv;
    }
    @Bean("DuyenTV")
    public NhanVienRequest getBeanNV2() {
//        NhanVienRequest nv = new NhanVienRequest("PH11111", "Trần", "Văn", "Duyên", 1, "2002-08-20", "Vĩnh Phúc", "0348321819");
        NhanVienRequest nv = new NhanVienRequest();
        return nv;
    }
}
