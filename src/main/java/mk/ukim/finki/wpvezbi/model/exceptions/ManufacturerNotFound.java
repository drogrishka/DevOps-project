package mk.ukim.finki.wpvezbi.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class ManufacturerNotFound extends RuntimeException{
    public ManufacturerNotFound(Long id){
        super(String.format("Manufacturer with id %d not found,",id));
    }
}
