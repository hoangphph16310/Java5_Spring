package com.example.demo.controller;

import com.example.demo.request.ChucVuRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("chuc-vu")// ánh xạ đường dẫn vào controller
public class ChucVuController {


    private ArrayList<ChucVuRequest> list;

    public ChucVuController() {
        this.list = new ArrayList<>();
        list.add(new ChucVuRequest("NV01", "Pham Huy Hoang"));
        list.add(new ChucVuRequest("NV02", "Tran Van Duyen"));
        list.add(new ChucVuRequest("NV03", "Vu Van Nguyen"));
        list.add(new ChucVuRequest("NV04", "Trần Thị Vân Anh"));
    }

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("data", this.list);
        return ("chuc_vu/view");
    }

    @GetMapping("create")
    public String getFormChucVu(@ModelAttribute("cv") ChucVuRequest chucVuRequestReq) {

        return "chuc_vu/create";
    }

    @PostMapping("store")
    public String chucVu(
            @Valid @ModelAttribute("cv") ChucVuRequest cvReq,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Thêm thất bại !");
            return "chuc_vu/create";
        } else {
            this.list.add(cvReq);
            redirectAttributes.addFlashAttribute("successMessage", "Thêm thành công !");
        }
            return "redirect:/chuc-vu/index";
    }

    @GetMapping("edit/{ma}")
    public String getFormEditChucVu(@PathVariable("ma") String maCV, Model model) {
        for (int i = 0; i < this.list.size(); i++) {
            ChucVuRequest chucVuRequest = this.list.get(i);
            if (chucVuRequest.getMa().equals(maCV)) {
                model.addAttribute("cv", chucVuRequest);
                break;
            }
        }
        return "chuc_vu/edit";
    }

    @PostMapping("update/{ma}")
    public String updateChucVu(
            @Valid
            @PathVariable("ma") String maCV,
            @ModelAttribute("cv") ChucVuRequest cvReq,
            BindingResult result) {
        if (result.hasErrors()){
            return "chuc_vu/edit";
        }else {
            for (int i = 0; i < this.list.size(); i++) {
                ChucVuRequest chucVuRequest = this.list.get(i);
                if (chucVuRequest.getMa().equals(maCV)) {
                    this.list.set(i, cvReq);
                    break;
                }
            }
        }
        return "redirect:/chuc-vu/index";
    }

    @GetMapping("delete/{ma}")
    public String delete(@PathVariable("ma") String maCV) {
        for (int i = 0; i < this.list.size(); i++) {
            ChucVuRequest chucVuRequest = this.list.get(i);
            if (chucVuRequest.getMa().equals(maCV)) {
                this.list.remove(i);
                break;
            }
        }
        return "redirect:/chuc-vu/index";
    }
}
