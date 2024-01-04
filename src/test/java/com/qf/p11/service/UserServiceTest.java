package com.qf.p11.service;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayDataDataserviceBillDownloadurlQueryModel;
import com.alipay.api.request.AlipayDataDataserviceBillDownloadurlQueryRequest;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.github.pagehelper.PageInfo;
import com.qf.p11.config.AlipayConfig;
import com.qf.p11.pojo.Product;
import com.qf.p11.vo.OrderDetailVO;
import com.qf.p11.vo.OrdersVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Lj
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class UserServiceTest {

    @Resource
    UserService userService;

    @Test
    public void test01(){
        PageInfo<Product> pageInfo = userService.queryPageProductByTypeId(1, 1);
        System.out.println(pageInfo);
        System.out.println("------------------");
//        System.out.println(pageInfo.getList());
        pageInfo.getList().forEach(System.out::println);
    }

    @Test
    public void test02(){
        BigDecimal price = new BigDecimal(20);
        userService.updateCartCountAndNum(4,16,2);
    }


    @Test
    public void test03(){
        userService.addSingleOrder(1,4);
    }


    @Test
    public void test04(){
        List<OrdersVO> ordersVOS = userService.queryAllOrderWithAddressByUid(4);
        ordersVOS.forEach(System.out::println);
    }


    @Test
    public void test05(){
        OrderDetailVO orderDetailVO = userService.queryOrderDetailVOByOid(26);
        System.out.println(orderDetailVO);
    }


    @Test
    public void test06() throws UnsupportedEncodingException {
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = new String("你好".getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(out_trade_no);
    }


    @Test
    public void test07() throws AlipayApiException, UnsupportedEncodingException {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
        JSONObject bizContent = new JSONObject();
//        bizContent.put("trade_no", 24   );
        String orn = new String("24".getBytes("ISO-8859-1"),"UTF-8");
        bizContent.put("out_request_no", orn);
        System.out.println(bizContent.toString());

//// 返回参数选项，按需传入
//JSONArray queryOptions = new JSONArray();
//queryOptions.add("refund_detail_item_list");
//bizContent.put("query_options", queryOptions);

        request.setBizContent(bizContent.toString());
        AlipayTradeFastpayRefundQueryResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }

    @Test
    public void test08() throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        AlipayDataDataserviceBillDownloadurlQueryRequest request = new AlipayDataDataserviceBillDownloadurlQueryRequest();
        AlipayDataDataserviceBillDownloadurlQueryModel model = new AlipayDataDataserviceBillDownloadurlQueryModel();
        model.setSmid("2088123412341234");
        model.setBillType("trade");
        model.setBillDate("2016-04-05");
        request.setBizModel(model);
        AlipayDataDataserviceBillDownloadurlQueryResponse response = alipayClient.execute(request);
        System.out.println(response.getBody());
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
            // sdk版本是"4.38.0.ALL"及以上,可以参考下面的示例获取诊断链接
            // String diagnosisUrl = DiagnosisUtils.getDiagnosisUrl(response);
            // System.out.println(diagnosisUrl);
        }

    }


    @Test
    public void test09() throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent("{" +
                "  \"out_trade_no\":\"26\"," +
//                "  \"trade_no\":\"2014112611001004680 073956707\"," +
                "  \"query_options\":[" +
                "    \"trade_settle_info\"" +
                "  ]" +
                "}");
        AlipayTradeQueryResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
            System.out.println(response.getBody());
        } else {
            System.out.println("调用失败");
        }
    }

    @Test
    public void test10() throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        JSONObject bizContent = new JSONObject();
//        bizContent.put("trade_no", "2024010322001416200502061014");
        bizContent.put("out_request_no", 26);
        bizContent.put("refund_amount", 5);


//// 返回参数选项，按需传入
//JSONArray queryOptions = new JSONArray();
//queryOptions.add("refund_detail_item_list");
//bizContent.put("query_options", queryOptions);

        request.setBizContent(bizContent.toString());

//        request.setBizContent("{" +
//                "  \"out_trade_no\":\"26\"," +
//                "  \"refund_amount\":\"5\"," +
////                "  \"query_options\":[" +
////                "    \"trade_settle_info\"" +
////                "  ]" +
//                "}");
        AlipayTradeRefundResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
            System.out.println(response.getBody());
        } else {
            System.out.println("调用失败");
        }
    }

}
//严重: ErrorScene^_^40004^_^ACQ.INVALID_PARAMETER^_^null^_^Windows 10^_^2024-01-03 21:23:51^_^
//        ProtocalMustParams:
//        charset=utf-8&
//        method=alipay.trade.refund&
//        sign=HfP/Ye3++i1TApV6w4xQXNMmythRNSfC2T4dKIK51iBLIucg0xEApr9dQFobPlpM+oiA4Nve8X1FF9kW4jIcVxwOpmMbNk1OfW6Aa36jCsb/CKgqwL3+wQz1Vvwx3FrfniKroPBJkWHiIwcVS+383riztw0KDPuvUmcG4hWLbIT/q+arsg7EZ/bCpYeMRvDi8KlX90Pkr0FuccwB4QA66YI+PfbBjykhTd/EwlYE0MJJYFxSEwAYZB9THGMWj0kF34CrN69dgaR/fQk3q0PgoVGz9+iyIVfPichCXWl/TqgIFWvJ/3s1ijAYKLAJW+zJkfzxTilEgblabTmnrZrOvg==&version=1.0&
//        app_id=9021000133659838&sign_type=RSA2&
//        timestamp=2024-01-03 21:23:49^_^
//        ProtocalOptParams:
//        alipay_sdk=alipay-sdk-java-4.38.183.ALL&format=json^_^
//        ApplicationParams:traceId=0601faea170428823260247522898&
//        biz_content={  "out_trade_no":"25",  "refund_amount":"6000",}^_^
//        Body:{"alipay_trade_refund_response":{"msg":"Business Failed","code":"40004","sub_msg":"参数无效：参数格式错误","sub_code":"ACQ.INVALID_PARAMETER"},"sign":"Bfygr2JapE3XttwgfxJstznR6dIWj9khHwtUjBg0Fbns8P1LM+P+24YnKOlIUGi4rtibeCXeJ69kDeK3A7q4MGwEui7ZRsRksKGib58dv6zAA48TnS3+VveytGqh6SUf5KqHUCWrWgtDLvqM5hHv/oAqSGCMi6/xhAz3uj2vNBNn1LXLktqKhJfINuMRtnN5LDIXhsblLY33MtleksfyoN5EHrEc8PnKERiV5q65vSoMGO8XBcBpRJ7Vibrgh13hp6UJTYV8IGYzPC7u5wjDSkeybQxTMQwsCWT7BS/J7XsFNNXDEijHOIcA0wFoEEDVswVrlXQt3pnhNfl15pdqsg=="}^_^942ms,394ms,18ms^_^
//        trace_id:0601faea170428823260247522898

