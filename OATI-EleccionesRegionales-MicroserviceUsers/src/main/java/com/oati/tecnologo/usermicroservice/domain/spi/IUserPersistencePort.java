package com.oati.tecnologo.usermicroservice.domain.spi;

import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.oati.tecnologo.usermicroservice.domain.model.User;

public interface IUserPersistencePort {

    User getUserByDocument(String numberDocument);

    UserEntity saveUser (User user);

    User getUserById (long id);


}
