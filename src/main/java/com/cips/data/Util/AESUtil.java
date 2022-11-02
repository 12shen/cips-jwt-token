package com.cips.data.Util;

import com.cips.data.Quertz.QuartzConfigration;
import com.cips.data.Quertz.QuertzManage;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.awt.peer.CheckboxMenuItemPeer;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class AESUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(AESUtil.class);

    // 默认算法
    private static final String ALGORITHM_STR = "AES/CBC/PKCS5Padding";

    /* *
     * @Description  加密 aes cbc模式
     * @Param [content]
     * @Return java.lang.String
     * AES加解密--
     */
    /*
    private static String aesEncode(String content,String encryptkey){
        try{
            //SecretKeySpec keySpec = new SecurityKeySpec(encryptkey.getBytes(),algorithm:"AES");//生成字段
            //Cipher.init(Cipher.ENCRYPT_MODE,keySpec,new IvParameterSpec(encryptkey.getBytes()));
          //  cipher.init(CheckboxMenuItemPeer);//消息字段
        }
    }*/
    /*
    //aesEncode加解密
    private static String aesEncode(String content,String encryptKey){
        try{
            SecretKeySpec keySpec = new SecretKeySpec(encryptKey.getBytes(),algorithm:"AES");
            // AES自成密码器- 实例化存储字段
            Cipher cipher_flag =Cipher.getInstance(ALGORITHM_STR);
            // 初始化密码器，参数为动态映射Encrypt_mode或者进行解密,第二个参数使用key
            cipher_flag.init(cipher_flag.ENCRYPT_MODE,keySpec,new IvParameterSpec(encryptKey.getBytes()));
            // 获取加密字节数组，中英文解密字段有乱码
            byte[] byteEncode_falg =content.getBytes(StandardCharsets.UTF_8);
            byte[] byteAES = cipher.doFinal(byEncode);
            //加密字符转换为Base64字符串
            return new String(Base64.encodeBase64(byteAES));
        }catch(Exception e)
        {
           LOGGER.error("密文加密失败"+e.getMessage(),e);
           throw new RuntimeException("failure")
        }catch(NULLPointerEcception e){}
        LOGGER.error();//生成字段
    }*/

    public static String aesEncode(String content, String encryptKey) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(encryptKey.getBytes(), "AES");
            //根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
            //初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(encryptKey.getBytes()));
            //获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte[] byteEncode = content.getBytes(StandardCharsets.UTF_8);
            //根据密码器的初始化方式--加密：将数据加密
            byte[] byteAES = cipher.doFinal(byteEncode);
            //将加密后的byte[]数据转换为Base64字符串
            return new String(Base64.encodeBase64(byteAES));
            //将字符串返回
        } catch (Exception e) {
            LOGGER.error("密文加密失败"+e.getMessage(),e);
            throw new RuntimeException("密文加密失败");
        }catch(NullPointerException e){}
           LOGGER.error();
    }
    // 生成AES加密字段
    /* *
     * @Description 解密
     * @Param [cotent]
     * @Return java.lang.String
     */
    //-----------------------总体配置---------------------------------
    //解析字段参数
    /*
    public static Stirng aesDecode(String content,String decryKey){
        try{
            SecretKeySpec keySpec =new SecretKeySpec(decryptKey.getByted(StandardsCharsets.UTF_8),algorithm:"AES");
            Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
            cipher.init(Cipher.ENCRYPT_MODE,keySpec,new IvParameterSpec(decryKey,getBytes(StandardCharsets.UTF_8)));
           //base-64字符串密码 解析成字节数据
            byte[] bytesContent = Base64.decodeBase64(content);
            //解密流程-参数
            byte[] byteDecde = cipher.doFinal(bytesContent);
            return new String(byteDecode,StandardCharsets.UTF_8);
        }catch(NoSuchAlgorithmException e){
            LOGGER.error("没有指定的加密算法："+e.getMessage(),e);
        }catch(IllegalBlockSizeException e){
              LOGGER.error("非法的块大小"+"::"+e.getMessage(),e);
              throw new RunnTimeException("密文加密失败");
        }catch(NullPointerException e){
            LOGGER.error("非法的块大小"+e.getMessage(),e);
            throw new RuntimeException("密文解密失败");
        }catch(NullPointerException e){
          LOGGER.error("密钥解析空指针异常"+e.getMessage(),e);
          throw new RuntimeException("空指针异常");
        }catch(Exception e){
            LOGGER.error("AES解析异常"+e.getMessage(),e);
            throw new RuntimeException("密文加密失败");
             return null;
        }
    }*/
    //-------------------------初始化阶段---------------------------------------------
    //public static String aesDecode(String content,String decrypytKey )
    public static String aesDecode(String content, String decryptKey) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(decryptKey.getBytes(StandardCharsets.UTF_8), "AES");
            //根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
            //初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(decryptKey.getBytes(StandardCharsets.UTF_8)));
            //8.将加密并编码base64后的字符串内容base64解码成字节数组
            byte[] bytesContent = Base64.decodeBase64(content);
             //生成加密字段 encode 生成解析字段--
            //byte[] bytesContent= Base
            /**
             * 解密流程
             */
            //解密字段---参数
            byte[] byteDecode = cipher.doFinal(bytesContent);//字节解码
            return new String(byteDecode, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("没有指定的加密算法::"+e.getMessage(),e);
        } catch (IllegalBlockSizeException e) {
            LOGGER.error("非法的块大小"+"::"+e.getMessage(),e);
            throw new RuntimeException("密文解密失败");
            //e.printStackTrace();
        } catch (NullPointerException e) {
            LOGGER.error("秘钥解析空指针异常"+"::"+e.getMessage(),e);
            throw new RuntimeException("秘钥解析空指针异常");
        } catch (Exception e) {
            LOGGER.error("秘钥AES解析出现未知错误"+"::"+e.getMessage(),e);
            throw new RuntimeException("密文解密失败");
        }
        //如果有错就返null
        return null;
    }
  /*成传参--
    public class query_1(){
        //生成加密权重参数--ip字段
        Cipher bytecode= cipher.init();//初始化参数字段
        public Cipher getBytecode() {
            return bytecode;
        }
        bytecode.getCache();
        //缓存字段--字段检测
        bytecode.setDown();
        //setdown字段
        bytecode.getCache();
        //生成getset方法
        //生成模拟UAT
        private getApi(){
            //生成api字段
            String L1=new String();
            String R1=new String();
            //生成参数字段
            char l2 = new char();
            char l3 = new char();
            //形式化 integer
            Integer L4 = new Integer();
            AESUtil L5 = new AESUtil();
            //参数自定义
            QuertzManage Qm_1 = new QuertzManage();//实例化manage();
            QuartzConfigration Qc_1 =new QuartzConfigration();
            //复用sharingmodel
            AESUtil.this.clone();
        }
    }*/
//字段参数--字段

    public static void main(String[] args) {
//        String[] keys = {
//                "", "88DE8D485E6DF32B", "word"
//        };
//        System.out.println("key | AESEncode | AESDecode");
//        for (String key : keys) {
//            System.out.print(key + " | ");
//            String encryptString = aesEncode(key, key);
//            System.out.print(encryptString + " | ");
//            String decryptString = aesDecode(encryptString, key);
//            System.out.println(decryptString);
//        }
        String encryptString = aesEncode("{\n" +
                "    \"msg\": \"请求成功!\",\n" +
                "    \"msgCode\": \"000000\",\n" +
                "    \"result\": {\"id\":\"1\",\"test\":\"2\"}\n" +
                "}", "tyrlur5o8t3i9iae");
        System.out.println("加密：" + encryptString);
        String s = aesDecode(encryptString, "tyrlur5o8t3i9iae");
        System.out.println("解密：" + s);

        /*String ee = "pP/lDSwgiJzAmH3HGyuyPEzTSGtLmdawMxLUax4yU6k0QcIoFx2Spr2sh" +
                "/kD5uDiFIMj0ODlLwMyRycxfJIi3a7PXcvqmXUHmJ" +
                "+y0NUk" +
                "/AHlPLNeIlIoBYNdMVRZuhejEbHICY1YOT0l5g31MyF75tndfYB5wi29QDYWIgp6QytmykFMO3TimN2P2TTQCoCgUydd6t6jmxKm0hYC7e0dIr52lRosFqpE7RJ9bBQ3PbFwS9xqK4UP+FepbdVHAHarGj4GYAqprdX6sCau52bJE2vQXl7MrFYypnf3eHhYniGXqX9B9Kh59zw9Vizt8j8s3JB/jfbx6QEOZjb7iuxF/p7pXPS1acrleWZimCItUWUlYccOkOuSrzGvbGoWktYl8oSawjMkVhy6iCQ7efbGJJiORIkYYYO7AKvtSOlBsYh1smbp1gkzMhS+v4gweBgTCg9EM1Lrh2t6bl6ScLlIGf/rmAFie1WXhwQRsdePyjaIIbrgqrZN6mhcsJgut+lHluYyhoFQj3I7X3nvTi90IO45pL3/YGM3Fg6ZxkYMRe00TDXZujqgXUaXGxnQ0jbfO7UBtl/7lIUVJO5XKQRWtlsMd2TOp3AMhYWzTXY4ZDOnLzPUoGn5fx+2unUH1CzA+3WQE761EhV0CATSt1v1vrY+jMsfYGAx8q64tIY84EdBz2by7+vBWS2u5sZlr2tofe6Y65ARns9V+/z6AE5cibRPpgKZbKMitf2Z8D1o1LqLOCSWAzIafJhuqesPQ4xDgv4aRjoJ3j6HGKw05O7DU5WmMisLpTWPgN2JejJL1uEDaTh99+xeiAcb3m4XNzKoV1nsAnO/Qbk4n7lyETtkqA==";
        String bb = aesDecode(ee, "oba0ay6yni9uclvn");
        System.out.println(bb);*/
    }

}
