// src/app/admin/page.tsx
"use client";
import { useState } from 'react';

export default function AdminLogin() {
    const [username, setUsername] = useState<string>('');
    const [password, setPassword] = useState<string>('');

    const handleLogin = async (e: React.FormEvent) => {
        e.preventDefault();
        // Add login logic here
    }

    return (
        <div>
            <h1>Admin Login</h1>
            <form onSubmit={handleLogin}>
                <div>
                    <label>Username</label>
                    <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
                </div>
                <button type="submit">Login</button>
            </form>
            <p>Don't have an account? <a href="/admin/signup">Sign up here</a></p>
        </div>
    );
}
