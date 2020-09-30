/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andevs.crudmvc.model.dao.login;

/**
 * @author lenovo
 */
public interface ILoginDao {

    Boolean login(String username, String password);
}
