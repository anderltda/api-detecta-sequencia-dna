Para executar a api siga os seguintes passos:
=======================

1. Abra um terminal window/command prompt
2. Clona o projeto.
3. `cd api-detecta-sequencia-dna` 
4. `mvn clean install`

Todas as dependências devem ser baixadas 

### O que devo fazer?

- Após o build do projeto, já estará apto para roda a api.
- Mas antes, siga os seguintes passos:

1. Abra o diretorio target
2. Execute o seguinte comando

        java -jar api-detecta-sequencia-dna-1.0.0.jar s
        
- -DproxyEnabled=true
- -DproxyHost=localhost
- -DproxyPort=8080
- -DproxyUsername=fred
- -DproxyPassword=Password123

If the tests fail screenshots will be saved in ${project.basedir}/target/screenshots

If you need to force a binary overwrite you can do:

- -Doverwrite.binaries=true

### It's not working!!!

You have probably got outdated driver binaries, by default they are not overwritten if they already exist to speed things up.  You have two options:

- `mvn clean verify -Doverwrite.binaries=true`
- Delete the `selenium_standalone_binaries` folder in your resources directory
