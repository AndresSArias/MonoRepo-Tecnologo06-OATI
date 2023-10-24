package com.oati.tecnologo.usermicroservice.domain.spi;

import com.oati.tecnologo.usermicroservice.domain.model.User;

public interface IUserPersistencePort {

    User getUserByDocument(String numberDocument);

    User saveClient (User user);

    User getUserById (long id);


}
