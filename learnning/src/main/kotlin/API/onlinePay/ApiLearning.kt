package API.onlinePay


import com.alipay.api.DefaultAlipayClient
import com.alipay.api.request.AlipayTradeCreateRequest


/**
 *@Author: Logan Chen
 *@date: 2019/11/7 14:19
 *@Description:
 */

fun main() {
    val alipayClient = DefaultAlipayClient(
        "https://openapi.alipaydev.com/gateway.do",
        "app_id", "your private_key", "json",
        "utf-8", "alipay_public_key", "RSA2"
    )
    val request = AlipayTradeCreateRequest()


}