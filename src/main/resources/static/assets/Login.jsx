import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Login.css";

export default function Login({ onLogin }) {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const submit = (e) => {
        e.preventDefault();

        // fake login for now
        onLogin({ name: "Apurupa", email });
        navigate("/account");
    };

    return (
        <main className="auth-page">
            <h1>Log in to Spotify</h1>

            <form onSubmit={submit} className="auth-form">
                <input
                    placeholder="Email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                />
                <input
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                <button>Log In</button>
            </form>
        </main>
    );
}
