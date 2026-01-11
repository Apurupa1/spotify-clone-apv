package com.example.spotify.api

import com.example.spotify.model.Song
import com.example.spotify.service.SongService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/songs")
class SongController {

    private final SongService songService

    SongController(SongService songService) {
        this.songService = songService
    }

    @GetMapping
    List<Song> getSongs() {
        songService.getAllSongs()
    }

    @GetMapping("/search")
    List<Song> search(@RequestParam String q) {
        songService.search(q)
    }
}
