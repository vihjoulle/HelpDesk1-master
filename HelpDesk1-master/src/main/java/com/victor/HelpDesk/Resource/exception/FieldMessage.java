package com.victor.HelpDesk.Resource.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable //Esta linha declara a classe FieldMessage, que implementa a interface Serializable.

{
    private static final long serialVersionUID =  1L; //Esta linha declara uma constante serialVersionUID, que é usado para garantir a compatibilidade da serialização.


    //Estas linhas declaram dois atributos privados: fieldName, que armazena o nome do campo relacionado ao erro, e message, que armazena a mensagem de erro.
    private String fieldName;
    private String message;

    public FieldMessage(){ ////Este é o construtor padrão da classe FieldMessage, que não recebe argumentos e não faz nada além de chamar o construtor da classe pai.
        super();
    }

    //Este é um construtor da classe FieldMessage que recebe dois argumentos: fieldName (nome do campo) e message (mensagem de erro). Ele inicializa os atributos correspondentes com os valores recebidos.
    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    //Estes são métodos para acessar e definir o valor do atributo fieldName.
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    //Estes são métodos para acessar e definir o valor do atributo message.

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
