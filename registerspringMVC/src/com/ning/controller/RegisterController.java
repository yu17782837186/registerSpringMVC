package com.ning.controller;

import com.ning.pojo.Register;
import com.ning.service.RegisterService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class RegisterController {
    @Resource
    private RegisterService registerServiceImpl;
    @RequestMapping("register")
    public String register(Register register, MultipartFile file, HttpServletRequest request){
        String fileName = UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String path = request.getServletContext().getRealPath("images")+"/"+fileName;
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //只能渠道webapps文件夹内容
        register.setPhoto(fileName);
        int index = registerServiceImpl.insRegister(register);
        if (index > 0) {
            request.getSession().setAttribute("register",register);
            //重定向 防止表单重复提交
            return "redirect:/show";
        }else {
            return "redirect:/index,jsp";
        }
    }
}
