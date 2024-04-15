package com.victor.HelpDesk.domain.DTO;

public class CredenciaisDTO //Esta linha define a declaração da classe CredenciaisDTO. Esta classe é usada para
// representar as credenciais de um usuário, como email e senha.
{

    //Estas duas linhas declaram duas variáveis de instância privadas (email e senha)
    // da classe CredenciaisDTO, que armazenam o email e a senha do usuário.
    private String email;
    private String senha;

    public String getEmail() {
        return email;
    } //Este método é um getter para obter o valor do email.

    public void setEmail(String email) {
        this.email = email;
    } //Este método é um setter para definir o valor do email.

    public String getSenha() {
        return senha;
    } //Este método é um getter para obter o valor da senha.

    public void setSenha(String senha) {
        this.senha = senha;
    } //Este método é um setter para definir o valor da senha.
}
