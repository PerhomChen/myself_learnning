package API.onlinePay

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.core.http.HttpClient


/**
 *@Author: Logan Chen
 *@date: 2019/11/8 13:56
 *@Description:
 */

class httpTest {


}

fun main() {
    val vertx: Vertx = Vertx.vertx()
    val client: HttpClient = vertx.createHttpClient()
    client.getNow("www.baidu.com", "/", resp -> println(resp.sta))
}

class CoreVertticle : AbstractVerticle() {
    override fun start(startFuture: Future<Void>?) {
        val router = createRouter()
        val port = config().getInteger("http.port", 8080)
        vertx.createHttpServer()
            .requestHandler { router.accept(it) }
            .listen(port){
                result -> if(result.succeeded()){
                startFuture?.isComplete()
            } else {
                startFuture?.failed()
            }
            }
    }
}