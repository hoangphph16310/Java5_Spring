package com.example.demo.controller;

import com.example.demo.request.CuaHangRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("cua-hang")
public class CuaHangController {

    private ArrayList<CuaHangRequest> list;

    public CuaHangController() {
        this.list = new ArrayList<>();
        list.add(new CuaHangRequest("CH01", "Restaurent", "120 Lê Đức Thọ", "Hầ Nội", "Việt Nam"));
        list.add(new CuaHangRequest("CH02", "Luxury", "14 Ba Đình", "Hầ Nội", "Việt Nam"));
    }

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("data", this.list);
        return ("cua_hang/view");
    }

    @GetMapping("create")
    public String getForm(@ModelAttribute("ch") CuaHangRequest chEntity) {

        return "cua_hang/create";
    }

    @PostMapping("store")
    public String cuaHang(
            @Valid
            @ModelAttribute("ch") CuaHangRequest chEntity,
            BindingResult result) {
        if (result.hasErrors()) {
            return "cua_hang/create";
        } else {
            this.list.add(chEntity);
            return "redirect:/cua-hang/index";
        }
    }

    @GetMapping("edit/{ma}")
    public String getFormEdit(@PathVariable("ma") String maCH, CuaHangRequest chReq, Model model) {
        for (int i = 0; i < this.list.size(); i++) {
            CuaHangRequest cuaHangRequest = this.list.get(i);
            if (cuaHangRequest.getMa().equals(maCH)) {
                model.addAttribute("ch", cuaHangRequest);
                break;
            }
        }
        return "cua_hang/edit";
    }

    @PostMapping("update/{ma}")
    public String updateCH(
            @PathVariable("ma") String maCH,
            @ModelAttribute("ch") CuaHangRequest chReq) {
        for (int i = 0; i < this.list.size(); i++) {
            CuaHangRequest cuaHangRequest = this.list.get(i);
            if (cuaHangRequest.getMa().equals(maCH)) {
                this.list.set(i, chReq);
                break;
            }
        }
        return "redirect:/cua-hang/index";
    }

    @GetMapping("delete/{ma}")
    public String delete(@PathVariable("ma") String maCH) {
        for (int i = 0; i < this.list.size(); i++) {
            CuaHangRequest cuaHangRequest = this.list.get(i);
            if (cuaHangRequest.getMa().equals(maCH)) {
                this.list.remove(i);
                break;
            }
        }
        return "redirect:/cua-hang/index";
    }
}
