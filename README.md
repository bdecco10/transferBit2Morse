# transferBit2Morse
Projeto piloto que converte mensagem BIT em código Morse e de Morse para texto

# Arquitetura

 - O projeto se divide em duas camadas
 - 1) ResourceMorseSchemas
 - 2) ResourceMorseBusiness

# Estrutura atual
 - 1) ResourceMorseSchemas  (.pom) = Responsavel pelas interfaces
     1.1 - ResourceMorseSchemas (.jar)
 - 2) ResourceMorseBusiness (.pom) = Responsavel pela camada SOAP/REST
     2.1 - ResourceMorseBusiness-api (.jar)
     2.2 - ResourceMorseBusiness-core (.jar)

# Estrutura ideal (Faltou Tempo)
 - 1) ResourceMorseSchemas  (.pom) = Responsavel pelas interfaces
     1.1 - ResourceMorseSchemas (.jar)
 - 2) ResourceMorseBusiness (.pom)  = Responsavel pela camada SOAP
     2.1 - ResourceMorseBusiness-api (.jar)
     2.2 - ResourceMorseBusiness-core (.jar)
 - 3) ResourceMorseTranslateBusiness (.pom) = Responsavel pela camada REST
     3.1 - ResourceMorseTranslateBusiness-api (.jar)
     3.2 - ResourceMorseTranslateBusiness-core (.jar)

# Build
 - 1) project-parent
 - 2) ResourceMorseSchemas
 - 3) ResourceMorseBusiness
  
   Na raiz do "project-parent" executar o comando "mvn clean install"
   
# Framework
 - 1) spring-boot
 - 2) cxf
 - 3) hystrix
 
  
# Funcionalidade
  A primeira "ResourceMorseSchemas" se trata da interface (payload) do projeto, sendo responsável por prover as mesmas aos apps, no exemplo temos apenas um app utilizando, por se tratar de uma POC, mas é evidente que "N" aplicações se conversem internamente e a mesma seria utilizada. 
  Inicialmente existe dois tipos de interface, a primeira se trata de uma interface SOAP, gerada a partir de um arquivo "Morse.xsd" com o intuito de expor para qualquer barramento ou serviço externo que tenha a necessidade de consumir essa API, a segunda se trata de uma interface interna REST "ResourceMorseEntity" com o intuito de navegar por todas as camadas internas do projeto, facilitando a manutenção futura, visto que sempre será alterada em um local.
  A segunda "ResourceMorseBusiness" se trata definitivamente do negócio proposto, onde contempla toda a regra.
  A mesma é dividida em 2 camadas                                                                                                                                         - "ResourceMorseBusiness-api" Essa camada contempla somente a parte que expõe meus serviços, não existe regra alguma nessa camada, apenas a exibição do SOAP e  do REST.                                                                                                                                                                   - "ResourceMorseBusiness-core" Essa camada contempla definitivamente o core, onde é aplicável toda a regra de negócio.
  # OBS:Devida a correria do dia dia nao tive tempo de implementar em uma estrutura mais adequada, pois a ideia seria existir 3 camadas, e a última delas seria só responsável pela parte REST, isolada totalmente da camada se SOAP, mas como disse, não tive tempo hábil pra isso. Sendo que tanto a REST quanto a SOAP se encontram dentro da segunda camada.
  
 # Processo
   Como funciona: A camada "ResourceMorseBusiness-api" possui a classe "MorseResource" responsável por expor o serviço SOAP, a mesma tem como responsabilidade receber a informação e converter para a interface interna "ResourceMorseEntity" para poder manipular os dados entre as camadas internas,  por exemplo chamar a camada "ResourceMorseBusiness-core". A core é a responsável por tratar a necessidade do negócio. Porém nesse cenário que existe, a mesma monta de forma dinâmica a URL para chamar os serviços REST definidas na camada de api, a classe "CallService" localizada no "core" é a responsável por montar as URLs internas para executar os serviços.
   Essa classe executa a chamada via API REST utilizando um framework chamado Hystrix, o mesmo tem como objetivo tratar de uma forma async a API, passando como configuração diversos parâmetros, como retentativas de chamadas, tempo de espera,entre outros e conta também com uma implementação de fallback caso ocorrer algum erro nessa solicitação ou de timeout ou API fora, o mesmo é tratado e passado pra frente. Com isso o uso dessa classe "OSSBusinessException" é necessário, porque é padronizado o retorno de erro subindo ate o sistem que fez a solicitação!. Esse classe se encontra em um .jar apartado pq tb pode ser usado em todas as aplicações internas, padronizando o retorno de erro!.
  # OBS:Ressaltando mais uma vez deveria existir 3 camadas, porém a falta de tempo não consegui concluir.    
   
