package com.maple.resourceserver.controller;

import com.maple.resourceserver.entity.ResourceSetting;
import com.maple.resourceserver.service.IResourceSettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private final static Logger LOGGER= LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private IResourceSettingService resourceSettingService;


    /**
     * 服务进入判断
     * @return
     */
    @RequestMapping("/")
    public String index(){
        if(resourceSettingService.getUploadState()){
            LOGGER.info("资源路径验证通过");
            return "index";
        }
        LOGGER.info("资源路径验证异常，重新配置");
        return "redirect:/resourceSetting";

    }

    @GetMapping("/resourceSetting")
    public String getResourceSetting(Model model){
        ResourceSetting resourceSetting = resourceSettingService.getResourceSetting();
        model.addAttribute("resourceSetting",resourceSetting);
        return "index";
    }

    @PostMapping("/resourceSetting")
    public String setResourceSetting(@ModelAttribute ResourceSetting resourceSetting){
        LOGGER.info("收到的前端resourceSetting：{}",resourceSetting.toString());
        if(null==resourceSetting.getIsDecrypt()){
            resourceSetting.setIsDecrypt(0);
        }
        LOGGER.info("处理后的入参resourceSetting：{}",resourceSetting.toString());
        resourceSettingService.updateById(resourceSetting);
        return "redirect:/";
    }


}
