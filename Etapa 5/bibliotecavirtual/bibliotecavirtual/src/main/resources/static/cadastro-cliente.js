document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');
    
    form.addEventListener('submit', function(event) {
        const nome = document.getElementById('nome').value.trim();
        const cpf = document.getElementById('cpf').value.trim();
        const endereco = document.getElementById('endereco').value.trim();
        const telefone = document.getElementById('telefone').value.trim();
        
        if (nome === '' || cpf === '' || endereco === '' || telefone === '') {
            alert('Por favor, preencha todos os campos.');
            event.preventDefault(); // Impede o envio do formulário se houver campos vazios
        }
        
        // Validação simples para CPF (somente números e 11 dígitos)
        if (!/^\d{11}$/.test(cpf)) {
            alert('CPF inválido. Deve conter 11 dígitos.');
            event.preventDefault();
        }
        
        // Validação simples para telefone (aceitando formatos com ou sem DDD)
        if (!/^\d{10,11}$/.test(telefone)) {
            alert('Número de telefone inválido. Deve conter 10 ou 11 dígitos.');
            event.preventDefault();
        }
    });
});
