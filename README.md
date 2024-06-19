# Carteira de Saude

> Sistematização da matéria de Programação Orientada a Objetos, do curso de ADS do CEUB. O projeto escolhido foi o A, o qual consistia em implementar uma API REST, com os métodos POST, GET, PUT e DELETE, e além de persistir os dados inseridos.

### Ajustes e melhorias

O projeto consegue receber uma chamada POST com os dados do funcionário no seguinte formato de um JSON:
```json
{
    "empregado": "Joao",
    "email": "joao@gmail.com",
    "telefone": [{
                    "telefone":"6188888888"
                }
                ],
    "alergia": [
                {
                    "alergia":"amendoim"
                }
                ],
    "problsaude":[
                {
                    "problsaude":"tendinite"
                },
                {
                    "problsaude":"rinite"
                }
                ]
}
```
Consegue atualizar os dados com um chamada PUT mas não consegue adicionar nem remover atributos dos campos alergia, telefone e problsaude. Apenas modifica os que existem. Um próximo passo seria adicionar e remover os atributos desses campos.

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

- Você instalou a versão mais recente do `<PostgreSQL / dBeaver (ou cliente SGBD a sua escolha) / Eclipse IDE />

- Você tem uma máquina `<Windows>`. 

## 🚀 Realizando setup

Para o projeto funcionar siga as etapas:

Windows:

- Atualize o arquivo <application.properties> de acordo com a sua configuração do banco de dados, realizada na hora na instalação.
- Seu banco de dados deve conter as seguintes relações e seus respectivos atributos:
  - empregados
     - id : primary key, do tipo serial, não nulo;
     - empregado: varchar;
     - email: varchar;
  - alergias
    - id_alergia: primary key, do tipo serial, não nulo;
    - alergia: varchar;
    - id_fk: foreign key, do tipo serial, com referencia ao empregados.id;
  - problemassaude
    - id_problsaude: primary key, do tipo serial, não nulo;
    - problsaude: varchar;
    - id_fk: foreign key, do tipo serial, com referencia ao empregados.id;
  - telefones
    - id_tel: primary key, do tipo serial, não nulo;
    - telefone: varchar;
    - id_fk: foreign key, do tipo serial, com referencia ao empregados.id;
   
  O diagrama ER deve ficar da seguinte forma:

![image](https://github.com/pedromfsantos/sistematizacaoPOO/assets/13856875/51b40ecc-2d09-41f1-be74-5d500b7e1938)

- No Eclipse, você precisa importar o projeto como um Exisiting Maven Projects.
- Tenha certeza de que o projeto contem todos arquivos, principalmente as depêndencias gerenciadas pelo Maven.

## ☕ Usando <nome_do_projeto>

Para usar siga estas etapas:

- Execute o projeto no Eclipse. Se a configuração padrão foi utilizado, ele deve estar no endereço local http://localhost:8080
- A página http://localhost:8080/empregados deve mostrar todos os empregados registrados na base de dados
- A página http://localhost:8080/empregados/{id} deve mostrar o empregado, selecionado pelo id, por exemplo http://localhost:8080/empregados/1 deve mostrar os dados do funcionário 1, se ele existir, caso contrário uma mensagem informando a não existência do empregado nos registros será fornecida.
- Utilizando o Postman, ou qualquer outro cliente REST disponível na internet, pode se realizar chamadas:
  - POST ao endereço http://localhost:8080/empregados: Ao passar como argumento o arquivo JSON no seguinte formato:
```json
{
    "empregado": "Nome",
    "email": "Nome@gmail.com",
    "telefone": [{
                    "telefone":"6188888888"
                }
                ],
    "alergia": [
                {
                    "alergia":"amendoim"
                }
                ],
    "problsaude":[
                {
                    "problsaude":"tendinite"
                },
                {
                    "problsaude":"rinite"
                }
                ]
}
```

     - Os campos telefone, alergia e problsaude são listas, portanto, seguindo o mesmo formato, podem variar em número. Poderíamos ter mais um telefone, no exemplo acima, adicionando mais um objeto {"telefone":"1212111"}, por exemplo.
 - PUT no endereço http://localhost:8080/empregados/{id}. Aqui deve-se ter cuidado, uma vez que, do existente registro, não se pode remover nem adicionar valores aos atributos telefone, alergia e problsaude, apenas modificar os que já existem. Se o id não existe, uma mensagem informado isso irá ser retornada.
 - DELETE no endereço http://localhost:8080/empregados/{id}. Basta apenas passar o endereço com o id para o cliente REST. Se o id não existe, uma mensagem informado isso irá ser retornada.
 - GET no endereço http://localhost:8080/empregados/{id}: Irá retornar o empregado, se ele existir.
 - GET no endereço http://localhost:8080/empregados. Irá retornar a lista de todos os empregados que existem.



## 📝 Licença

Esse projeto está sob licença. Veja o arquivo [LICENÇA](LICENSE.md) para mais detalhes.
