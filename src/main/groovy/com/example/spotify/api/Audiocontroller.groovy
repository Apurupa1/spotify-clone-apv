package com.example.spotify.api

import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/stream")
class AudioController {

    @GetMapping("/{name}")
    ResponseEntity<Resource> stream(@PathVariable("name") String name) {

        File file = new File("music/${name}")

        if (!file.exists()) {
            return ResponseEntity.notFound().build()
        }

        Resource resource = new FileSystemResource(file)

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "audio/mpeg")
                .header(HttpHeaders.CONTENT_LENGTH, file.length().toString())
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"${file.name}\"")
                .body(resource)
    }
}
