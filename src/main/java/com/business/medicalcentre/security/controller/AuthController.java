package com.business.medicalcentre.security.controller;

import com.business.medicalcentre.security.doc.AuthControllerDocs;
import com.business.medicalcentre.security.dto.RegisterResponse;
import com.business.medicalcentre.security.entity.User;
import com.business.medicalcentre.core.enumeration.Routes;
import com.business.medicalcentre.security.dto.LoginDto;
import com.business.medicalcentre.security.dto.RegisterDto;
import com.business.medicalcentre.security.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(Routes.AUTH)
public class AuthController implements AuthControllerDocs {
    private final AuthService authService;

    @PostMapping(Routes.REGISTER)
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid RegisterDto dto) {
        User newUser = authService.register(dto);

        RegisterResponse res = new RegisterResponse(
                newUser.getId(),
                newUser.getEmail()
        );

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PostMapping(Routes.LOGIN)
    public ResponseEntity<Void> login(@RequestBody @Valid LoginDto dto) {
        String token = authService.login(dto);

        HttpHeaders headers = new HttpHeaders();

        headers.setBearerAuth(token);

        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }
}
