package mk.ukim.finki.wp2024.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ShopingCartNotFoundException extends RuntimeException{

public ShopingCartNotFoundException(Long id){
    super(String.format("SHoping cart not found with id%s",id));
}
}
