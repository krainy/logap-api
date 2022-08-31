var html = new XMLHttpRequest();
var url = "http://localhost:8080/api/sales/saveItem";

class newItem {
    constructor(id, name, type, value, dealer) {
        this.i_code = id;
        this.i_name = name;
        this.i_type = type;
        this.i_value = value;
        this.dealer = dealer;
    }


}

function submitPostRequest() {
    const i_id = document.getElementById("id").value;
    const i_name = document.getElementById("name").value;
    const i_type = document.getElementById("type").value;
    const i_value = document.getElementById("value").value;
    const i_dealer = document.getElementById("dealer").value;

    html.open("POST", url);
    // html.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    if (html.readyState == 4 && html.status == 200) {
        console.log(html.responseText);
    }

    html.send('i_code=i_id&i_name=i_name&i_type=i_type&i_value=i_value&i_dealer=i_dealer');
}