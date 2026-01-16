import { BrowserRouter, Routes, Route } from "react-router-dom";
import { useRef, useState, useEffect } from "react";

import Home from "./pages/Home";
import Songs from "./pages/Songs";
import Login from "./pages/Login";
import Account from "./pages/Account";
import Sidebar from "./components/Sidebar";
import Player from "./components/Player";

export default function App() {
    const audioRef = useRef(null);
    const [currentSong, setCurrentSong] = useState(null);

    const [user, setUser] = useState(null);

    useEffect(() => {
        const saved = localStorage.getItem("user");
        if (saved) {
            setUser(JSON.parse(saved));
        }
    }, []);

    const playSong = (song) => {
        const audio = audioRef.current;
        if (!audio) return;

        // Set source and play immediately inside the tap event
        audio.src = song.audioUrl;

        audio
            .play()
            .then(() => {
                setCurrentSong(song); // UI update after playback starts
            })
            .catch((err) => {
                console.log("Playback blocked:", err);
            });
    };



    const handleLogin = (u) => {
        setUser(u);
        localStorage.setItem("user", JSON.stringify(u));
    };

    const handleLogout = () => {
        setUser(null);
        localStorage.removeItem("user");
    };

    return (
        <BrowserRouter>
            <div className="app">
                <Sidebar />

                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route
                        path="/songs"
                        element={<Songs onPlay={playSong} />}
                    />
                    <Route
                        path="/login"
                        element={<Login onLogin={handleLogin} />}
                    />
                    <Route
                        path="/account"
                        element={
                            <Account user={user} onLogout={handleLogout} />
                        }
                    />
                </Routes>
            </div>

            <Player song={currentSong} audioRef={audioRef} />
            <audio ref={audioRef} controls />

        </BrowserRouter>
    );
}
