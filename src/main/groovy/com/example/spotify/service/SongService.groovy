package com.example.spotify.service

import com.example.spotify.model.Song
import org.springframework.stereotype.Service

@Service
class SongService {

    List<Song> getAllSongs() {
        [
            new Song(
                id: "1",
                title: "Blinding Lights",
                artist: "The Weeknd",
                album: "After Hours",
                duration: 200,
                audioUrl: "http://localhost:8080/api/stream/levitating_ringtone.mp3"
            ),
            new Song(
                id: "2",
                title: "Levitating",
                artist: "Dua Lipa",
                album: "Future Nostalgia",
                duration: 203,
                audioUrl: "http://localhost:8080/api/stream/Blinding_Lights.mp3"
            )
        ]
    }

    List<Song> search(String query) {
        getAllSongs().findAll {
            it.title.toLowerCase().contains(query.toLowerCase()) ||
            it.artist.toLowerCase().contains(query.toLowerCase())
        }
    }
}
