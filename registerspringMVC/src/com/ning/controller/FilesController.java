package com.ning.controller;

import com.ning.pojo.Register;
import com.ning.service.FilesService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class FilesController {
    @Resource
    private FilesService filesServiceImpl;
    @RequestMapping("show")
    public String show(Model model){
        model.addAttribute("list",filesServiceImpl.show());
        return "forward:/main.jsp";
    }
    @RequestMapping("download")
    public void download(int id, String name, HttpServletResponse response, HttpServletRequest request){
        filesServiceImpl.updCount(id,(Register) request.getSession().getAttribute("register"),name);
        response.setHeader("Content-Disposition","attachment;filename="+name);
        ServletOutputStream os = null;
        File file = null;
        try {
            os = response.getOutputStream();
            file = new File(request.getServletContext().getRealPath("files"),name);
            os.write(FileUtils.readFileToByteArray(file));
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
                try {
                    if (os != null) {
                        os.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
