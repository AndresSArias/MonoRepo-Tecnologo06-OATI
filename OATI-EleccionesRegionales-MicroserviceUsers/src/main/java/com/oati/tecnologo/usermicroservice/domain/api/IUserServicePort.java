package com.oati.tecnologo.usermicroservice.domain.api;

import com.oati.tecnologo.usermicroservice.domain.model.User;

public interface IUserServicePort {
    User getUserByDocument (String numberDocument);
    User saveClient (User user);

}
