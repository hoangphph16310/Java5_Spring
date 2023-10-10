package com.example.demo.controller;


import com.example.demo.entity.ChucVu;
import com.example.demo.repository.ChucVuRepository;
import com.example.demo.request.ChucVuRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("chuc-vu")// ánh xạ đường dẫn vào controller
public class ChucVuController {


    private List<ChucVu> list;

    @Autowired
    private ChucVuRepository cvRepo;

    public ChucVuController() {
        this.list = new ArrayList<>();
    }

    @GetMapping("index")
    public String index(Model model) {
        this.list = this.cvRepo.findAll();
        model.addAttribute("data", this.list);
        return ("chuc_vu/view");
    }

    @GetMapping("create")
    public String create(@ModelAttribute("cv") ChucVuRequest cvReq) {

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
            ChucVu cv = new ChucVu();
            cv.setId(null);
            cv.setMa(cvReq.getMa());
            cv.setTen(cvReq.getTen());

            this.cvRepo.save(cv);
//            this.list.add(cvReq);
            redirectAttributes.addFlashAttribute("successMessage", "Thêm thành công !");
        }
        return "redirect:/chuc-vu/index";
    }

    @GetMapping("edit/{ma}")
    public String getFormEditChucVu(@PathVariable("ma") String maCV, Model model) {
       ChucVu cv = this.cvRepo.findByMa(maCV);
       model.addAttribute("cv",cv);
        return "chuc_vu/edit";
    }

    @PostMapping("update/{ma}")
    public String updateChucVu(
            @Valid
            @PathVariable("ma") String maCV,
            @ModelAttribute("cv") ChucVuRequest cvReq,
            BindingResult result) {
        if (result.hasErrors()) {
            return "chuc_vu/edit";
        } else {
            ChucVu oldValue = this.cvRepo.findByMa(maCV);
            ChucVu cv = new ChucVu();
            cv.setId(oldValue.getId());
            cv.setMa(cvReq.getMa());
            cv.setTen(cvReq.getTen());
            this.cvRepo.save(cv);
        }
        return "redirect:/chuc-vu/index";
    }

    @GetMapping("delete/{ma}")
    public String delete(@PathVariable("ma") String maCV) {
        ChucVu cv = this.cvRepo.findByMa(maCV);
        this.cvRepo.delete(cv);
        return "redirect:/chuc-vu/index";
    }
}
