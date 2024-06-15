const list = document.getElementById('lista');

function listar() {
    fetch('http://172.22.240.1:8080/agenda')
.then(response => response.json())
.then(json => {

    json.map((jsons, index) => {
        list.innerHTML += `<p>${jsons.nome} ${jsons.telefone} ${jsons.id}</p> `;
        const button = document.createElement('button');
        button.textContent = 'Deletar';
        button.setAttribute("onclick", `deletar(${jsons.id})`);
    
        // Adicionar o botão à lista
        list.appendChild(button);

    });
});

}

listar();

function create() {
    let nome = document.getElementById('nome').value;
    let telefone = document.getElementById('telefone').value;

    fetch('http://172.22.240.1:8080/agenda', {
        method: 'POST',
        body: JSON.stringify({
            nome,
            telefone
        }),
        headers: {
            'Content-Type': 'application/json'
        },
    }).then(response => response.json()).then(json => {
        console.log(json);
        list.innerHTML = '';
        listar();
    });
}

function deletar(id) { 
   
    fetch(`http://172.22.240.1:8080/agenda/${id}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },
        })
        
        recarregarPagina();
   
}

function recarregarPagina() {
    window.location.reload();
}