document.getElementById('emailForm').addEventListener('submit', async function (event) {
    event.preventDefault(); 

    const emailInput = document.getElementById('emailAddress'); 
    const email = emailInput.value;  
    const emailType = document.getElementById('emailType').value;  

    const baseUrl = "http://localhost:8080";

    let url = '';

    switch (emailType) {
        case 'nueva-cuenta':
            url = `${baseUrl}/nueva-cuenta/${email}`;
            break;
        case 'olvide-contrasena':
            url = `${baseUrl}/olvide-contrasena/${email}`;
            break;
        case 'activacion':
            const code = prompt("Por favor, ingresa el código de activación:");
            url = `${baseUrl}/activacion/${email}?code=${encodeURIComponent(code)}`;
            break;
        case 'contrasena-cambiada':
            url = `${baseUrl}/contrasena-cambiada/${email}`;
            break;
        case 'low-stock':
            const product = prompt("Ingresa el nombre del producto:");
            const stock = prompt("Ingresa la cantidad de stock:");
            url = `${baseUrl}/low-stock/${email}?product=${encodeURIComponent(product)}&stock=${stock}`;
            break;
        case 'compra':
            const productos = prompt("Ingresa los productos (separados por comas):").split(",");
            url = `${baseUrl}/compra/${email}?productos=${productos.join('&productos=')}`;
            break;
        default:
            alert("Tipo de correo no válido.");
            return;
    }

    try {
        const response = await fetch(url, {
            method: 'GET',  // Hacer la solicitud GET
        });

        if (response.ok) {
            const result = await response.text();
            document.getElementById('statusMessage').innerText = result; 
        } else {
            document.getElementById('statusMessage').innerText = `Error: ${response.status} ${response.statusText}`; 
        }
    } catch (error) {
        console.error(error);
        document.getElementById('statusMessage').innerText = "Error al conectar con el servidor."; 
    }

    emailInput.value = '';
});
