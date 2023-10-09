package com.example.demo.controller;

import com.example.demo.request.SanPhamRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("san-pham")
public class SanPhamController {
    private ArrayList<SanPhamRequest> list;

    public SanPhamController() {
        this.list = new ArrayList<>();
        list.add(new SanPhamRequest("SP01", "Sản Phẩm A"));
        list.add(new SanPhamRequest("SP02", "Sản Phẩm B"));
    }

    @GetMapping("index")
    public String index(Model model) {
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
            this.list.add(spReq);
            return "redirect:/san-pham/index";
        }
    }

    @GetMapping("edit/{ma}")
    public String edit(@PathVariable("ma") String maSP,Model model){
        for (int i = 0; i < this.list.size(); i++) {
            SanPhamRequest sanPhamRequest = this.list.get(i);
            if(sanPhamRequest.getMa().equals(maSP)){
                model.addAttribute("sp", sanPhamRequest);
                break;
            }
        }
        return "san_pham/edit";
    }

    @PostMapping("update/{ma}")
    public String update(
            @Valid
            @PathVariable("ma") String maSP,
            @ModelAttribute("sp")
                    SanPhamRequest spReq,
            BindingResult result){
        if (result.hasErrors()){
            return "san_pham/edit";
        }else {
            for (int i = 0; i < this.list.size(); i++) {
                SanPhamRequest sanPhamRequest = this.list.get(i);
                if(sanPhamRequest.getMa().equals(maSP)){
                    this.list.set(i,spReq);
                    break;
                }
            }
        return "redirect:/san-pham/index";
        }
    }

    @GetMapping("delete/{ma}")
    public String delete(@PathVariable("ma") String maSP, SanPhamRequest spReq){
        for (int i = 0; i < this.list.size(); i++) {
            SanPhamRequest sp = this.list.get(i);
            if(sp.getMa().equals(maSP)){
                this.list.remove(i);
                break;
            }
        }
        return "redirect:/san-pham/index";
    }

}
