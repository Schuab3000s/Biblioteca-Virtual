document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');
    
    form.addEventListener('submit', function(event) {
        const nome = document.getElementById('nome').value.trim();
        const data = document.getElementById('data').value;
        
        if (nome === '' || data === '') {
            alert('Por favor, preencha todos os campos.');
            event.preventDefault(); // Impede o envio do formulário se houver campos vazios
        }
        
        // Validação da data (impede datas futuras)
        const dataLancamento = new Date(data);
        const dataAtual = new Date();
        
        if (dataLancamento > dataAtual) {
            alert('A data de lançamento não pode ser no futuro.');
            event.preventDefault();
        }
    });
});
