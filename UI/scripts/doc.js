function createLine(element) {
    line = document.createElement("tr");
    tdConta = document.createElement("td");
    tdDestino = document.createElement("td");
    tdAgencia = document.createElement("td");
    tdValor = document.createElement("td");

    tdConta.innerHTML = element.numeroConta;
    tdDestino.innerHTML = element.contaDestino;
    tdAgencia.innerHTML = element.agenciaDestino;
    tdValor.innerHTML = element.valor;

    line.appendChild(tdConta);
    line.appendChild(tdDestino);
    line.appendChild(tdAgencia);
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

function transferir() {
    event.preventDefault();   

    let nconta = document.getElementById("nconta");
    let ncontadestino = document.getElementById("ncontadestino");
    let agencia = document.getElementById("agencia");
    let valor = document.getElementById("valor");
    //put endpoint here
    let url = "url/doc/realizarDoc";

    body = {
        "numeroConta": nconta,
        "contaDestino": ncontadestino,
        "agenciaDestino": agencia,
        "valor": valor
    }

    doPost(url,body)
}
