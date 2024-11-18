document.addEventListener('DOMContentLoaded', async () => {
    const tableBody = document.querySelector('tbody');

    async function carregarLivros() {
        try {
            const response = await fetch('/livros'); // Endpoint correto
            if (response.ok) {
                const livros = await response.json();
                tableBody.innerHTML = ''; // Limpa a tabela
                livros.forEach(livro => {
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${livro.nome || 'N/A'}</td>
                        <td>${livro.autor ? livro.autor.nome : 'N/A'}</td>
                        <td>${livro.genero ? livro.genero.nome : 'N/A'}</td>
                        <td>${livro.dataLancamento || 'N/A'}</td>
                    `;
                    tableBody.appendChild(row);
                });
            } else {
                alert('Erro ao carregar lista de livros');
            }
        } catch (error) {
            console.error('Erro:', error);
            alert('Erro ao conectar com o servidor');
        }
    }

    await carregarLivros();
});
