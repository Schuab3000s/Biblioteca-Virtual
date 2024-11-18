document.addEventListener("DOMContentLoaded", () => {
    fetch("/autores")
            .then(response => response.json())
            .then(autores => {
                const autorSelect = document.getElementById("autor");
                autores.forEach(autor => {
                    const option = document.createElement("option");
                    option.value = autor.id;
                    option.textContent = autor.nome;
                    autorSelect.appendChild(option);
                });
            });

    fetch("/generos")
            .then(response => response.json())
            .then(generos => {
                const generoSelect = document.getElementById("genero");
                generos.forEach(genero => {
                    const option = document.createElement("option");
                    option.value = genero.id;
                    option.textContent = genero.nome;
                    generoSelect.appendChild(option);
                });
            });

    const form = document.getElementById("cadastroLivroForm");
    form.addEventListener("submit", event => {
        event.preventDefault();

        // Objeto do livro
        const livro = {
            nome: document.getElementById("nome").value.trim(),
            autorId: parseInt(document.getElementById("autor").value),
            generoId: parseInt(document.getElementById("genero").value),
            dataLancamento: document.getElementById("dataLancamento").value,
        };

        // Verificação de dados
        if (!livro.nome || !livro.autorId || !livro.generoId || !livro.dataLancamento) {
            alert("Por favor, preencha todos os campos.");
            return;
        }

        // Enviar requisição POST
        fetch("/livros", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(livro),
        })
                .then(response => {
                    if (response.ok) {
                        alert("Livro cadastrado com sucesso!");
                        window.location.href = "/lista-livros.html";
                    } else {
                        return response.json().then(error => {
                            console.error("Erro ao cadastrar livro:", error);
                            alert("Erro ao cadastrar o livro: " + (error.message || "Erro desconhecido."));
                        });
                    }
                })
                .catch(error => {
                    console.error("Erro na requisição:", error);
                    alert("Erro ao conectar com o servidor.");
                });
    });
});