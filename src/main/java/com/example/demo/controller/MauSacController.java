package com.example.demo.controller;

import com.example.demo.entity.MauSac;
import com.example.demo.repository.MauSacRepository;
import com.example.demo.request.MauSacRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("mau-sac")
public class MauSacController {

    private List<MauSac> list;

    @Autowired
    private MauSacRepository msRepo;

    public MauSacController() {
        this.list = new ArrayList<>();
    }


    @GetMapping("index")
    public String index(Model model) {
        this.list = this.msRepo.findAll();
        model.addAttribute("data", this.list);
        return "mau_sac/view";
    }

    @GetMapping("create")
    public String create(@ModelAttribute("ms") MauSacRequest msReq) {
        return "mau_sac/create";
    }

    @PostMapping("store")
    public String store(
            @Valid
            @ModelAttribute("ms") MauSacRequest msReq,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "mau_sac/create";
        }
        MauSac ms = new MauSac();
        ms.setId(null);
        ms.setMa(msReq.getMa());
        ms.setTen(msReq.getTen());
        this.msRepo.save(ms);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("edit/{ma}")
    public String edit(@PathVariable("ma") String maMS, Model model) {
        MauSac ms = this.msRepo.findByMa(maMS);
        model.addAttribute("ms",ms);
        return ("mau_sac/edit");
    }

    @PostMapping("update/{ma}")
    public String update(@PathVariable("ma") String maMS, MauSacRequest msReq) {
        MauSac oldValue = this.msRepo.findByMa(maMS);
        MauSac ms = new MauSac();
        ms.setId(oldValue.getId());
        ms.setMa(msReq.getMa());
        ms.setTen(msReq.getTen());
        this.msRepo.save(ms);
        return "redirect:/mau-sac/index";
    }


    @GetMapping("delete/{ma}")
    public String delete(@PathVariable("ma") String maMS) {
        MauSac ms = this.msRepo.findByMa(maMS);
        this.msRepo.delete(ms);
        return "redirect:/mau-sac/index";
    }
}
