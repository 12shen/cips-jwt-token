package com.cips.data.Controller;

import com.alibaba.csb.sdk.ContentBody;
import com.alibaba.csb.sdk.HttpCaller;
import com.alibaba.csb.sdk.HttpCallerException;
import com.alibaba.csb.sdk.HttpParameters;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.cips.data.Util.AESUtil;
import com.cips.data.Util.ResponseMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/csb")
public class CsbHttpClientController {

    @Value("${csb.url}")
    private String url;
    @Value("${csb.ak}")
    private String ak;
    @Value("${csb.sk}")
    private String sk;
    @Value("${csb.dk}")
    private String dk;
/**-------------------------加解密逻辑--------------------------------------------

    private ResponseMessage getCsbGttpClient(@ResponseBody JSONObject jsonObject){
        //加密
        string jsonData=this。getEncryptData(jsonObject,dk);
        JSONObject result=this.post(jsonData, apiName:”getStockRank“,apiversion:"1.0.0",ak sk);
        if(result.containsKey("code")){
            if("200".equals(result.getString(key:"code"))){
                String decodeData=this.getDecodeData(result.getString(key:"data"),dk);
                JSONObject json=JSON.parseObject(decodeData);
                return ResponseMessage.ok(json);

            }
        }
        //加密逻辑
        return ResponseMessage.error(result.getString(key:"message"));
        //加密
        public String getEncryptData(JSONObject jsonObject,String key){
            return AESUtil.aesEncode(JSON.toJSONString(jsonObject),key);
        }
        //解密
        public String getDecodeData(String content,string key){return AESUtil.aesEncode(content,key);}
        //post请求
        public JSONObject post(String conent,String apiName,String apiVersion,String ak,String sk){
            HttpParameters.Builder builder=HttpParameters.newBuilder();
            builder.requestURL(url);
        }
    }*/

    //-----------------------------------------------------------------------------------------
    @RequestMapping("/test")
    private ResponseMessage getCsbHttpClient(@RequestBody JSONObject jsonObject) {
        //加密
        String jsonData = this.getEncryptData(jsonObject,dk);
        JSONObject result = this.post(jsonData, "getStockRank", "1.0.0", ak, sk);
        if(result.containsKey("code")){
            if("200".equals(result.getString("code"))){
                //对 data 解密
                String decodeData = this.getDecodeData(result.getString("data"), dk);
                JSONObject json = JSON.parseObject(decodeData);
                return ResponseMessage.ok(json);
            }
        }
        //加解密逻辑
        return ResponseMessage.error(result.getString("message"));
    }

    //加密
    public String getEncryptData(JSONObject jsonObject,String key) {
        return AESUtil.aesEncode(JSON.toJSONString(jsonObject), key);
    }

    //解密
    public String getDecodeData(String content,String key) {
        return AESUtil.aesDecode(content, key);
    }

    //post请求
    public JSONObject post(String content, String apiName, String apiVersion, String ak, String sk) {
        HttpParameters.Builder builder = HttpParameters.newBuilder();
        builder.requestURL(url) // 设置请求的URL
                .contentType("application/json")
                .api(apiName) // 设置服务名
                .version(apiVersion) // 设置版本号
                .method("post") // 设置调用方式, get/post
                .accessKey(ak)
                .secretKey(sk); // 设置accessKey 和 设置secretKey

        System.out.println("入参：" + content);
        //解密
        String decodeData = this.getDecodeData(content, dk);
        // 设置请求参数（json格式)

       // ContentBody cb=  new ContentBody(decodeData);  内容body对象
        ContentBody cb = new ContentBody(decodeData);
        builder.contentBody(cb);

        //进行调用 返回结果（json格式)
        JSONObject jsonObject = new JSONObject();
        try {
            String result = HttpCaller.invoke(builder.build());
            System.out.println("出参：" + result);
            //对 data 加密
            jsonObject = JSON.parseObject(result);//返回的json对象
            if(jsonObject.containsKey("code")){
                if("200".equals(jsonObject.getString("code"))){
                    JSONObject data = (JSONObject) jsonObject.get("data");
                    String encryptData = this.getEncryptData(data, dk);
                    jsonObject.put("data",encryptData);
                }
            }
            return jsonObject;
        } catch (HttpCallerException e) {
            //e.printStackTrace();
            jsonObject.put("code","500");
            jsonObject.put("message",e.getMessage());
            jsonObject.put("data","");
            return jsonObject;
        }
    }

}
