package com.example.demo;

import com.example.demo.pojo.DetectPojo;
import com.example.demo.pojo.VerifyPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    FindFaceHandler findFaceHandler;

    @RequestMapping(value = "/anytec/detect",consumes = "multipart/form-data")
    @ResponseBody
    public String imgDetect(@RequestParam(value = "photo",required = true)MultipartFile photo){
        try{
            DetectPojo detectPojo = findFaceHandler.imageDetect(photo.getBytes());
            double x = detectPojo.getOrientation();
            double x2 = detectPojo.getFaces().get(0).getAge();
            logger.info(x+x2+"");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/anytec/verify",consumes = "multipart/form-data")
    @ResponseBody
    public String imgVerify(@RequestParam("photo1")MultipartFile photo1,@RequestParam("photo2")MultipartFile photo2){
        try{
            VerifyPojo verifyPojo = findFaceHandler.imagesVerify(photo1.getBytes(),photo2.getBytes());
            logger.info(verifyPojo.getResults().get(0).getBbox1().getEmotions()+"");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
