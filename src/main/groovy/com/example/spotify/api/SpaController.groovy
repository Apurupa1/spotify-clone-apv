package com.example.spotify.api

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SpaController {

    @GetMapping(value = ["/", "/songs", "/login", "/account"])
    String forward() {
        return "forward:/index.html"
    }
}
