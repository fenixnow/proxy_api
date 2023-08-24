package ru.fenix.proxy_api.dtos;

public record SignUpDto (String firstName, String lastName, String login, char[] password) {
}
