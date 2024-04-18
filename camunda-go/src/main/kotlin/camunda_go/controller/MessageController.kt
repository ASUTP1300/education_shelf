package camunda_go.controller

import org.camunda.bpm.engine.RuntimeService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@ResponseBody
class MessageController(
    val runtimeService: RuntimeService,
) {
    val MESSAGE_START = "MessageHTTP"

    @PostMapping("/test/{message}")
    fun postMessage(@PathVariable message: String) {

        runtimeService.startProcessInstanceByMessage(MESSAGE_START, mapOf("Message" to message))
    }
}