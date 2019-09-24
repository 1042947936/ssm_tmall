package com.entor.tmall.controller;

import com.entor.tmall.bean.Category;
import com.entor.tmall.service.CategoryService;
import com.entor.tmall.util.ImageUtil;
import com.entor.tmall.util.Page;
import com.entor.tmall.util.UploadedImageFile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
 
@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
  //·ÖÒ³²éÑ¯
    @RequestMapping("admin_category_list")
    public String list(Model model,Page page){
    	 PageHelper.offsetPage(page.getStart(),page.getCount());
         List<Category> cs= categoryService.list();
         int total = (int) new PageInfo<>(cs).getTotal();
         page.setTotal(total);
         model.addAttribute("cs", cs);
         model.addAttribute("page", page);
         return "admin/listCategory";
    }
    
    //Ìí¼Ó
    @RequestMapping("admin_category_add")
    public String add(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        System.out.println(c.getId());
        categoryService.add(c);
        System.out.println(c.getId());
        File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,c.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        System.out.println(uploadedImageFile);
        System.out.println(uploadedImageFile.getImage());
        System.out.println(file);
        uploadedImageFile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
 
        return "redirect:/admin_category_list";
    }
    //É¾³ý
    @RequestMapping("admin_category_delete")
    public String delete(int id,HttpSession session) throws IOException {
        categoryService.delete(id);
 
        File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();
 
        return "redirect:/admin_category_list";
    }
    //±à¼­
    @RequestMapping("admin_category_edit")
    public String edit(int id,Model model) throws IOException {
        Category c= categoryService.get(id);
        model.addAttribute("c", c);
        return "admin/editCategory";
    }
    //ÐÞ¸Ä
    @RequestMapping("admin_category_update")
    public String update(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        categoryService.update(c);
        MultipartFile image = uploadedImageFile.getImage();
        if(null!=image &&!image.isEmpty()){
            File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
            File file = new File(imageFolder,c.getId()+".jpg");
            image.transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);
        }
        return "redirect:/admin_category_list";
    }
    
}