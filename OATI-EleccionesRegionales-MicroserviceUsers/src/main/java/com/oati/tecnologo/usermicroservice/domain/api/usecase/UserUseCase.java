package com.oati.tecnologo.usermicroservice.domain.api.usecase;

import com.oati.tecnologo.usermicroservice.domain.exceptions.PhoneLenghtException;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.mappers.IUserEntityMapper;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.QualificationRequestDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.UserAdminRequestDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response.AdminResponseDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response.ClienteCreateResponseDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response.MessageCodeResponseDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response.PointsClientResponseDto;
import com.oati.tecnologo.usermicroservice.domain.api.IUserServicePort;
import com.oati.tecnologo.usermicroservice.domain.model.Client;
import com.oati.tecnologo.usermicroservice.domain.model.User;
import com.oati.tecnologo.usermicroservice.domain.spi.IRolePersistencePort;
import com.oati.tecnologo.usermicroservice.domain.spi.IUserPersistencePort;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;
    private final IRolePersistencePort rolePersistencePort;
    private final IUserEntityMapper userEntityMapper;

    private final PasswordEncoder passwordEncoder;

    public UserUseCase(IUserPersistencePort userPersistencePort, IRolePersistencePort rolePersistencePort, IUserEntityMapper userEntityMapper,PasswordEncoder passwordEncoder) {
        this.userPersistencePort = userPersistencePort;
        this.rolePersistencePort = rolePersistencePort;
        this.userEntityMapper = userEntityMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void updateRating(QualificationRequestDto qualificationRequestDto) {
        userPersistencePort.updateRating(qualificationRequestDto);
    }

    @Override
    public User getUserByDocument(String numberDocument) {
        return userPersistencePort.getUserByDocument(numberDocument);
    }

    @Override
    public List<AdminResponseDto> getAllAdmins() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<AdminResponseDto> adminResponseDtos = new ArrayList<>();

        List<UserEntity> userEntities = userPersistencePort.getAllUserAdmin();
        List<MemberEntity> memberEntities = new ArrayList<>();
        for (int i = 0; i < userEntities.size(); i++){
            memberEntities.add(userPersistencePort.getMemberById(userEntities.get(i).getNumberDocument()));
            adminResponseDtos.add(new AdminResponseDto(userEntities.get(i).getId()+"",
                    userEntities.get(i).getNumberDocument(),
                    userEntities.get(i).getName(),
                    userEntities.get(i).getDateBirth().format(formatter),
                    userEntities.get(i).getPhone(),
                    userEntities.get(i).getEmail(),
                    memberEntities.get(i).getCodeEmployee(),
                    memberEntities.get(i).getSalary()+"",
                    memberEntities.get(i).getDateContract().format(formatter),
                    memberEntities.get(i).getIdMultiplex()+""));
        }

        return adminResponseDtos;
    }

    @Override
    public User saveClient(User user) {
        if (!validatePhone(user)){
            throw new PhoneLenghtException();
        }
        return userPersistencePort.saveClient(user);
    }

    @Override
    public MessageCodeResponseDto isExist(String numDocument) {
        return userPersistencePort.isExist(numDocument);
    }

    @Override
    public ClienteCreateResponseDto saveAdmin(UserAdminRequestDto userAdminRequestDto) {
        User userPhone= new User();
        userPhone.setPhone(userAdminRequestDto.getPhone());
        if (!validatePhone(userPhone)){
            throw new PhoneLenghtException();
        }
        userAdminRequestDto.setPassword(passwordEncoder.encode(userAdminRequestDto.getPassword()));
        return userPersistencePort.saveAdmin(userAdminRequestDto);
    }

    @Override
    public Client updatePoints(Long id, int points) {
        User user = userPersistencePort.getUserById (id);

        Client updateClient = userPersistencePort.getClientByDocument(user.getNumberDocument());

        updateClient.setPoints(updateClient.getPoints()+points);

        return userPersistencePort.updateClient(updateClient);
    }

    @Override
    public PointsClientResponseDto getPoints(String numberDocument) {
        return userPersistencePort.getPoints(numberDocument);
    }

    public boolean validatePhone(User user) {
        String[] phoneComponents = user.getPhone().split(" ");
        user.setPhone("");

        int lenghtPhone = 0;
        for (int i = 0; i  < phoneComponents.length; i++){
            lenghtPhone = lenghtPhone + phoneComponents[i].length();
            user.setPhone(user.getPhone()+phoneComponents[i]);
        }

        return lenghtPhone <= 13;
    }

    public boolean validateAge(LocalDate dateBirth) {
        LocalDate dateNow = LocalDate.now();
        long age =  dateBirth.until(dateNow, ChronoUnit.YEARS);

        return age >= 18l ;
    }
    public Map<String, String> getHeaders(String token) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", token);
        return  headers;
    }
}
