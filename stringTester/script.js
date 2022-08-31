
//Quando o usuário clicar no botão, a função submit será chamada e então todo o processo abaixo ocorrerá:

function submit() {
    getObject("http://localhost:8080/api/stringTest/" + document.getElementById("txt-input").value,
        function (e, data) {
            if (e !== null) {
                if (e === 500) {

                    //Caso não exista um caso que passe no teste da string, um erro do tipo 500 vai ativar essa saída e o texto 
                    //vai explicar que não existe esse caso.

                    document.getElementById("text").innerHTML = "Não foi possível encontrar o primeiro caractere Vogal, " +
                        "após uma consoante, onde a mesma é antecessora a uma vogal e " +
                        "que não se repita na string.";

                } else {

                    //Caso qualquer outro de envio/recebmento de dados erro seja captado, um alerta será disparado na página.

                    alert('Error: ' + e);
                }
            } else {

                //Se tudo ocorrer bem, o resultado aparecerá na página.

                document.getElementById("text").innerHTML = "Resultado: " + data.vogal;
            }
        });
}

function getObject(url, callback) {
    var http = new XMLHttpRequest();

    http.open("GET", url);
    http.responseType = 'json';         //Ação para especificar para o http o tipo da resposta XML

    http.onload = function () {
        if (http.status === 200) {
            callback(null, http.response);          //Dependendo do status da solicitação http, pode ser chamado o primeiro caso, onde nenhum erro é encontrado, 
        } else {
            callback(http.status, http.response);   //ou pode ser chamado o segundo caso, onde um erro na requisição é encontrado e enviado para o alerta
        }

    };

    http.send();

}