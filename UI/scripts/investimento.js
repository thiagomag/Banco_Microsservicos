function createLine(element) {
    line = document.createElement("tr");
    tdConta = document.createElement("td");
    tdValor = document.createElement("td");
    tdRendimento = document.createElement("td");

    tdConta.innerHTML = element.numeroConta;
    tdValor.innerHTML = element.valorInvestido;
    tdRendimento.innerHTML = element.rendimento

    line.appendChild(tdConta);
    line.appendChild(tdValor);
    line.appendChild(tdRendimento);

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

function investir() {
    event.preventDefault();   

    let nconta = document.getElementById("nconta");
    let valor = document.getElementById("valor");
    let rendimento = 0.01;
    if(document.getElementById("rendimento1").checked == true) {
        rendimento = 0.01;
    }
    if(document.getElementById("rendimento10").checked == true) {
        rendimento = 0.1;
    }
    //put endpoint here
    let url = "url/investimento";

    body = {
        "numeroConta": nconta,
        "valorInvestido": valor,
        "rendimento": rendimento
    }

    doPost(url,body)
}
