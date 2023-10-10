package com.example.demo.controller;

import com.example.demo.entity.CuaHang;
import com.example.demo.repository.CuaHangRepository;
import com.example.demo.request.CuaHangRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("cua-hang")
public class CuaHangController {

    private List<CuaHang> list;

    @Autowired
    private CuaHangRepository chRepo;

    public CuaHangController() {
        this.list = new ArrayList<>();
    }

    @GetMapping("index")
    public String index(Model model) {
        this.list = this.chRepo.findAll();
        model.addAttribute("data", this.list);
        return ("cua_hang/view");
    }

    @GetMapping("create")
    public String getForm(@ModelAttribute("ch") CuaHangRequest chReq) {

        return "cua_hang/create";
    }

    @PostMapping("store")
    public String cuaHang(
            @Valid
            @ModelAttribute("ch") CuaHangRequest chReq,
            BindingResult result) {
        if (result.hasErrors()) {
            return "cua_hang/create";
        } else {
            CuaHang ch = new CuaHang();
            ch.setId(null);
            ch.setMa(chReq.getMa());
            ch.setTen(chReq.getTen());
            ch.setDiaChi(chReq.getDiaChi());
            ch.setThanhPho(chReq.getThanhPho());
            ch.setQuocGia(chReq.getQuocGia());
            this.chRepo.save(ch);
//            this.list.add(chEntity);
            return "redirect:/cua-hang/index";
        }
    }

    @GetMapping("edit/{ma}")
    public String getFormEdit(@PathVariable("ma") String maCH, CuaHangRequest chReq, Model model) {
        CuaHang ch = this.chRepo.findByMa(maCH);
        model.addAttribute("ch",ch);
        return "cua_hang/edit";
    }

    @PostMapping("update/{ma}")
    public String updateCH(
            @PathVariable("ma") String maCH,
            @ModelAttribute("ch") CuaHangRequest chReq) {
        CuaHang oldValue = this.chRepo.findByMa(maCH);
        CuaHang ch = new CuaHang();
        ch.setId(oldValue.getId());
        ch.setMa(chReq.getMa());
        ch.setTen(chReq.getTen());
        ch.setDiaChi(chReq.getDiaChi());
        ch.setThanhPho(chReq.getThanhPho());
        ch.setQuocGia(chReq.getQuocGia());
        this.chRepo.save(ch);
        return "redirect:/cua-hang/index";
    }

    @GetMapping("delete/{ma}")
    public String delete(@PathVariable("ma") String maCH) {
        CuaHang ch = this.chRepo.findByMa(maCH);
        this.chRepo.delete(ch);
        return "redirect:/cua-hang/index";
    }
}
