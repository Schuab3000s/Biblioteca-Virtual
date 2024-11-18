document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('formCadastroCliente');

    form.addEventListener('submit', async (e) => {
        e.preventDefault();

        const cliente = {
            nome: document.getElementById('nome').value,
            cpf: document.getElementById('cpf').value,
            endereco: document.getElementById('endereco').value,
            telefone: document.getElementById('telefone').value
        };

        try {
            const response = await fetch('/clientes', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(cliente)
            });
            if (response.ok) {
                alert('Cliente cadastrado com sucesso!');
                form.reset(); // Limpa os campos do formulário
            } else {
                alert('Erro ao cadastrar cliente');
            }
        } catch (error) {
            console.error('Erro ao conectar com o servidor:', error);
            alert('Erro ao conectar com o servidor');
        }
    });
});
