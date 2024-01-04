package com.qf.p11.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "9021000133659838";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCxN1eB3FP8yedpSdjfdc1gsUdMZMtatcS448ppP4K22GXBJ6lmZJ/VbBzzkWNFP0BFthmLhcgUHsI9VnbyB+OSimSmjqqtp1HhY+oVmPpf1VmPf35mJNKYdYDDrQh8Tbrcz7CfTxuHrSyl0DEUSb9B6eyH2+ULExqWN+XJmibY1ZQ+qTmVnUMQAVBQEQ4epKUM915x/PuXBxol5owKpMg0d7Mk19DceSyrbp5E3VEtTexTK7G8GkDLMoajNNVn3T2+9op9+TU2KnJkH8PMHI0bjZSI4iDg6QHvZONi9VnSnZDNh8z8a/ieEIQT1TQJpBHNkQR8tq2ZXzGhRzLATEyhAgMBAAECggEAZWIo0OUws1z649RYmza0wU2KYZ0EbaexnKjM4rtv15UjWYaMNkT438tTINEbPsF5zqfoI1bs6P3T1+2AbOSwf+Rmwpa59FDV2iEkCSkUjADtlNe2g08roAcRHGEAisSZU7wJ6ooCUPN0qIPboCS0o0vlgq/9cAGE402lS1nCQaevTpCuOCREc6yMafvO/keCZees1qQdFIIIgRi9Fr33fMIYYaTPI6QazGWf+L8/+wIerAKXgRFHHdwr89TUw2DzUB6+LQwXmLfIGqpcMoKhbkiiUzWhapBwY7kPL6dv1Y5hGPYRrQROLYYPl3gKRgodm8V0jueXzo9Xk19okaCsFQKBgQD8NCDm/wHYtiQvyIs83KnyiBZ2ZihE8Bn5Lf/1yab1AmRD2bwRG4JFTarX+wvgA6l96/Z5qKrLZYH2UvcA2DBZ5DIHz1A9l3a7H7Ogr5UBV+Xqq9MC5+nKCNgdae/0lzsIBH8oZb9MJErGitHAikhKP2eodlV8EUr2Lbr9lxsxHwKBgQCz4j9sEkc8jLKi3UQ4ts8Kq/mOmtesAMf91LU2e1z6RFfwQuZgYoTKzvLZx5LaJ3aor4HU9P93JqwzswCZoLoHdHiU7Y6kItAySkHTSXAiIvj5K85WDJgYpeLf0YYlhv79/A0OZo0iVzwtU1IxV02ba5dcuAqqOmBEaxvD+VAKPwKBgA6VvSleqe6sad9Ri6vTXwilkhb6xW1nLTlZzambJcqZfs7lspiSrK/xU+X1oLQtwgmEMdbLSEVG84MZPSuRVQp9xd7pwEwvjDA6Hxs1zDotqSAvG57ZZo3GgSkCTVwpusI18FyXtb5jgueEc6jc1l1k2UvGvB7WqS0fa+bqbColAoGAOsd4X/ENFA0JpkxVKY8a0mrlriKMzOiocRobaMUg2aqRbbH+o4otyDOdiWo8Y0q37GEFNLgl7iJV7MLWNF0fzKXTbR6/GIVDsNsw7UC3AoCZCJq23slYvd0e6HIHuqWFFytQfN8nyQvmXw0182eKtXmPyT1eRseyg0jYls4VyHMCgYAjLpES3Oaa95yhwrPbheElqTJ6PJrSAArmPtLliaU7wJTyo2uTz+QF0VSFI1EXd9xXp5ROV2kHtACiD70JzLjVfNUEd3IfQy9HI4vKxevLnUjirOyyFBjpAAQicfbDG8XVc3Z+nNCkuqum6ol9Fvz+gPWQfcy/KfToj3f6YE56UQ==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkQG//Nqi81t/xsU42GHR+S63WqfiB5ZTCP+Z4JJwHg/aJo8Rw641EBfBULiLuWnPGiLRH3hJ7aF0lZFZbemTtm14FPCvhtZB0nlpirWmaOO+G1e5ZcidJP/B53A6tHtMy2nVQyS5kOUYLiSb80JbwvLb+mDNWcbdg9NMZfKFcReIzrnX971yVkaBqEqjyWa/wbCYLBy9yTnaEHcNs2ZDy1Zw9ZTbeISrHOqo5BnDbkcsh9y6RXv6y6hoBHrmNpCm3livDAraB8iMJSo8lPpb72YeK1mkdkn+yTxcpiMCZ4AVgen/BQwDooq606o8oc5HR1DE/hXd+rQ+xhfv1Vq/EwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "https://fa40-113-89-102-124.ngrok-free.app/p11/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/p11/return_url";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

