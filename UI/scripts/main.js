function doGet(url) {
    let request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send();
    return request.responseText;
}

function createLine(variable) {
    
}

function main() {
    let url = "";
    let variable = doGet(url);
    console.log();
    
}
