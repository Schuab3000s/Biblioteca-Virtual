document.addEventListener('DOMContentLoaded', function() {
    const btnBuscar = document.querySelector('.btn-buscar');
    const inputBuscar = document.querySelector('input[type="text"]');
    
    btnBuscar.addEventListener('click', function(event) {
        if (inputBuscar.value.trim() === '') {
            alert('Por favor, insira um termo de busca.');
            event.preventDefault(); // Impede a busca se o campo estiver vazio
        }
    });
});
