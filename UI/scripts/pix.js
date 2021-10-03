function createLine(element) {
    line = document.createElement("tr");
    tdConta = document.createElement("td");
    tdChave = document.createElement("td");
    tdValor = document.createElement("td");

    tdConta.innerHTML = element.numeroConta;
    tdChave.innerHTML = element.chavePix
    tdValor.innerHTML = element.valor;

    line.appendChild(tdConta);
    line.appendChild(tdChave);
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
    let chave = document.getElementById("chave");
    let valor = document.getElementById("valor");
    //put endpoint here
    let url = "url/pix/realizarPix";

    body = {
        "numeroConta": nconta,
        "chavePix": chave,
        "valor": valor
    }

    doPost(url,body)
}
