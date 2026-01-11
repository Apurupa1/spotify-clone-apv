package com.example.spotify.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/upload")
class UploadController {

    @PostMapping
    ResponseEntity<Map> upload(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body([error: "Empty file"])
        }

        File dir = new File("music")
        if (!dir.exists()) dir.mkdirs()

        File target = new File(dir, file.originalFilename)
        file.transferTo(target)

        return ResponseEntity.ok([
            message : "Upload successful",
            audioUrl: "http://localhost:8080/api/stream/${file.originalFilename}"
        ])
    }
}
