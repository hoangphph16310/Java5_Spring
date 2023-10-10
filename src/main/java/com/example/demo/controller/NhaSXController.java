package com.example.demo.controller;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.NhaSX;
import com.example.demo.repository.NhaSXRepository;
import com.example.demo.request.NhaSXRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("nhasx")
public class NhaSXController {
    private List<NhaSX> list;

    @Autowired
    private NhaSXRepository nsxRepo;

    public NhaSXController() {
        this.list = new ArrayList<>();

    }

    @GetMapping("index")
    public String index(Model model) {
        this.list = this.nsxRepo.findAll();
        model.addAttribute("data", this.list);
        return "nhasx/view";
    }

    @GetMapping("create")
    public String getForm(@ModelAttribute("nsx") NhaSXRequest nsxReq) {

        return "nhasx/create";
    }

    @PostMapping("store")
    public String nhasx(@Valid @ModelAttribute("nsx") NhaSXRequest nsxReq, BindingResult result) {
        if (result.hasErrors()) {
            return "nhasx/create";
        } else {
            NhaSX nsx = new NhaSX();
            nsx.setId(null);
            nsx.setMa(nsxReq.getMa());
            nsx.setTen(nsxReq.getTen());
            this.nsxRepo.save(nsx);
            return "redirect:/nhasx/index";
        }
    }

    @GetMapping("edit/{ma}")
    public String getFormEdit(@PathVariable("ma") String maNSX, Model model) {
        NhaSX nsx = this.nsxRepo.findByMa(maNSX);
        model.addAttribute("nsx",nsx);
        return "nhasx/edit";
    }

    @PostMapping("update/{ma}")
    public String updateNhaSX(@Valid @PathVariable("ma") String maNSX, NhaSXRequest nsxReq, BindingResult result) {
        NhaSX oldValue = this.nsxRepo.findByMa(maNSX);
        NhaSX nsx = new NhaSX();
        nsx.setId(oldValue.getId());
        nsx.setMa(nsxReq.getMa());
        nsx.setTen(nsxReq.getTen());
        this.nsxRepo.save(nsx);
        return "redirect:/nhasx/index";
    }

    @GetMapping("delete/{ma}")
    public String delete(@PathVariable("ma") String maNSX) {
        NhaSX nsx = this.nsxRepo.findByMa(maNSX);
        this.nsxRepo.delete(nsx);
        return "redirect:/nhasx/index";
    }
}
