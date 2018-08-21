package com.agg.wx.open.controller;

import cn.binarywang.wx.miniapp.api.WxMaCodeService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaDomainAction;
import cn.binarywang.wx.miniapp.bean.code.*;
import cn.binarywang.wx.miniapp.util.json.WxMaGsonBuilder;
import com.agg.wx.open.config.WxaDomainProperties;
import com.agg.wx.open.entity.WeappAudit;
import com.agg.wx.open.entity.WeappAuditExample;
import com.agg.wx.open.entity.WeappAuth;
import com.agg.wx.open.entity.WeappAuthExample;
import com.agg.wx.open.mapper.WeappAuditMapper;
import com.agg.wx.open.mapper.WeappAuthMapper;
import com.agg.wx.open.service.WxOpenService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import me.chanjar.weixin.common.error.WxError;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.open.api.WxOpenComponentService;
import me.chanjar.weixin.open.api.WxOpenConfigStorage;
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

    @Autowired
    private WeappAuditMapper weappAuditMapper;

    @Autowired
    private WeappAuthMapper weappAuthMapper;






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
                getAuthorizerInfo(appid);
            }
            return queryAuthResult;
        } catch (WxErrorException e) {
            logger.error("gotoPreAuthUrl", e);
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/getAuthorizerInfo")
    @ResponseBody
    public WxOpenAuthorizerInfoResult getAuthorizerInfo(@RequestParam String appId){
        //获取授权方的帐号基本信息
        try {
            WxOpenAuthorizerInfoResult infoResult = wxOpenService.getWxOpenComponentService().getAuthorizerInfo(appId);
            WeappAuth weappAuth = new WeappAuth();
            weappAuth.setAppId( appId );
            weappAuth.setAccessToken( infoResult.getAuthorizationInfo().getAuthorizerAccessToken() );
            weappAuth.setRefreshToken( infoResult.getAuthorizationInfo().getAuthorizerRefreshToken() );
            weappAuth.setFuncInfo( WxMaGsonBuilder.create().toJson(infoResult.getAuthorizationInfo().getFuncInfo()) );
            weappAuth.setMiniProgramInfo( WxMaGsonBuilder.create().toJson(infoResult.getAuthorizerInfo().getMiniProgramInfo()) );
            weappAuth.setNickName( infoResult.getAuthorizerInfo().getNickName() );
            weappAuth.setUserName( infoResult.getAuthorizerInfo().getUserName() );
            weappAuth.setQrcodeUrl( infoResult.getAuthorizerInfo().getQrcodeUrl() );
            weappAuth.setPrincipalName( infoResult.getAuthorizerInfo().getPrincipalName() );
            weappAuth.setSignature( infoResult.getAuthorizerInfo().getSignature() );
            Date now = new Date();

            WeappAuthExample example = new WeappAuthExample();
            example.or().andAppIdEqualTo( appId );
            List<WeappAuth> exist = weappAuthMapper.selectByExample( example );
            if(exist.size()>0){
                weappAuth.setUpdated( now );
                weappAuthMapper.updateByExampleSelective( weappAuth, example);
            }else{
                weappAuth.setCreated( now );
                weappAuthMapper.insert( weappAuth );
            }
            return infoResult;
        } catch (WxErrorException e) {
            logger.error("getAuthorizerInfo", e);
            return  null;
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
            return getWxMaService(appId).getSettingService().modifyDomain( domainAction );
        } catch (WxErrorException e) {
            logger.error("modifyDomain", e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/setWebViewDomain")
    @ResponseBody
    public WxMaDomainAction setWebViewDomain(@RequestParam String appId,@RequestParam String action){
        //设置小程序服务器业务域名
        try {
            WxMaDomainAction domainAction = WxMaDomainAction.builder().action( action )
                    .webViewDomain( wxaDomainProperties.getWebview() )
                    .build();
            return getWxMaService(appId).getSettingService().setWebViewDomain( domainAction );
        } catch (WxErrorException e) {
            logger.error("setWebViewDomain", e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/commit")
    @ResponseBody
    public String commit(@RequestParam String appId,@RequestParam String cid,
                         @RequestParam String user_version,
                         @RequestParam String user_desc,
                         @RequestParam Long templateId){
        //为授权的小程序帐号上传小程序代码
        try {
            Map<String,String> ext = new HashMap<>(  );
            ext.put( "cid",cid );
//            JsonObject ext = new JsonObject();
//            ext.addProperty( "cid",cid );
            WxMaCodeExtConfig extConfig = WxMaCodeExtConfig.builder()
                    .extEnable( true )
                    .extAppid( appId )
                    .ext( ext )
                    .build();
//            JsonObject extConfig = new JsonObject();
//            extConfig.addProperty( "extEnable",true  );
//            extConfig.addProperty( "extAppid",appId  );
//            extConfig.addProperty( "ext",ext.toString()  );
            WxMaCodeCommitRequest commitRequest = WxMaCodeCommitRequest.builder()
                    .templateId( templateId )
                    .extConfig( extConfig )
                    .userVersion( user_version )
                    .userDesc( user_desc )
                    .build();
//            JsonObject commitRequest = new JsonObject();
//            commitRequest.addProperty( "template_id",templateId  );
//            commitRequest.addProperty( "ext_json",extConfig.toString()  );
//            commitRequest.addProperty( "user_version",user_version  );
//            commitRequest.addProperty( "user_desc",user_desc  );
//            String postData = new Gson().toJson(commitRequest);
//            String postData = commitRequest.toString();
//            String postData = "{\"extEnable\": true,\"extAppid\": \"wx0fcfc3188293fa40\",\"ext\": {\"title\": \"wechat\",\"cid\": \"112905\"}}";
            String lastCodeJson = commitRequest.toJson();
            logger.info( "commitRequest:"+ lastCodeJson );
            getWxMaService(appId).getCodeService().commit( commitRequest );
//            getWxMaService(appId).post( "https://api.weixin.qq.com/wxa/commit",postData );
            //记录提交的代码版本信息
            WeappAuditExample example = new WeappAuditExample();
            example.or().andAppIdEqualTo( appId );
            List<WeappAudit> examples = weappAuditMapper.selectByExample( example );
            Date now = new Date(  );
            if (examples.size()==0){
                WeappAudit newObj = new WeappAudit();
                newObj.setAppId( appId );
                newObj.setTemplateid( templateId );
                newObj.setLastCodeJson( lastCodeJson );
                newObj.setDevVersion( user_version );
                newObj.setDevDesc( user_desc );
                newObj.setDevTime( now );
                newObj.setCreated( now );
                weappAuditMapper.insertSelective( newObj );
            }else{
                WeappAudit oldObj = examples.get( 0 );
                oldObj.setTemplateid( templateId );
                oldObj.setLastCodeJson( lastCodeJson );
                oldObj.setDevVersion( user_version );
                oldObj.setDevDesc( user_desc );
                oldObj.setDevTime( now );
                weappAuditMapper.updateByPrimaryKey( oldObj );
            }
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
            stream.write(getWxMaService(appId).getCodeService().getQrCode());
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
    public String submitAudit(@RequestParam String appId,@RequestParam String tag,@RequestParam String title){
        //将第三方提交的代码包提交审核（仅供第三方开发者代小程序调用），返回：审核编号
        try {
            WeappAuditExample example = new WeappAuditExample();
            example.or().andAppIdEqualTo( appId ).andStatusNotEqualTo( 2 ).andAuditidEqualTo( 0L );
            List<WeappAudit> examples = weappAuditMapper.selectByExample( example );
            if (examples.size()==0){
                return  "已在审核中或待发布完成";
            }
            WxMaCodeService service = getWxMaService(appId).getCodeService();
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
            long auditid = service.submitAudit( request );
            //记录审核状态
            WeappAudit temp = examples.get( 0 );
            temp.setReason( "审核中" );
            temp.setStatus( 2 );
            temp.setAuditid( auditid );
            temp.setTag( tag );
            temp.setTitle( title );
            temp.setAuditVersion( temp.getDevVersion() );
            temp.setAuditDesc( temp.getDevDesc() );
            temp.setUpdated( new Date(  ) );
            weappAuditMapper.updateByPrimaryKey( temp );
            return ""+auditid;
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
            WxMaCodeService service = getWxMaService(appId).getCodeService();
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
            WxMaCodeService service = getWxMaService(appId).getCodeService();
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
            WeappAuditExample example = new WeappAuditExample();
            example.or().andAppIdEqualTo( appId ).andStatusEqualTo( 0 ).andAuditidGreaterThan( 0L );
            List<WeappAudit> examples = weappAuditMapper.selectByExample( example );
            if (examples.size()>0){
                //清除审核版本信息，记录线上版本号为审核版本号
                getWxMaService(appId).getCodeService().release();
                WeappAudit temp = examples.get( 0 );
                temp.setReason( "发布完成" );
                temp.setStatus( 4 );
                temp.setProdVersion( temp.getAuditVersion() );
                temp.setProdDesc( temp.getAuditDesc() );
                temp.setProdTime( new Date(  ) );
                temp.setAuditid( 0L );
                temp.setAuditDesc( "" );
                temp.setAuditVersion( "" );
                temp.setUpdated( new Date(  ) );
                weappAuditMapper.updateByPrimaryKey( temp );
                return "SUCCESS";
            }else{
                return  "未找到审核成功的小程序，不能发布";
            }
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
            getWxMaService(appId).getCodeService().changeVisitStatus(action);

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
            WeappAuditExample example = new WeappAuditExample();
            example.or().andAppIdEqualTo( appId ).andStatusEqualTo( 4 );
            List<WeappAudit> examples = weappAuditMapper.selectByExample( example );
            if (examples.size()>0){
                getWxMaService(appId).getCodeService().revertCodeRelease();
                WeappAudit temp = examples.get( 0 );
                temp.setReason( "版本回退中" );
                temp.setStatus( 5 );
                temp.setProdVersion( "-1" );
                temp.setProdDesc( "回退版本" );
                temp.setProdTime( new Date(  ) );
                temp.setUpdated( new Date(  ) );
                weappAuditMapper.updateByPrimaryKey( temp );
                return "SUCCESS";
            }else{
                return  "未找到发布完成的小程序，不能回滚";
            }
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
            WeappAuditExample example = new WeappAuditExample();
            example.or().andAppIdEqualTo( appId ).andStatusEqualTo( 2 );
            List<WeappAudit> examples = weappAuditMapper.selectByExample( example );
            if (examples.size()>0){
                getWxMaService(appId).getCodeService().undoCodeAudit();
                WeappAudit temp = examples.get( 0 );
                temp.setAuditid( 0L );
                temp.setReason( "审核撤回" );
                temp.setStatus( 3 );
                temp.setAuditDesc( "" );
                temp.setAuditVersion( "" );
                temp.setAuditTime( new Date(  ) );
                temp.setUpdated( new Date(  ) );
                weappAuditMapper.updateByPrimaryKey( temp );
                return "SUCCESS";
            }else{
                return  "未找到审核中的小程序，不能撤回";
            }
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
            getWxMaService(appId).getSettingService().bindTester( wechatId );
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
            getWxMaService(appId).getSettingService().unbindTester(wechatId );
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

            return getWxMaService(appId)
                    .post("https://api.weixin.qq.com/wxa/memberauth", WxMaGsonBuilder.create().toJson(param));
        } catch (WxErrorException e) {
            logger.error("memberauth", e);
            throw new RuntimeException(e);
        }
    }

    private WxMaService getWxMaService(String appId) throws WxErrorException {
        WxOpenConfigStorage storage =  wxOpenService.getWxOpenConfigStorage();
        String authorizerRefreshToken = storage.getAuthorizerRefreshToken( appId );
        if(StringUtils.isBlank( authorizerRefreshToken )){
            logger.info( "{}刷新令牌丢失，重新设置",appId );
            try {
                WxOpenAuthorizerInfoResult infoResult = getAuthorizerInfo( appId );
                authorizerRefreshToken = infoResult.getAuthorizationInfo().getAuthorizerRefreshToken();
            }catch (Exception e){
                logger.error( "获取刷新令牌失败",e );
            }
            if (StringUtils.isBlank( authorizerRefreshToken )){
                WxError error = WxError.builder().errorCode( 61023 ).errorMsg( "未授权，请管理员去授权页面扫码授权" ).build();
                throw new WxErrorException( error );
            }
            storage.setAuthorizerRefreshToken( appId,authorizerRefreshToken );
        }
        return wxOpenService.getWxOpenComponentService().getWxMaServiceByAppid(appId);
    }

}
