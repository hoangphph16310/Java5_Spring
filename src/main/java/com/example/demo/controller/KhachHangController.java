package com.example.demo.controller;

import com.example.demo.request.KhachHangRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {

    private ArrayList<KhachHangRequest> list;

    public KhachHangController() {
        this.list = new ArrayList<>();
        list.add(new KhachHangRequest("KH01", "Pham", "Huy", "Hoang", "2002-08-20", "0348321819", "Vĩnh Phúc", "Vĩnh Yên", "Việt Nam"));
        list.add(new KhachHangRequest("KH02", "Nông", "Van", "Dat", "1997-11-24", "0348328888", "Lục Ngạn", "Bắc Giang", "Việt Nam"));
    }

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("data", this.list);
        return ("khach_hang/view");
    }

    @GetMapping("create")
    public String getForm(@ModelAttribute("kh") KhachHangRequest khEntity) {

        return "khach_hang/create";
    }

    @PostMapping("store")
    public String khachHang(@Valid
                            @ModelAttribute("kh") KhachHangRequest khReq,
                            BindingResult result) {
        if (result.hasErrors()) {
            return "khach_hang/create";
        } else {
            this.list.add(khReq);
            return "redirect:/khach-hang/index";
        }
    }

    @GetMapping("edit/{ma}")
    public String getFormEdit(@PathVariable("ma") String maKH, KhachHangRequest khEntity, Model model) {
        for (int i = 0; i < this.list.size(); i++) {
            KhachHangRequest khachHangRequest = this.list.get(i);
            if (khachHangRequest.getMa().equals(maKH)) {
                model.addAttribute("kh", khachHangRequest);
                break;
            }
        }
        return "khach_hang/edit";
    }

    @PostMapping("update/{ma}")
    public String updateKH(@PathVariable("ma") String maKH, @ModelAttribute("kh") KhachHangRequest khReq) {
        for (int i = 0; i < this.list.size(); i++) {
            KhachHangRequest khachHangRequest = this.list.get(i);
            if (khachHangRequest.getMa().equals(maKH)) {
                this.list.set(i,khReq);
                break;
            }
        }
        return "redirect:/khach-hang/index";
    }

    @GetMapping("delete/{ma}")
    public String delete(@PathVariable("ma") String maKH) {
        for (int i = 0; i < this.list.size(); i++) {
            KhachHangRequest khachHangRequest = this.list.get(i);
            if (khachHangRequest.getMa().equals(maKH)) {
                this.list.remove(i);
                break;
            }
        }
        return "redirect:/khach-hang/index";
    }
}
