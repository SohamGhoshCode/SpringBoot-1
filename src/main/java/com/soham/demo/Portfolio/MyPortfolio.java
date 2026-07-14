package com.soham.demo.Portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPortfolio {

    @GetMapping("/myself")
    public String myself() {
        return """
                <h1>About Me</h1>
                <p>Hi, I am Soham Ghosh, a B.Tech CSE student (2027) with strong interest in Full Stack Development and Game Development.</p>
                <p>Skilled in Java, C++, JavaScript, React, Node.js, and Spring Boot.</p>
                <p>GitHub: <a href="https://github.com/SohamGhoshCode/SpringBoot-1" target="_blank">
                Github Repo SpringBoot</a></p>
                <p>Leetcode: <a href="https://leetcode.com/u/2004sohamghosh/" target="_blank">
                Leetcode Link</a></p>
                """;
    }

    @GetMapping("/skills")
    public String skills() {
        return """
                <h1>Skills</h1>
                <ul>
                    <li>Languages: C, C++, Java, Python, JavaScript</li>
                    <li>Frontend: React, Tailwind CSS, Bootstrap</li>
                    <li>Backend: Node.js, Express.js, Spring Boot</li>
                    <li>Database: MySQL, MongoDB</li>
                    <li>Tools: Git, Postman, Cloudinary</li>
                </ul>
                """;
    }

    @GetMapping("/education")
    public String education() {
        return """
                <h1>Education</h1>
                <p>B.Tech in Computer Science Engineering</p>
                <p>Lovely Professional University (2023 - 2027)</p>
                """;
    }

    @GetMapping("/projects")
    public String projects() {
        return """
                <h1>Projects</h1>
                <ul>
                    <li><b>ASAP! - AI Interview Platform</b> (MERN + Gemini API)</li>
                    <li><b>Trendiio - Social Media App</b> (MERN + WebSockets)</li>
                    <li><b>VidFlow - Streaming Backend</b> (Node.js, JWT)</li>
                </ul>
                """;
    }
}