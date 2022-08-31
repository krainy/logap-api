var html = new XMLHttpRequest();
var url = "http://localhost:8080/api/sales/";

html.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
        var objs = JSON.parse(this.responseText);
        requestProcessing(objs)
    }
};
html.open("GET", url);
html.send();

function requestProcessing(jsonobjs) {
    var output = "";

    for (var i = 0; i < jsonobjs.length; i++) {         //for para processar e adicionar à saída o conteúdo de cada objeto (cada linha).
        output += '<li class=" table-line">'
        for (var j = 0; j < 5; j++) {                   //for para adicionar à saída o conteúdo de cada campo de cada objeto.
            switch (j) {
                case 0:     //caso onde preenche o campo de código do item.
                    output += '<div class="li-item"><p class="item">' + jsonobjs[i].i_code + '</p></div>'
                    break;
                case 1:     //caso onde preenche o campo de nome do item.
                    output += '<div class="li-item"><p class="item">' + jsonobjs[i].i_name + '</p></div>'
                    break;
                case 2:     //caso onde preenche o campo de tipo/categoria do item.
                    output += '<div class="li-item"><p class="item">' + jsonobjs[i].i_type + '</p></div>'
                    break;
                case 3:     //caso onde preenche o campo de valor do item.
                    output += '<div class="li-item"><p class="item">' + 'R$ ' + jsonobjs[i].i_value + '</p></div>'
                    break;
                case 4:     //caso onde preenche o campo de distribuidor do item.
                    output += '<div class="li-item"><p class="item">' + jsonobjs[i].i_dealer + '</p></div>'
                    break;
            }
        }
        output += '</li>'
    }

    document.getElementById("table-ul").innerHTML += output;        //imprime todos os dados recolhidos no HTML de uma vez

    //(pode ser problemático se houver muitos objetos, recomendável fazer algum limite de
    //solicitações por página ou um scroll)
}