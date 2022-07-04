package task;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class Controller {

    @GetMapping("/test/{status}")
    public String testStatus(@PathVariable int status) {
        switch (status) {
            case 200:
                return HttpStatus.OK.getReasonPhrase();
            case 300:
                throw new ResponseStatusException(HttpStatus.MULTIPLE_CHOICES, HttpStatus.MULTIPLE_CHOICES.getReasonPhrase());
            case 400:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase());
            case 500:
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
        return "";
    }

}
