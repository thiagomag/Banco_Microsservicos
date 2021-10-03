function createLine(element) {
    line = document.createElement("tr");
    tdConta = document.createElement("td");
    tdCelular = document.createElement("td");
    tdOperadora = document.createElement("td");
    tdValor = document.createElement("td");

    tdConta.innerHTML = element.numeroConta;
    tdCelular.innerHTML = element.numeroCel;
    tdOperadora.innerHTML = element.operadora;
    tdValor.innerHTML = element.valor;

    line.appendChild(tdConta);
    line.appendChild(tdCelular);
    line.appendChild(tdOperadora);
    line.appendChild(tdValor);

    return line;
}

function doPost(url,body) {
    let request = new XMLHttpRequest()
    request.open("POST", url, true)
    request.setRequestHeader("Content-type", "application/json")
    request.send(JSON.stringify(body))
    request.onload = function() {
        
        let items = JSON.parse(this.responseText);
        let table = document.getElementById("") 
        items.forEach(element => {
            let line = createLine(element);
            table.appendChild(line);
        });
    }

    return request.responseText 
}

function recarga() {
    event.preventDefault();   

    let nconta = document.getElementById("nconta");
    let celular = document.getElementById("celular");
    let operadora = document.getElementById("operadora");
    let recarga = document.getElementById("recarga");
    //put endpoint here
    let url = "url/recarga/celular";

    body = {
        "numeroConta": nconta,
        "numeroCel": celular,
        "operadora": operadora,
        "valor": recarga
    }

    doPost(url,body)
}
