document.addEventListener('DOMContentLoaded', async () => {
    const livroSelect = document.querySelector('#livro');
    const clienteSelect = document.querySelector('#cliente');
    const form = document.querySelector('#emprestimoForm');

    // Carregar opções de livros
    async function carregarLivros() {
        try {
            const response = await fetch('/livros'); // Certifique-se de que esta rota está correta
            if (response.ok) {
                const livros = await response.json();

                // Certifique-se de que 'livros' contém a propriedade correta, ajuste se necessário
                livros.forEach(livro => {
                    const option = document.createElement('option');
                    option.value = livro.id;
                    option.textContent = livro.titulo || livro.nome || "Sem título"; // Verifique se 'titulo' existe
                    livroSelect.appendChild(option);
                });
            } else {
                alert('Erro ao carregar livros');
            }
        } catch (error) {
            console.error('Erro:', error);
            alert('Erro ao conectar com o servidor');
        }
    }


    // Carregar opções de clientes
    async function carregarClientes() {
        try {
            const response = await fetch('/clientes');
            if (response.ok) {
                const clientes = await response.json();
                clientes.forEach(cliente => {
                    const option = document.createElement('option');
                    option.value = cliente.id;
                    option.textContent = cliente.nome;
                    clienteSelect.appendChild(option);
                });
            } else {
                alert('Erro ao carregar clientes');
            }
        } catch (error) {
            console.error('Erro:', error);
            alert('Erro ao conectar com o servidor');
        }
    }

    // Enviar formulário
    form.addEventListener('submit', async (e) => {
        e.preventDefault();

        const emprestimo = {
            livroId: livroSelect.value, // ID do livro selecionado
            clienteId: clienteSelect.value, // ID do cliente selecionado
            dataPedido: document.querySelector('#data').value, // Data do pedido
            emprestado: true,
        };

        try {
            const response = await fetch('/emprestimos', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(emprestimo),
            });

            if (response.ok) {
                alert('Empréstimo registrado com sucesso!');
                window.location.href = 'lista-emprestimo.html';
            } else {
                const errorMsg = await response.text();
                console.error('Erro no back-end:', errorMsg);
                alert('Erro ao registrar empréstimo');
            }
        } catch (error) {
            console.error('Erro:', error);
            alert('Erro ao conectar com o servidor');
        }
    });


    await carregarLivros();
    await carregarClientes();
});
