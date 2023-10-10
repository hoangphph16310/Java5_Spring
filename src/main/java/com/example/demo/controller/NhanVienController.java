package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.request.NhanVienRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {

    private List<NhanVien> list;

    @Autowired
    private NhanVienRepository nvRepo;

    public NhanVienController() {
        this.list = new ArrayList<>();
//        list.add(new NhanVien("PH01", "Pham", "Huy", "Hoang", 1, "2002-08-20", "Vĩnh Phúc", "0348321819"));
//        list.add(new NhanVien("PH02", "Nguyễn", "Đăng", "Khoa", 1, "2002-03-11", "Vĩnh Phúc", "0366704958"));
//        list.add(new NhanVien("PH03", "Nguyễn", "Bình", "Nguyên", 1, "2002-03-11", "Vĩnh Phúc", "0961087004"));
//        list.add(new NhanVien("PH04", "Phùng", "Văn", "Đông", 1, "2002-08-20", "Vĩnh Phúc", "0385805663"));
//        list.add(new NhanVien("PH05", "Nguyễn", "Thành", "Trung", 0, "2002-08-20", "Vĩnh Phúc", "0398827225"));
    }

    @GetMapping("index")
    public String index(Model model) {
        this.list = this.nvRepo.findAll();
        model.addAttribute("data", this.list);
        return "nhan_vien/view";
    }

    @GetMapping("create")
    public String create(@ModelAttribute("nv") NhanVienRequest nvReq) {

        return "nhan_vien/create";
    }


    @PostMapping("store")
    public String store(
            @Valid
            @ModelAttribute("nv") NhanVienRequest nvReq,
            BindingResult result) {
        if (result.hasErrors()) {
            return "nhan_vien/create";
        } else {
            NhanVien nv = new NhanVien();
            nv.setId(null);
            nv.setMa(nvReq.getMa());
            nv.setHo(nvReq.getHo());
            nv.setTenDem(nvReq.getTenDem());
            nv.setTen(nvReq.getTen());
            nv.setGioiTinh(nvReq.getMa());
            nv.setNgaySinh(nvReq.getNgaySinh());
            nv.setSdt(nvReq.getSdt());
            nv.setMatKhau(nvReq.getMa());
            nv.setDiaChi(nvReq.getDiaChi());
            nv.setTrangThai(nvReq.getTrangThai());

            this.nvRepo.save(nv);
//            this.list.add(nvReq);
            return "redirect:/nhan-vien/index";
        }
    }

    @GetMapping("edit/{ma}")
    public String getFormEdit(@PathVariable("ma") String maNV, Model model) {
        NhanVien nv = this.nvRepo.findByMa(maNV);
        model.addAttribute("nv", nv);


//        for (int i = 0; i < this.list.size(); i++) {
//            NhanVienRequest nhanVienRequest = this.list.get(i);
//            if (nhanVienRequest.getMa().equals(maNV)) {
//                model.addAttribute("nv", nhanVienRequest);
//                break;
//            }
//        }
        return "nhan_vien/edit";
    }


    @PostMapping("update/{ma}")
    public String updateNV(@PathVariable("ma") String maNV, NhanVienRequest nvReq) {

        NhanVien oldValue = this.nvRepo.findByMa(maNV);
        NhanVien nv = new NhanVien();
        nv.setId(oldValue.getId());
        nv.setMa(nvReq.getMa());
        nv.setHo(nvReq.getHo());
        nv.setTenDem(nvReq.getTenDem());
        nv.setTen(nvReq.getTen());
        nv.setGioiTinh(nvReq.getGioiTinh());
        nv.setNgaySinh(nvReq.getNgaySinh());
        nv.setDiaChi(nvReq.getDiaChi());
        nv.setMatKhau(nvReq.getMatKhau());
        nv.setSdt(nvReq.getSdt());
        this.nvRepo.save(nv);
//        for (int i = 0; i < this.list.size(); i++) {
//            NhanVienRequest nhanVienRequest = this.list.get(i);
//            if (nhanVienRequest.getMa().equals(maNV)) {
//                this.list.set(i, nvEntity);
//                break;
//            }
//        }
        return "redirect:/nhan-vien/index";
    }

//    Lưu ý {ma} là 1 biến nằm trên đường dẫn (biến k cố định)
    @GetMapping("delete/{ma}")
//    PathVariable lấy ra tham số trên đường dẫn
    public String delete(@PathVariable("ma") String maNV) {
        NhanVien nv = this.nvRepo.findByMa(maNV);
        this.nvRepo.delete(nv);


//        for (int i = 0; i < this.list.size(); i++) {
//            NhanVienRequest nv = this.list.get(i);
//            if (nv.getMa().equals(maNV)) {
//                this.list.remove(i);
//                break;
//            }
//        }
        return "redirect:/nhan-vien/index";
    }
}
