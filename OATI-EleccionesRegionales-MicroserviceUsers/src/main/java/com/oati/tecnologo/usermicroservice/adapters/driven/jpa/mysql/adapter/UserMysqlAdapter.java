package com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.exceptions.*;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.mappers.IClientEntityMapper;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.repositories.IClientRepository;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.repositories.IMemberRepository;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.repositories.IRoleRepository;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.repositories.IUserRepository;
import com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.mappers.IUserEntityMapper;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.QualificationRequestDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.request.UserAdminRequestDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response.ClienteCreateResponseDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response.MessageCodeResponseDto;
import com.oati.tecnologo.usermicroservice.adapters.driving.http.dto.response.PointsClientResponseDto;
import com.oati.tecnologo.usermicroservice.domain.model.Client;
import com.oati.tecnologo.usermicroservice.domain.model.User;
import com.oati.tecnologo.usermicroservice.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static com.oati.tecnologo.usermicroservice.configuration.Constants.*;


@RequiredArgsConstructor
@Transactional
public class UserMysqlAdapter implements IUserPersistencePort {


    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final IMemberRepository memberRepository;
    private final IClientRepository clientRepository;
    private final IUserEntityMapper userEntityMapper;
    private final IClientEntityMapper clientEntityMapper;



    @Override
    public UserEntity saveUserEmployee(User user) {

        if (!user.getRole().getId().equals(EMPLOYEE_ROLE_ID))
        {
            throw new RoleNotAllowedForCreationException();
        }
        if (userRepository.findByNumberDocument(user.getNumberDocument()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new MailAlreadyExistsException();
        }
        if (!roleRepository.findById(user.getRole().getId()).isPresent()){
            throw new RoleNotFoundException();
        }

        return userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public PointsClientResponseDto getPoints(String numberDocument) {
        Optional<ClientEntity> clientEntity = clientRepository.findByNumberDocument(numberDocument);
        if(!clientEntity.isPresent()){
            throw new ClientNotFoundException();
        }
        PointsClientResponseDto response = new PointsClientResponseDto(clientEntity.get().getPoints()+"","Puntos del cliente devueltos");
        return response;
    }


    @Override
    public User getUserByDocument(String numberDocument) {
        UserEntity userEntity = userRepository.findById(Long.parseLong(numberDocument)).orElseThrow(UserNotFoundException::new);
        return userEntityMapper.toUser(userEntity);
    }

    @Override
    public List<UserEntity> getAllUserAdmin() {
        return userRepository.findAllByRoleEntity(roleRepository.findById(ADMIN_ROLE_ID).get());
    }

    @Override
    public MemberEntity getMemberById(String numberDocument) {
        return memberRepository.findByNumberDocument(numberDocument).get();
    }

    @Override
    public User saveClient(User user) {
        UserEntity newClient = userEntityMapper.toEntity(user);
        newClient.setRoleEntity(roleRepository.findById(CLIENT_ROLE_ID).get());

        UserEntity client = userRepository.save(newClient);

        ClientEntity clientEntity = new ClientEntity(0L,client.getNumberDocument(), 0,0);
        clientRepository.save(clientEntity);

        return userEntityMapper.toUser(client);
    }

    @Override
    public MessageCodeResponseDto isExist(String numDocument) {
       MessageCodeResponseDto messageCodeResponseDto;
       if(userRepository.findByNumberDocument(numDocument).isPresent()){
           messageCodeResponseDto = new MessageCodeResponseDto("Sí existe compadre","1");
       }else{
           messageCodeResponseDto = new MessageCodeResponseDto("No existe compadre","0");
       }
        return messageCodeResponseDto;
    }

    @Override
    public ClienteCreateResponseDto saveAdmin(UserAdminRequestDto userAdminRequestDto) {
        User adminDto = new User();
        adminDto.setNumberDocument(userAdminRequestDto.getNumberDocument());
        adminDto.setName(userAdminRequestDto.getName());
        adminDto.setDateBirth(LocalDate.parse(userAdminRequestDto.getDateBirth(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        adminDto.setPhone(userAdminRequestDto.getPhone());
        adminDto.setEmail(userAdminRequestDto.getEmail());


        UserEntity newAdmin = userEntityMapper.toEntity(adminDto);
        newAdmin.setRoleEntity(roleRepository.findById(ADMIN_ROLE_ID).get());

        UserEntity admin = userRepository.save(newAdmin);

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNumberDocument(admin.getNumberDocument());
        memberEntity.setCodeEmployee(admin.getRoleEntity().getName()+admin.getNumberDocument()+"");
        memberEntity.setIdMultiplex(Long.parseLong(userAdminRequestDto.getIdMultiplex()));
        memberEntity.setDateContract(LocalDate.parse(userAdminRequestDto.getDateContract(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        memberEntity.setPassword(userAdminRequestDto.getPassword());
        memberEntity.setSalary(Integer.parseInt(userAdminRequestDto.getSalary()));

        memberRepository.save(memberEntity);

        return new ClienteCreateResponseDto( admin.getId()+"","Sí se creó el administrador");
    }

    @Override
    public User getUserById(long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);

        if (!userEntity.isPresent()){
            throw new UserNotFoundException();
        }

        return userEntityMapper.toUser(userEntity.get());
    }

    @Override
    public Client getClientByDocument(String document) {
        Optional<ClientEntity> clientEntity = clientRepository.findByNumberDocument(document);
        if(!clientEntity.isPresent()){
            throw new ClientNotFoundException();
        }
        return clientEntityMapper.toClient(clientEntity.get());
    }

    @Override
    public Client updateClient(Client client) {
        return clientEntityMapper.toClient(clientRepository.save(clientEntityMapper.toClientEntity(client)));
    }

    @Override
    public void updateRating(QualificationRequestDto qualificationRequestDto) {
        Optional<ClientEntity> clientEntity = clientRepository.findByNumberDocument(qualificationRequestDto.getNumberDocument());
        if(!clientEntity.isPresent()){
            throw new ClientNotFoundException();
        }
        if (clientEntity.get().getRatingCinepacho() == 0.0){
            clientEntity.get().setRatingCinepacho(Double.parseDouble(qualificationRequestDto.getQualificationService()));
        }else {
            throw new ClientCannotUpdateRaitingException();
        }
        clientRepository.save(clientEntity.get());
    }

}
