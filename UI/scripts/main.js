//Examplo para as demais integrações com o back

function doGet(url) {
    let request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send();
    return request.responseText;
}

function createLine(element) {
    line = document.createElement("tr");
    tdId = document.createElement("td");
    tdVariable1 = document.createElement("td");
    tdVariable2 = document.createElement("td");
    tdId.innerHTML = element.id
    tdVariable1.innerHTML = element.variable1
    tdVariable2.innerHTML = element.variable2

    line.appendChild(tdId);
    line.appendChild(tdVariable1);
    line.appendChild(tdVariable2)

    return line;
}

function main() {
    //put the endpoint here
    let url = "";
    let data = doGet(url);
    let items = JSON.parse(data);
    let table = document.getElementById("") 
    items.forEach(element => {
        let line = createLine(element);
        table.appendChild(line);
    });
    
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

function doSomething(params) {
    preventDefault();   
    //put endpoint here
    let url = "";
    let variable1 = document.getElementById("var1");
    let variable2 = document.getElementById("var2");

    body = {
        "var1": variable1,
        "var2": variable2
    }

    doPost(url,body)
}

main()
