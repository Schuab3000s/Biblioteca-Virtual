document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');
    
    form.addEventListener('submit', function(event) {
        const data = document.getElementById('data').value;
        
        if (data === '') {
            alert('Por favor, selecione uma data.');
            event.preventDefault(); // Impede o envio do formulário se a data não for selecionada
        }
        
        // Validação da data (impede datas futuras)
        const dataEmprestimo = new Date(data);
        const dataAtual = new Date();
        
        if (dataEmprestimo > dataAtual) {
            alert('A data de empréstimo não pode ser no futuro.');
            event.preventDefault();
        }
    });
});
