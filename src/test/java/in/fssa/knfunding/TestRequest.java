package in.fssa.knfunding;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import in.fssa.knfunding.model.Request;
import in.fssa.knfunding.service.RequestService;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class TestRequest {

    @Test
    public void testCreateRequestWithValidInput() {
        RequestService requestService = new RequestService();

        Request newRequest = new Request();
        newRequest.setTitle("Sample Request");
        newRequest.setDescription("Test description");
        newRequest.setCategoryId(1);
        newRequest.setAmount(100);

        assertDoesNotThrow(() -> {
            requestService.createRequest(newRequest);
        });
    }

    @Test
    public void testCreateRequestWithTitleNull() {
        RequestService requestService = new RequestService();

        Request newRequest = new Request();
        newRequest.setTitle(null);
        newRequest.setDescription("Test description");
        newRequest.setCategoryId(1);
        newRequest.setAmount(100);

        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            requestService.createRequest(newRequest);
        });
        String expectedMessage = "Title cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(expectedMessage.equals(actualMessage));
    }


    @Test
    public void testCreateRequestWithTitleEmpty() {
        RequestService requestService = new RequestService();

        Request newRequest = new Request();
        newRequest.setTitle("  ");
        newRequest.setDescription("Test description");
        newRequest.setCategoryId(1);
        newRequest.setAmount(100);

        Exception exception = assertThrows(Exception.class, () -> {
            requestService.createRequest(newRequest);
        });
        String expectedMessage = "Title cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(expectedMessage.equals(actualMessage));
    }

    @Test
    public void testCreateRequestWithDescriptionNull() {
        RequestService requestService = new RequestService();

        Request newRequest = new Request();
        newRequest.setTitle("Sample Request");
        newRequest.setDescription(null); 
        newRequest.setCategoryId(1);
        newRequest.setAmount(100);

        Exception exception = assertThrows(Exception.class, () -> {
            requestService.createRequest(newRequest);
        });
        String expectedMessage = "Description cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(expectedMessage.equals(actualMessage));
    }

    @Test
    public void testCreateRequestWithDescriptionEmpty() {
        RequestService requestService = new RequestService();

        Request newRequest = new Request();
        newRequest.setTitle("Sample Request");
        newRequest.setDescription("  "); 
        newRequest.setCategoryId(1);
        newRequest.setAmount(100);

        Exception exception = assertThrows(Exception.class, () -> {
            requestService.createRequest(newRequest);
        });
        String expectedMessage = "Description cannot be null or empty";
        String actualMessage = exception.getMessage();

        assertTrue(expectedMessage.equals(actualMessage));
    }
    
    @Test
    public void testCreateRequestWithNegativeAmount() {
        RequestService requestService = new RequestService();

        Request newRequest = new Request();
        newRequest.setTitle("Sample Request");
        newRequest.setDescription("Test description");
        newRequest.setCategoryId(1);
        newRequest.setAmount(-100); 

        Exception exception = assertThrows(Exception.class, () -> {
            requestService.createRequest(newRequest);
        });
        String expectedMessage = "Amount must be a positive value";
        String actualMessage = exception.getMessage();

        assertTrue(expectedMessage.equals(actualMessage));
    }
    @Test
    public void testCreateRequestWithZeroAmount() {
        RequestService requestService = new RequestService();

        Request newRequest = new Request();
        newRequest.setTitle("Sample Request");
        newRequest.setDescription("Test description");
        newRequest.setCategoryId(1);
        newRequest.setAmount(0); 

        Exception exception = assertThrows(Exception.class, () -> {
            requestService.createRequest(newRequest);
        });
        String expectedMessage = "Amount must be a positive value";
        String actualMessage = exception.getMessage();

        assertTrue(expectedMessage.equals(actualMessage));
    }

    @Test
    public void testCreateRequestWithInvalidCategory() {
        RequestService requestService = new RequestService();

        Request newRequest = new Request();
        newRequest.setTitle("Invalid Category Request");
        newRequest.setDescription("Request with an invalid category");
        newRequest.setCategoryId(-1); 
        newRequest.setAmount(500);

        Exception exception = assertThrows(Exception.class, () -> {
            requestService.createRequest(newRequest);
        });
        String expectedMessage = "Invalid category ID";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    //UPDATE

    
    @Test
    public void testUpdateRequestWithValidInput() {
        RequestService requestService = new RequestService();

        Request existingRequest = new Request();
        existingRequest.setTitle("Existing Request");
        existingRequest.setDescription("Existing request description");
        existingRequest.setCategoryId(1);
        existingRequest.setAmount(1000);

        assertDoesNotThrow(() -> {
            requestService.updateRequest(2,existingRequest);
        });
    }

    @Test
    public void testUpdateRequestWithValidTitle() {
        RequestService requestService = new RequestService();

        Request updatedRequest = new Request();
        updatedRequest.setTitle("Updated Request Title");
        updatedRequest.setDescription("Existing request description");
        updatedRequest.setCategoryId(1);
        updatedRequest.setAmount(1000);

        assertDoesNotThrow(() -> {
            requestService.updateRequest(2, updatedRequest);
        });
    }

    @Test
    public void testUpdateRequestWithValidInputAndNegativeAmount() {
        RequestService requestService = new RequestService();

        Request updatedRequest = new Request();
        updatedRequest.setTitle("Updated Request");
        updatedRequest.setDescription("Updated request description");
        updatedRequest.setCategoryId(1);
        updatedRequest.setAmount(-500); // Negative amount

        Exception exception = assertThrows(Exception.class, () -> {
            requestService.updateRequest(1, updatedRequest);
        });

        String expectedMessage = "Amount must be a positive value";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testUpdateRequestWithValidInputAndZeroAmount() {
        RequestService requestService = new RequestService();

        Request existingRequest = new Request();
        existingRequest.setId(1);
        existingRequest.setTitle("Existing Request");
        existingRequest.setDescription("Existing request description");
        existingRequest.setCategoryId(1);
        existingRequest.setAmount(1000);

        assertDoesNotThrow(() -> {
            requestService.createRequest(existingRequest);
        });

        Request updatedRequest = new Request();
        updatedRequest.setId(1);
        updatedRequest.setTitle("Updated Request");
        updatedRequest.setDescription("Updated request description");
        updatedRequest.setCategoryId(1);
        updatedRequest.setAmount(0); 
        Exception exception = assertThrows(Exception.class, () -> {
            requestService.updateRequest(existingRequest.getId(), updatedRequest);
        });
        String expectedMessage = "Amount must be a positive value";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    
    @Test
    public void testDeleteExistingRequest() {
        RequestService requestService = new RequestService();

        Request newRequest = new Request();
        newRequest.setTitle("Test Request");
        newRequest.setDescription("Test request description");
        newRequest.setCategoryId(1);
        newRequest.setAmount(500);

        assertDoesNotThrow(() -> {
            requestService.createRequest(newRequest);
        });

        assertDoesNotThrow(() -> {
            requestService.deleteRequest(1);
        });

        Request deletedRequest = requestService.findById(newRequest.getId());
        assertTrue(deletedRequest == null);
    }

    @Test
    public void testDeleteNonExistingRequest() {
        RequestService requestService = new RequestService();

        Exception exception = assertThrows(RuntimeException.class, () -> {
            requestService.deleteRequest(999785); 
        });
        String expectedMessage = "Request not found.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

  

    @Test
    public void testListAllRequests() {
        RequestService requestService = new RequestService();
 
        assertDoesNotThrow(() -> {
        	 Set<Request> allRequests = requestService.getAllRequests();
        });

    }

    
    
    @Test
    public void testListRequestsByCategoryId() {
        RequestService requestService = new RequestService();

  
        assertDoesNotThrow(() -> {
        	Set<Request> requestsWithCategoryId1 = requestService.getRequestsByCategoryId(1);
       });

    }

   
    
    
    
    
    
    
    
    
    
    
}
