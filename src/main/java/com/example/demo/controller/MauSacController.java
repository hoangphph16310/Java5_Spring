package com.example.demo.controller;

import com.example.demo.request.MauSacRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("mau-sac")
public class MauSacController {

    private ArrayList<MauSacRequest> list;

    public MauSacController() {
        this.list = new ArrayList<>();
        list.add(new MauSacRequest("MD01", "Màu Xanh"));
        list.add(new MauSacRequest("MD02", "Màu Vàng"));
    }


    @GetMapping("index")
    public String index(Model model) {
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
        this.list.add(msReq);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("edit/{ma}")
    public String edit(@PathVariable("ma") String maMS,Model model){
        for (int i = 0; i < this.list.size(); i++) {
            MauSacRequest mauSacRequest = this.list.get(i);
            if (mauSacRequest.getMa().equals(maMS)){
                model.addAttribute("ms", mauSacRequest);
                break;
            }
        }
        return ("mau_sac/edit");
    }

    @PostMapping("update/{ma}")
    public String update(@PathVariable("ma") String maMS , MauSacRequest msReq){
        for (int i = 0; i < this.list.size(); i++) {
            MauSacRequest mauSacRequest = this.list.get(i);
            if (mauSacRequest.getMa().equals(maMS)){
               this.list.set(i,msReq);
                break;
            }
        }
        return "redirect:/mau-sac/index";
    }


    @GetMapping("delete/{ma}")
    public String delete(@PathVariable("ma") String maMS){
        for (int i = 0; i < this.list.size(); i++) {
            MauSacRequest ms = this.list.get(i);
            if (ms.getMa().equals(maMS)){
                this.list.remove(i);
                break;
            }
        }
        return "redirect:/mau-sac/index";
    }
}
