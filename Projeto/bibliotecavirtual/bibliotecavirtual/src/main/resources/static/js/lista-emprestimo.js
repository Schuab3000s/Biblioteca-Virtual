document.addEventListener('DOMContentLoaded', async () => {
    const tableBody = document.querySelector('tbody');

    async function carregarEmprestimos() {
        try {
            const response = await fetch('/emprestimos');
            if (response.ok) {
                const emprestimos = await response.json();
                tableBody.innerHTML = ''; // Limpa a tabela antes de preenchê-la
                emprestimos.forEach(emprestimo => {
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${emprestimo.livro.nome}</td>
                        <td>${emprestimo.cliente.nome}</td>
                        <td>${emprestimo.data}</td>
                        <td>${emprestimo.devolvido ? 'Sim' : 'Não'}</td>
                    `;
                    tableBody.appendChild(row);
                });
            } else {
                alert('Erro ao carregar lista de empréstimos');
            }
        } catch (error) {
            console.error('Erro:', error);
            //alert('Erro ao conectar com o servidor');
        }
    }

    document.getElementById('buscarEmprestimo').addEventListener('input', (e) => {
        const termo = e.target.value.toLowerCase();
        const rows = tableBody.querySelectorAll('tr');
        rows.forEach(row => {
            const texto = row.textContent.toLowerCase();
            row.style.display = texto.includes(termo) ? '' : 'none';
        });
    });

    window.excluirEmprestimo = async () => {
        // Aqui você pode implementar a exclusão
        alert('Função de exclusão implementada.');
    };

    await carregarEmprestimos();
});
