package com.agg.wx.open.controller;

import cn.binarywang.wx.miniapp.api.WxMaCodeService;
import cn.binarywang.wx.miniapp.bean.WxMaDomainAction;
import cn.binarywang.wx.miniapp.bean.code.*;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import com.agg.wx.open.config.WxaDomainProperties;
import com.agg.wx.open.service.WxOpenService;
import com.google.gson.JsonObject;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.open.bean.WxOpenMaCodeTemplate;
import me.chanjar.weixin.open.bean.result.WxOpenAuthorizerInfoResult;
import me.chanjar.weixin.open.bean.result.WxOpenQueryAuthResult;
import org.apache.commons.lang3.StringUtils;
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
import java.io.*;
import java.util.*;

/**
 * @author <a href="https://github.com/007gzs">007</a>
 */
@Controller
@RequestMapping("/api")
public class WechatApiController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private WxOpenService wxOpenService;
    @Autowired
    private WxaDomainProperties wxaDomainProperties;


    @GetMapping("/auth/goto_auth_url_show")
    @ResponseBody
    public String gotoPreAuthUrlShow(){

        return "<a href='goto_auth_url'>go</a>";
    }

    @GetMapping("/auth/goto_auth_url")
    public void gotoPreAuthUrl(HttpServletRequest request, HttpServletResponse response){
        String host = request.getHeader("host");
        String url = "http://"+host+"/api/auth/jump";
        try {
            url = wxOpenService.getWxOpenComponentService().getPreAuthUrl(url);
            response.sendRedirect(url);
        } catch (WxErrorException | IOException e) {
            logger.error("gotoPreAuthUrl", e);
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/auth/jump")
    @ResponseBody
    public WxOpenQueryAuthResult jump(@RequestParam("auth_code") String authorizationCode){
        try {
            WxOpenQueryAuthResult queryAuthResult = wxOpenService.getWxOpenComponentService().getQueryAuth(authorizationCode);
            logger.info("getQueryAuth", queryAuthResult);
            String appid = queryAuthResult.getAuthorizationInfo().getAuthorizerAppid();
            if(StringUtils.isNotBlank( appid )){
                modifyDomain( appid,"set" );
            }
            return queryAuthResult;
        } catch (WxErrorException e) {
            logger.error("gotoPreAuthUrl", e);
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/get_authorizer_info")
    @ResponseBody
    public WxOpenAuthorizerInfoResult getAuthorizerInfo(@RequestParam String appId){
        //获取授权方的帐号基本信息
        try {
            return wxOpenService.getWxOpenComponentService().getAuthorizerInfo(appId);
        } catch (WxErrorException e) {
            logger.error("getAuthorizerInfo", e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getTemplateList")
    @ResponseBody
    public List<WxOpenMaCodeTemplate> getTemplateList(){
        //获取代码模版库中的所有小程序代码模版
        try {
            return wxOpenService.getWxOpenComponentService().getTemplateList();
        } catch (WxErrorException e) {
            logger.error("getTemplateList", e);
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/getTemplateDraftList")
    @ResponseBody
    public List<WxOpenMaCodeTemplate> getTemplateDraftList(){
        //获取草稿箱内的所有临时代码草稿
        try {
            return wxOpenService.getWxOpenComponentService().getTemplateDraftList();
        } catch (WxErrorException e) {
            logger.error("getTemplateDraftList", e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/addToTemplate")
    @ResponseBody
    public String addToTemplate(@RequestParam Long draftId){
        //将草稿箱的草稿选为小程序代码模版
        try {
            wxOpenService.getWxOpenComponentService().addToTemplate(draftId);
            return "SUCCESS";
        } catch (WxErrorException e) {
            logger.error("addToTemplate", e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/deleteTemplate")
    @ResponseBody
    public String deleteTemplate(@RequestParam Long templateId){
        //删除指定小程序代码模版
        try {
            wxOpenService.getWxOpenComponentService().deleteTemplate(templateId);
            return "SUCCESS";
        } catch (WxErrorException e) {
            logger.error("deleteTemplate", e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/modifyDomain")
    @ResponseBody
    public WxMaDomainAction modifyDomain(@RequestParam String appId,@RequestParam String action){
        //设置小程序服务器域名
        try {
            WxMaDomainAction domainAction = WxMaDomainAction.builder().action( action )
                    .requestDomain( wxaDomainProperties.getRequest() )
                    .downloadDomain( wxaDomainProperties.getDownload() )
                    .uploadDomain( wxaDomainProperties.getUpload() )
                    .wsRequestDomain( wxaDomainProperties.getWs() )
                    .build();
            return wxOpenService.getWxOpenComponentService().getWxMaServiceByAppid( appId ).getSettingService().modifyDomain( domainAction );
        } catch (WxErrorException e) {
            logger.error("modifyDomain", e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/setWebViewDomain")
    @ResponseBody
    public WxMaDomainAction setWebViewDomain(@RequestParam String appId,@RequestParam String action){
        //设置小程序服务器域名
        try {
            WxMaDomainAction domainAction = WxMaDomainAction.builder().action( action )
                    .webViewDomain( wxaDomainProperties.getWebview() )
                    .build();
            return wxOpenService.getWxOpenComponentService().getWxMaServiceByAppid( appId ).getSettingService().setWebViewDomain( domainAction );
        } catch (WxErrorException e) {
            logger.error("setWebViewDomain", e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/commit")
    @ResponseBody
    public String commit(@RequestParam String appId,@RequestParam String cid,@RequestParam Long templateId){
        //为授权的小程序帐号上传小程序代码
        try {
            JsonObject ext = new JsonObject();
            ext.addProperty( "cid",cid );
            WxMaCodeExtConfig extConfig = WxMaCodeExtConfig.builder()
                    .extEnable( true )
                    .extAppid( appId )
                    .ext( ext )
                    .build();
            WxMaCodeCommitRequest commitRequest = WxMaCodeCommitRequest.builder().extConfig( extConfig ).templateId( templateId ).build();
            wxOpenService.getWxOpenComponentService().getWxMaServiceByAppid( appId ).getCodeService().commit( commitRequest );
            return "SUCCESS";
        } catch (WxErrorException e) {
            logger.error("commit", e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getQrCode")
    public void getQrCode(@RequestParam String appId,HttpServletResponse resp){
        //获取体验小程序的体验二维码
        try {
            OutputStream stream = resp.getOutputStream();
            stream.write(wxOpenService.getWxOpenComponentService().getWxMaServiceByAppid( appId ).getCodeService().getQrCode());
            stream.flush();
            stream.close();
        } catch (IOException e){
            logger.error("getQrCode", e);
        } catch (WxErrorException e) {
            logger.error("getQrCode", e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/submitAudit")
    @ResponseBody
    public long submitAudit(@RequestParam String appId,@RequestParam String tag,@RequestParam String title){
        //将第三方提交的代码包提交审核（仅供第三方开发者代小程序调用），返回：审核编号
        try {
            WxMaCodeService service = wxOpenService.getWxOpenComponentService().getWxMaServiceByAppid( appId ).getCodeService();
            List<WxMaCategory> categoryList = service.getCategory();
            List<String> pageList = service.getPage();
            WxMaCategory category = categoryList.get( 0 );
            category.setAddress( pageList.get( 0 ) );
            category.setTag(tag);
            category.setTitle( title );
            List<WxMaCategory> itemList = new ArrayList<>(  );
            itemList.add( category );
            WxMaCodeSubmitAuditRequest request =  WxMaCodeSubmitAuditRequest.builder()
                    .itemList( itemList )
                    .build();
            return service.submitAudit( request );
        } catch (WxErrorException e) {
            logger.error("submitAudit", e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getAuditStatus")
    @ResponseBody
    public WxMaCodeAuditStatus getAuditStatus(@RequestParam String appId,@RequestParam Long auditId){
        //查询某个指定版本的审核状态（仅供第三方代小程序调用）
        try {
            WxMaCodeService service = wxOpenService.getWxOpenComponentService().getWxMaServiceByAppid( appId ).getCodeService();
            return service.getAuditStatus( auditId );
        } catch (WxErrorException e) {
            logger.error("getAuditStatus", e);
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/getLatestAuditStatus")
    @ResponseBody
    public WxMaCodeAuditStatus getLatestAuditStatus(@RequestParam String appId){
        //查询最新一次提交的审核状态（仅供第三方代小程序调用）
        //{"auditId":466607965,"status":2}	审核状态，其中0为审核成功，1为审核失败，2为审核中
        try {
            WxMaCodeService service = wxOpenService.getWxOpenComponentService().getWxMaServiceByAppid( appId ).getCodeService();
            return service.getLatestAuditStatus();
        } catch (WxErrorException e) {
            logger.error("commit", e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/release")
    @ResponseBody
    public String release(@RequestParam String appId){
        //发布已通过审核的小程序（仅供第三方代小程序调用）
        try {
            wxOpenService.getWxOpenComponentService().getWxMaServiceByAppid( appId ).getCodeService().release();
            return "SUCCESS";
        } catch (WxErrorException e) {
            logger.error("release", e);
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/changeVisitStatus")
    @ResponseBody
    public String changeVisitStatus(@RequestParam String appId,@RequestParam String action){
        //修改小程序线上代码的可见状态（仅供第三方代小程序调用）
        try {
            wxOpenService.getWxOpenComponentService().getWxMaServiceByAppid( appId ).getCodeService().changeVisitStatus(action);

            return "SUCCESS";
        } catch (WxErrorException e) {
            logger.error("changeVisitStatus", e);
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/revertCodeRelease")
    @ResponseBody
    public String revertCodeRelease(@RequestParam String appId){
        //小程序版本回退（仅供第三方代小程序调用）
        try {
            wxOpenService.getWxOpenComponentService().getWxMaServiceByAppid( appId ).getCodeService().revertCodeRelease();
            return "SUCCESS";
        } catch (WxErrorException e) {
            logger.error("revertCodeRelease", e);
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/undoCodeAudit")
    @ResponseBody
    public String undoCodeAudit(@RequestParam String appId){
        //15. 小程序审核撤回
        try {
            wxOpenService.getWxOpenComponentService().getWxMaServiceByAppid( appId ).getCodeService().undoCodeAudit();
            return "SUCCESS";
        } catch (WxErrorException e) {
            logger.error("undoCodeAudit", e);
            throw new RuntimeException(e);
        }
    }



    @GetMapping("/bindTester")
    @ResponseBody
    public String bindTester(@RequestParam String appId,@RequestParam String wechatId){
        //绑定微信用户为小程序体验者
        try {
            wxOpenService.getWxOpenComponentService().getWxMaServiceByAppid( appId ).getSettingService().bindTester( wechatId );
            return "SUCCESS";
        } catch (WxErrorException e) {
            logger.error("bindTester", e);
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/unbindTester")
    @ResponseBody
    public String unbindTester(@RequestParam String appId,@RequestParam String wechatId){
        //解除绑定小程序的体验者
        try {
            wxOpenService.getWxOpenComponentService().getWxMaServiceByAppid( appId ).getSettingService().unbindTester(wechatId );
            return "SUCCESS";
        } catch (WxErrorException e) {
            logger.error("unbindTester", e);
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/memberauth")
    @ResponseBody
    public String memberauth(@RequestParam String appId){
        //获取体验者列表
        try {
            Map<String, Object> param = new HashMap<>(1);
            param.put("action", "get_experiencer");

            return wxOpenService.getWxOpenComponentService().getWxMaServiceByAppid( appId )
                    .post("https://api.weixin.qq.com/wxa/memberauth", WxMaGsonBuilder.create().toJson(param));
        } catch (WxErrorException e) {
            logger.error("bindTester", e);
            throw new RuntimeException(e);
        }
    }

}
