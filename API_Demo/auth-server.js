const express = require("express");

const app = express();

app.use(express.json());

const PORT = 5000;

app.post("/login", (req, res) => {

    const { username, password } = req.body;

    if (
        username === "admin" &&
        password === "admin123"
    ) {

        return res.status(200).json({
            status: 200,
            statusText: "Success",
            message: "Login successful",
            data: {
                token: "SDET_TOKEN_123_45",
                tokenType: "Bearer"
            }
        });
    }

    return res.status(401).json({
        status: 401,
        statusText: "Unauthorized",
        message: "Invalid Credentials",
        suggestion: "Check username and password"
    });
});

app.listen(PORT, () => {
    console.log(`Auth Server running on http://localhost:${PORT}`);
});