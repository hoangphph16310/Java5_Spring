package com.example.demo.controller;

import com.example.demo.request.DongSanPhamRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("dongsp")
public class DongSanPhamController {
    private ArrayList<DongSanPhamRequest> list;

    public DongSanPhamController() {
        this.list = new ArrayList<>();
        list.add(new DongSanPhamRequest("DSP01", "Dòng Sản Phẩm A"));
        list.add(new DongSanPhamRequest("DSP02", "Dòng Sản Phẩm B"));
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
            this.list.add(dspReq);
            return "redirect:/dongsp/index";
        }
    }

    @GetMapping("edit/{ma}")
    public String edit(@PathVariable("ma") String maDSP, Model model){
        for (int i = 0; i < this.list.size(); i++) {
            DongSanPhamRequest dongSanPhamRequest = this.list.get(i);
            if(dongSanPhamRequest.getMa().equals(maDSP)){
                model.addAttribute("dsp", dongSanPhamRequest);
                break;
            }
        }
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
            for (int i = 0; i < this.list.size(); i++) {
                DongSanPhamRequest dongSanPhamRequest = this.list.get(i);
                if(dongSanPhamRequest.getMa().equals(maDSP)){
                    this.list.set(i,dspReq);
                    break;
                }
            }
            return "redirect:/dongsp/index";
        }
    }

    @GetMapping("delete/{ma}")
    public String delete(@PathVariable("ma") String maDSP, DongSanPhamRequest dspReq){
        for (int i = 0; i < this.list.size(); i++) {
            DongSanPhamRequest dsp = this.list.get(i);
            if(dsp.getMa().equals(maDSP)){
                this.list.remove(i);
                break;
            }
        }
        return "redirect:/dongsp/index";
    }

}
