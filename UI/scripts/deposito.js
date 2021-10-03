function doPost(url,body) {
    let request = new XMLHttpRequest()
    request.open("POST", url, true)
    request.setRequestHeader("Content-type", "application/json")
    request.send(JSON.stringify(body))
    request.onload = function() {
        
        let items = JSON.parse(this.responseText);
        let table = document.getElementById("") 
        line = document.createElement("tr");
        tdValor = document.createElement("td");
        tdValor.innerHTML = items;
    }

    return request.responseText 
}

function depositar() {
    event.preventDefault();   

    let nconta = document.getElementById("nconta");
    let deposito = document.getElementById("deposito");
    //put endpoint here
    let url = "url/movimentacao/deposito/"+nconta;

    body = {
        "valorDeposito": deposito
    }

    doPost(url,body)
}
