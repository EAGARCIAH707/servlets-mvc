/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andevs.crudmvc.model.dao.login;

import com.andevs.crudmvc.model.LoginDto;
import com.andevs.crudmvc.model.repository.AlumnoRepository;
import com.andevs.crudmvc.model.repository.IAlumnoRepository;

/**
 * @author lenovo
 */
public class LoginDao implements ILoginDao {

    private final IAlumnoRepository alumnoRepository;

    public LoginDao(IAlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public LoginDao() {
        this.alumnoRepository = new AlumnoRepository();
    }

    public Boolean login(String username, String password) {
        try {
            LoginDto loginDto = new LoginDto(username, password);
            return alumnoRepository.login(loginDto);
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

}
