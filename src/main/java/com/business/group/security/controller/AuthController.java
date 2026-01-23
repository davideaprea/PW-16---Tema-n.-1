package com.business.group.security.controller;

import com.business.group.security.doc.AuthControllerDocs;
import com.business.group.security.dto.UserCreateResponse;
import com.business.group.security.entity.User;
import com.business.group.shared.enumeration.Routes;
import com.business.group.security.dto.LoginCreateRequest;
import com.business.group.security.dto.UserCreateRequest;
import com.business.group.security.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(Routes.Auth.BASE)
public class AuthController implements AuthControllerDocs {
    private final AuthService authService;

    @PostMapping(Routes.Auth.REGISTER)
    public ResponseEntity<UserCreateResponse> register(@RequestBody @Valid UserCreateRequest dto) {
        User newUser = authService.register(dto);

        UserCreateResponse res = new UserCreateResponse(
                newUser.getId(),
                newUser.getEmail()
        );

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PostMapping(Routes.Auth.LOGIN)
    public ResponseEntity<Void> login(@RequestBody @Valid LoginCreateRequest dto) {
        String token = authService.login(dto);

        HttpHeaders headers = new HttpHeaders();

        headers.setBearerAuth(token);
        headers.setAccessControlExposeHeaders(List.of("Authorization"));

        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }
}
