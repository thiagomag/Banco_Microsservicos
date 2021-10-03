function createLine(element) {
    line = document.createElement("tr");
    tdNome = document.createElement("td");
    tdEmail = document.createElement("td");
    tdData = document.createElement("td");
    tdCep = document.createElement("td");
    tdTipoEndereco = document.createElement("td");

    tdNome.innerHTML = element.email;
    tdData.innerHTML = element.dataNascimento;
    tdCep.innerHTML = element.cep;
    tdTipoEndereco.innerHTML = element.tipoendereco;

    line.appendChild(tdNome);
    line.appendChild(tdData);
    line.appendChild(tdCep);
    line.appendChild(tdTipoEndereco);

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

function cadastrarCliente() {
    event.preventDefault();   
    
    let doc = document.getElementById("doc");
    let nome = document.getElementById("nome");
    let email = document.getElementById("email");
    let data = document.getElementById("data");
    let cep = document.getElementById("cep")
    let tipoendereco = document.getElementById("tipo");

    let tipoconta = "ClientePF";

    if (document.getElementById("tipocontapf").checked == true) {
        tipoconta = "ClientePF";
        body = {
            "cpf": doc,
            "nome": nome,
            "email": email,
            "dataNascimento": data,
            "enderecoDtoList": [
                EnderecoDto = {
                    "cep": cep,
                    "tipoEndereco": tipoendereco
                }
            ]
        }
    }
    if (document.getElementById("tipocontapj").checked == true) {
        tipoconta = "ClientePJ";  
        body = {
            "cpf": doc,
            "nome": nome,
            "email": email,
            "dataNascimento": data,
            "enderecoDtoList": [
                EnderecoDto = {
                    "cep": cep,
                    "tipoEndereco": tipoendereco
                }
            ]
        }      
    }

    //put endpoint here
    let url = "url/clientes/"+tipoconta;

    doPost(url,body)
}
