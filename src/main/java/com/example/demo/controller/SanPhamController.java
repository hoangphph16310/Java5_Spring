package com.example.demo.controller;

import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepository;
import com.example.demo.request.SanPhamRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("san-pham")
public class SanPhamController {
    private List<SanPham> list;

    @Autowired
    private SanPhamRepository spRepo;

    public SanPhamController() {
        this.list = new ArrayList<>();
    }

    @GetMapping("index")
    public String index(Model model) {
        this.list = this.spRepo.findAll();
        model.addAttribute("data", this.list);
        return "san_pham/view";
    }

    @GetMapping("create")
    public String create(@ModelAttribute("sp") SanPhamRequest spReq) {
        return "san_pham/create";
    }

    @PostMapping("store")
    public String store(
            @Valid
            @ModelAttribute("sp") SanPhamRequest spReq,
            BindingResult result) {
        if (result.hasErrors()) {
            return "san_pham/create";
        } else {
            SanPham sp = new SanPham();
            sp.setId(null);
            sp.setMa(spReq.getMa());
            sp.setTen(spReq.getTen());
            return "redirect:/san-pham/index";
        }
    }

    @GetMapping("edit/{ma}")
    public String edit(@PathVariable("ma") String maSP, Model model) {
        SanPham sp = this.spRepo.findByMa(maSP);
        model.addAttribute("sp", sp);
        return "san_pham/edit";
    }

    @PostMapping("update/{ma}")
    public String update(
            @Valid
            @PathVariable("ma") String maSP,
            @ModelAttribute("sp")
                    SanPhamRequest spReq,
            BindingResult result) {
        if (result.hasErrors()) {
            return "san_pham/edit";
        } else {
            SanPham oldValue = this.spRepo.findByMa(maSP);
            SanPham sp = new SanPham();
            sp.setId(oldValue.getId());
            sp.setMa(spReq.getMa());
            sp.setTen(spReq.getTen());
            this.spRepo.save(sp);
            return "redirect:/san-pham/index";
        }
    }

    @GetMapping("delete/{ma}")
    public String delete(@PathVariable("ma") String maSP, SanPhamRequest spReq) {
        SanPham sp = this.spRepo.findByMa(maSP);
        this.spRepo.delete(sp);
        return "redirect:/san-pham/index";
    }

}
