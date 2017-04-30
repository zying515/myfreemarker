package com.myfreemarker.controller;

import com.myfreemarker.bean.CmPicture;
import com.myfreemarker.dao.CmpictureRepository;
import com.myfreemarker.util.JumpUrlUtil;
import com.myfreemarker.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
/**
 * Created by Administrator on 2017/4/19.
 */
@Controller
@RequestMapping("/picture")
public class PictureController  extends BaseController {
    @Autowired
    private CmpictureRepository cmpictureRepository;
    @RequestMapping("/home")
    public String toIndex(Map<String,Object> map, HttpSession session){
        initRegisterFreemarker();
        String url = getBaseUrl();
        map.put("baseUrl",url);
        if(!checkLogin(session)){
            return JumpUrlUtil.LOGIN_HTML;
        }
        return JumpUrlUtil.PICTURE_HTML;
    }

    @RequestMapping("/list")
    public String toList(Map<String,Object> map, HttpSession session){
        initRegisterFreemarker();
        String url = getBaseUrl();
        map.put("baseUrl",url);
        if(!checkLogin(session)){
            return JumpUrlUtil.LOGIN_HTML;
        }
        List<CmPicture> cmPictureList=cmpictureRepository.findAll();
        map.put("pictureList",cmPictureList);
        return JumpUrlUtil.PICTURE_LIST_HTML;
    }

    // 访问路径为：http://ip:port/upload
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload(Map<String,Object> map, HttpSession session) {
        initRegisterFreemarker();
        String url = getBaseUrl();
        map.put("baseUrl",url);
        if(!checkLogin(session)){
            return JumpUrlUtil.LOGIN_HTML;
        }
        return "/fileupload";
    }

    // 访问路径为：http://ip:port/upload/batch
    @RequestMapping(value = "/upload/batch", method = RequestMethod.GET)
    public String batchUpload() {
        return "/mutifileupload";
    }

    /**
     * 文件上传具体实现方法（单文件上传）
     *
     * @param file
     * @return
     *
     * @author 单红宇(CSDN CATOOP)
     * @create 2017年3月11日
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
      String fileName=getPictureUrl()+ "img_"+RandomUtil.getRandomFileName()+file.getOriginalFilename();
       System.out.println("path=="+fileName);
        if (!file.isEmpty()) {
            try {
                // 这里只是简单例子，文件直接输出到项目路径下。
                // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
                // 还有关于文件格式限制、文件大小限制，详见：中配置。
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(fileName)));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            return "上传成功";
        } else {
            return "上传失败，因为文件是空的.";
        }
    }

    /**
     * 多文件上传 主要是使用了MultipartHttpServletRequest和MultipartFile
     *
     * @param request
     * @return
     *
     * @author 单红宇(CSDN CATOOP)
     * @create 2017年3月11日
     */
    @RequestMapping(value = "/upload/batch", method = RequestMethod.POST)
    public @ResponseBody String batchUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        CmPicture bean=null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            bean=new CmPicture();
            String OriginalFilename=file.getOriginalFilename();
            String fixed=OriginalFilename.substring(OriginalFilename.lastIndexOf("."),OriginalFilename.length());
            OriginalFilename = OriginalFilename.substring(0,OriginalFilename.lastIndexOf("."));
            String fileName="img_"+RandomUtil.getRandomFileName()+OriginalFilename;
            String fileUrl=getPictureUrl()+ fileName+fixed;
            bean.setPictureurl(fileUrl);
            bean.setPicturename(fileName);
            bean.setPictureDate(new Date());
            bean.setPicturefix(fixed);
            System.out.println("path=="+fileName);

            if (!file.isEmpty()) {
                try {
                    cmpictureRepository.save(bean);
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File(fileUrl)));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    return "You failed to upload " + i + " => " + e.getMessage();
                }
            } else {
                return "You failed to upload " + i + " because the file was empty.";
            }
        }
        return "upload successful";
    }
  public static void main(String[] args){
      String OriginalFilename="12.jpg";
      String fixed=OriginalFilename.substring(OriginalFilename.lastIndexOf("."),OriginalFilename.length());
      OriginalFilename = OriginalFilename.substring(0,OriginalFilename.lastIndexOf("."));
      System.out.println("fixed="+OriginalFilename);
  }
}