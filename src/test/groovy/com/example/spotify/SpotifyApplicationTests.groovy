package com.example.spotify

import org.junit.jupiter.api.Test
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(exclude = [DataSourceAutoConfiguration])
class SpotifyApplicationTests {

    @Test
    void contextLoads() {
    }
}
