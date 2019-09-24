package com.entor.tmall.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.entor.tmall.bean.Category;
import com.entor.tmall.bean.User;
import com.entor.tmall.service.UserService;
import com.entor.tmall.util.ImageUtil;
import com.entor.tmall.util.Page;
import com.entor.tmall.util.UploadedImageFile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;
  
    @RequestMapping("admin_user_list")
    public String list(Model model, Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());
 
        List<User> us= userService.list();
 
        int total = (int) new PageInfo<>(us).getTotal();
        page.setTotal(total);
 
        model.addAttribute("us", us);
        model.addAttribute("page", page);
 
        return "admin/listUser";
    }
    
    
    //±à¼­
    @RequestMapping("admin_user_edit")
    public String edit(int id,Model model) throws IOException {
        User c= userService.get(id);
        model.addAttribute("c", c);
        return "admin/editUser";
    }
    @RequestMapping("admin_user_update")
    public String update(User c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
    	userService.update(c);
        return "redirect:/admin_user_list";
    }
    //É¾³ý
    @RequestMapping("admin_user_delete")
    public String delete(int id,HttpSession session) throws IOException {
    	userService.delete(id);
       return "redirect:/admin_user_list";
    }
    
 
}
