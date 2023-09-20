package interfaces;

import in.fssa.knfunding.model.Request;


import java.util.List;

public interface RequestInterface {

    List<Request> findAll();
    
    List<Request> findByUserId();

    Request findById(int id);

    void create(Request newRequest);

    void update(int id, Request updatedRequest);

    void delete(int id);
    

    

}
