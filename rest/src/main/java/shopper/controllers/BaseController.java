package shopper.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.HttpClientErrorException;

@CrossOrigin
public class BaseController {
    public void throw404(){
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }
}
