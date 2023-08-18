package interfaces;

import in.fssa.knfunding.model.Request;
import java.util.Set;

public interface RequestInterface {

    Set<Request> findAll();

    Request findById(int id);

    void create(Request newRequest);

    void update(int id, Request updatedRequest);

    void delete(int id);

    

}
