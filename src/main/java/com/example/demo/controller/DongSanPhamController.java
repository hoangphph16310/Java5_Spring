package com.example.demo.controller;

import com.example.demo.entity.DongSP;
import com.example.demo.repository.DongSPRepository;
import com.example.demo.request.DongSanPhamRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("dongsp")
public class DongSanPhamController {
    private List<DongSP> list;

    @Autowired
    private DongSPRepository dspRepo;

    public DongSanPhamController() {
        this.list = new ArrayList<>();
    }

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("data", this.list);
        return "dong_sp/view";
    }

    @GetMapping("create")
    public String create(@ModelAttribute("dsp") DongSanPhamRequest dspReq) {

        return "dong_sp/create";
    }

    @PostMapping("store")
    public String store(
            @Valid
            @ModelAttribute("dsp") DongSanPhamRequest dspReq,
            BindingResult result) {
        if (result.hasErrors()) {
            return "dong_sp/create";
        } else {
            DongSP dsp = new DongSP();
            dsp.setId(null);
            dsp.setMa(dspReq.getMa());
            dsp.setTen(dspReq.getTen());
            this.dspRepo.save(dsp);
            return "redirect:/dongsp/index";
        }
    }

    @GetMapping("edit/{ma}")
    public String edit(@PathVariable("ma") String maDSP, Model model){
        DongSP dsp = this.dspRepo.findByMa(maDSP);
        model.addAttribute("dsp", dsp);
        return "dong_sp/edit";
    }

    @PostMapping("update/{ma}")
    public String update(
            @Valid
            @PathVariable("ma") String maDSP,
            @ModelAttribute("dsp") DongSanPhamRequest dspReq,
            BindingResult result){
        if (result.hasErrors()){
            return "dong_sp/edit";
        }else {
            DongSP oldValue = this.dspRepo.findByMa(maDSP);
            DongSP dsp = new DongSP();
            dsp.setId(oldValue.getId());
            dsp.setMa(dspReq.getMa());
            dsp.setTen(dspReq.getTen());
            this.dspRepo.save(dsp);
            return "redirect:/dongsp/index";
        }
    }

    @GetMapping("delete/{ma}")
    public String delete(@PathVariable("ma") String maDSP, DongSanPhamRequest dspReq){
        DongSP dsp = this.dspRepo.findByMa(maDSP);
        this.dspRepo.delete(dsp);
        return "redirect:/dongsp/index";
    }

}
