package com.oati.tecnologo.usermicroservice.domain.api;

import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.oati.tecnologo.usermicroservice.domain.model.User;

public interface IUserServicePort {
    User getUserByDocument (String numberDocument);
    UserEntity saveUserCandidate (User user);

}
