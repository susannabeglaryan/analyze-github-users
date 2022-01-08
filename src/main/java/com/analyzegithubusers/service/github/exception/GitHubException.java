package com.analyzegithubusers.service.github.exception;

public class GitHubException extends RuntimeException {
    public GitHubException(String message) {
        super("[GitHub]" + message);
    }
}
