package com.sjh.controller;


import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileUploadController {

    @PostMapping("/upload")
    public String upload(MultipartFile img,HttpServletRequest request){
        if(img.getSize() > 0){
            String path = request.getServletContext().getRealPath("file");
            String fileName = img.getOriginalFilename();
            File file = new File(path,fileName);
            try {
                img.transferTo(file);
                //将文件路径存储到request域
                request.setAttribute("path","/file/"+fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "upload";
    }

    @PostMapping("/uploads")
    public String uploads(MultipartFile[] imgs,HttpServletRequest request){
        List<String> files = new ArrayList<>();
        for(MultipartFile img : imgs){
            if(img.getSize() > 0){
                String path = request.getServletContext().getRealPath("file");
                String fileName = img.getOriginalFilename();
                File file = new File(path,fileName);
                try {
                    img.transferTo(file);
                    //将文件路径存储到request域
                    files.add("/file/"+fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        request.setAttribute("files",files);
        return "upload";
    }

    @GetMapping("/download/{name}")
    public void download(@PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response){
        System.out.println(name);
        if(name != null){
            name += ".png";
            System.out.println(name);
            String path = request.getServletContext().getRealPath("file");
            File file = new File(path, name);
            OutputStream os = null;
            if(file.exists()){
                response.setContentType("application/forc-download");
                response.setHeader("Content-Disposition","attachment;filename="+name);
                try {
                    os = response.getOutputStream();
                    os.write(FileUtils.readFileToByteArray(file));
                    os.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(os != null) {
                        try {
                            os.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
