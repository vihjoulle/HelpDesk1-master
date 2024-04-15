package com.victor.HelpDesk.Resource.exception;

import com.victor.HelpDesk.Service.Exceptions.ObjectnotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //Esta anotação indica que a classe é um componente global para tratamento de exceções em todos os controladores.
public class ResourceExceptionHandler //Esta linha declara a classe ResourceExceptionHandler.
{



    //Este método é responsável por tratar exceções do tipo ObjectnotFoundException. Ele recebe como argumentos a exceção lançada e o HttpServletRequest.
    @ExceptionHandler(ObjectnotFoundException.class)
    public ResponseEntity<StandardError>objectnotFoundException(ObjectnotFoundException ex,
     HttpServletRequest request) {

     //Aqui é criado um objeto StandardError com as informações relevantes sobre o erro (timestamp, status, error, message e path). Em seguida, é retornado um ResponseEntity com o status HTTP NOT_FOUND e o corpo contendo o erro.

        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Object Not Found", ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }



    @ExceptionHandler(DataIntegrityViolationException.class) //Este método trata exceções do tipo DataIntegrityViolationException.

    //Aqui é criado um objeto StandardError para lidar com a exceção de violação de integridade de dados. É retornado um ResponseEntity com o status HTTP BAD_REQUEST e o corpo contendo o erro.

    public ResponseEntity<StandardError>DataIntegrityViolationException(DataIntegrityViolationException ex,
     HttpServletRequest request) {

        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Violação de dados" , ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) //Este método trata exceções do tipo MethodArgumentNotValidException.

    public ResponseEntity<StandardError>validationErrors(MethodArgumentNotValidException ex,
     HttpServletRequest request) {

     //Um objeto ValidationError é criado para lidar com erros de validação de campos. Ele contém o timestamp, o status HTTP, a mensagem de erro e o caminho do request.

       ValidationError errors = new  ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),"Erro na Validação do Campos","Validation error",
      request.getRequestURL());

       //Este loop percorre todos os erros de campo gerados pela exceção MethodArgumentNotValidException e os adiciona ao objeto ValidationError.

       for (FieldError x : ex.getBindingResult().getFieldErrors()) {
           errors.addError(x.getField(), x.getDefaultMessage());
       }

       //Finalmente, é retornado um ResponseEntity com o status HTTP BAD_REQUEST e o corpo contendo os erros de validação.

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}