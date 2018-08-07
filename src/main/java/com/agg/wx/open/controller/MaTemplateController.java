package com.agg.wx.open.controller;

import cn.binarywang.wx.miniapp.bean.code.WxMaCodeCommitRequest;
import cn.binarywang.wx.miniapp.bean.code.WxMaCodeExtConfig;
import cn.binarywang.wx.miniapp.bean.template.WxMaTemplateListResult;
import com.agg.wx.open.service.WxOpenService;
import com.google.gson.JsonObject;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.open.bean.WxOpenMaCodeTemplate;
import me.chanjar.weixin.open.bean.result.WxOpenAuthorizerInfoResult;
import me.chanjar.weixin.open.bean.result.WxOpenQueryAuthResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/007gzs">007</a>
 */
@Controller
@RequestMapping("/template")
public class MaTemplateController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private WxOpenService wxOpenService;

    @GetMapping("/getTemplateList")
    @ResponseBody
    public WxMaTemplateListResult getTemplateList(@RequestParam String appId, @RequestParam Integer offSet, @RequestParam Integer count){
        //获取帐号下已存在的模板列表
        try {
            return wxOpenService.getWxOpenComponentService().getWxMaServiceByAppid( appId ).getTemplateService().findTemplateList(offSet,count);
        } catch (WxErrorException e) {
            logger.error("getTemplateList", e);
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/addToTemplate")
    @ResponseBody
    public String addToTemplate(@RequestParam String appId,@RequestParam String templateId){
        //组合小程序模版
        List<Integer>  keyWordIdList = new ArrayList<>(  );
        try {
            wxOpenService.getWxOpenComponentService().getWxMaServiceByAppid( appId ).getTemplateService().addTemplate( templateId, keyWordIdList);
            return "SUCCESS";
        } catch (WxErrorException e) {
            logger.error("addToTemplate", e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/deleteTemplate")
    @ResponseBody
    public String deleteTemplate(@RequestParam String appId,@RequestParam String templateId){
        //删除指定小程序模版
        try {
            wxOpenService.getWxOpenComponentService().getWxMaServiceByAppid( appId ).getTemplateService().delTemplate(templateId);
            return "SUCCESS";
        } catch (WxErrorException e) {
            logger.error("deleteTemplate", e);
            throw new RuntimeException(e);
        }
    }



}
