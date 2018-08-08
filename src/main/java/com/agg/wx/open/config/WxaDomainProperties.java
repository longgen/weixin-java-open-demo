package com.agg.wx.open.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by longgen on 2018-08-08 14:52
 */
@ConfigurationProperties(prefix = "wechat.domain")
@Component
public class WxaDomainProperties {
    List<String> request;
    List<String> download;
    List<String> upload;
    List<String> ws;
    List<String> webview;

    public List<String> getRequest() {
        return request;
    }

    public void setRequest(List<String> request) {
        this.request = request;
    }

    public List<String> getDownload() {
        return download;
    }

    public void setDownload(List<String> download) {
        this.download = download;
    }

    public List<String> getUpload() {
        return upload;
    }

    public void setUpload(List<String> upload) {
        this.upload = upload;
    }

    public List<String> getWs() {
        return ws;
    }

    public void setWs(List<String> ws) {
        this.ws = ws;
    }

    public List<String> getWebview() {
        return webview;
    }

    public void setWebview(List<String> webview) {
        this.webview = webview;
    }
}
