package com.example.demo.controller;

import com.example.demo.request.NhaSXRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("nhasx")
public class NhaSXController {
    private ArrayList<NhaSXRequest> list;


    public NhaSXController() {
        this.list = new ArrayList<>();
        list.add(new NhaSXRequest("SX01", "BanDai"));
        list.add(new NhaSXRequest("SX02", "SiWon"));
    }

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("data", this.list);
        return "nhasx/view";
    }

    @GetMapping("create")
    public String getForm(@ModelAttribute("nsx") NhaSXRequest nsxEntity) {

        return "nhasx/create";
    }

    @PostMapping("store")
    public String nhasx(@Valid @ModelAttribute("nsx") NhaSXRequest nsxEntity, BindingResult result) {
        if (result.hasErrors()) {
            return "nhasx/create";
        } else {
            this.list.add(nsxEntity);
            return "redirect:/nhasx/index";
        }
    }

    @GetMapping("edit/{ma}")
    public String getFormEdit(@PathVariable("ma") String maNSX, NhaSXRequest nsxReq, Model model) {
        for (int i = 0; i < this.list.size(); i++) {
            NhaSXRequest nhaSXRequest = this.list.get(i);
            if (nhaSXRequest.getMa().equals(maNSX)) {
                model.addAttribute("nsx", nhaSXRequest);
                break;
            }
        }
        return "nhasx/edit";
    }

    @PostMapping("update/{ma}")
    public String updateNhaSX(@Valid @PathVariable("ma") String msNSX, NhaSXRequest nsxReq, BindingResult result) {
        for (int i = 0; i < this.list.size(); i++) {
            NhaSXRequest sx = this.list.get(i);
            if (sx.getMa().equals(msNSX)) {
                this.list.set(i, nsxReq);
                break;
            }
        }
        return "redirect:/nhasx/index";
    }

    @GetMapping("delete/{ma}")
    public String delete(@PathVariable("ma") String maNSX) {
        System.out.println("NhasxcControllerDelete");
        for (int i = 0; i < this.list.size(); i++) {
            NhaSXRequest sx = this.list.get(i);
            if (sx.getMa().equals(maNSX)) {
                this.list.remove(i);
                break;
            }
        }
        return "redirect:/nhasx/index";
    }
}
