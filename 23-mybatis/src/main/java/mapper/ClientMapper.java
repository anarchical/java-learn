package mapper;

import entity.Client;

import java.util.List;

/**
 * @author YeYaqiao
 */
public interface ClientMapper {

    Client findById(int id);

    List<Client> findAll();

    void save(Client client);

    void deleteById(int id);

    void update(Client client);
}
