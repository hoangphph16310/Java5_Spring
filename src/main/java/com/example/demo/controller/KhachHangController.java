package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.request.KhachHangRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {

    private List<KhachHang> list;

    @Autowired
    private KhachHangRepository khRepo;

    public KhachHangController() {
        this.list = new ArrayList<>();
    }

    @GetMapping("index")
    public String index(Model model) {
        this.list = this.khRepo.findAll();
        model.addAttribute("data", this.list);
        return ("khach_hang/view");
    }

    @GetMapping("create")
    public String getForm(@ModelAttribute("kh") KhachHangRequest khReq) {

        return "khach_hang/create";
    }

    @PostMapping("store")
    public String khachHang(
            @Valid
            @ModelAttribute("kh") KhachHangRequest khReq,
            BindingResult result) {
        if (result.hasErrors()) {
            return "khach_hang/create";
        } else {
            KhachHang kh = new KhachHang();
            kh.setId(null);
            kh.setMa(khReq.getMa());
            kh.setHo(khReq.getHo());
            kh.setTenDem(khReq.getTenDem());
            kh.setTen(khReq.getTen());
            kh.setNgaySinh(khReq.getNgaySinh());
            kh.setSdt(khReq.getSdt());
            kh.setDiaChi(khReq.getDiaChi());
            kh.setThanhPho(khReq.getThanhPho());
            kh.setQuocGia(khReq.getQuocGia());

            this.khRepo.save(kh);
            return "redirect:/khach-hang/index";
        }
    }

    @GetMapping("edit/{ma}")
    public String getFormEdit(@PathVariable("ma") String maKH, KhachHangRequest khEntity, Model model) {
       KhachHang kh = this.khRepo.findByMa(maKH);
       model.addAttribute("kh",kh);
        return "khach_hang/edit";
    }

    @PostMapping("update/{ma}")
    public String updateKH(@PathVariable("ma") String maKH, @ModelAttribute("kh") KhachHangRequest khReq) {
        KhachHang oldValue = this.khRepo.findByMa(maKH);
        KhachHang kh = new KhachHang();
        kh.setId(oldValue.getId());
        kh.setMa(khReq.getMa());
        kh.setHo(khReq.getHo());
        kh.setTenDem(khReq.getTenDem());
        kh.setTen(khReq.getTen());
        kh.setNgaySinh(khReq.getNgaySinh());
        kh.setSdt(khReq.getSdt());
        kh.setDiaChi(khReq.getDiaChi());
        kh.setThanhPho(khReq.getThanhPho());
        kh.setQuocGia(khReq.getQuocGia());

        this.khRepo.save(kh);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("delete/{ma}")
    public String delete(@PathVariable("ma") String maKH) {
        KhachHang kh = this.khRepo.findByMa(maKH);
        this.khRepo.delete(kh);
        return "redirect:/khach-hang/index";
    }
}
