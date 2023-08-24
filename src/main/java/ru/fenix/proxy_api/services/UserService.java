package ru.fenix.proxy_api.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.fenix.proxy_api.dtos.CredentialsDto;
import ru.fenix.proxy_api.dtos.UserDto;
import ru.fenix.proxy_api.entities.UserEntity;
import ru.fenix.proxy_api.exceptions.AppException;
import ru.fenix.proxy_api.mappers.UserMapper;
import ru.fenix.proxy_api.repositories.UserRepository;

import java.nio.CharBuffer;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserDto login(CredentialsDto credentialDto) {
        UserEntity userEntity = userRepository.findByLogin(credentialDto.login())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialDto.password()), userEntity.getPassword())) {
            return  userMapper.toUserDto(userEntity);
        }

        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

}
