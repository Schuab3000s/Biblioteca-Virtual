document.addEventListener('DOMContentLoaded', () => {
    const form = document.querySelector('#login-form');

    form.addEventListener('submit', async (e) => {
        e.preventDefault();

        const username = document.querySelector('#username').value;
        const password = document.querySelector('#password').value;

        try {
            const response = await fetch('/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ username, password })
            });

            if (response.ok) {
                alert('Login bem-sucedido!');
                window.location.href = '/lista-livros.html'; // Redirecione para a página desejada
            } else {
                alert('Credenciais inválidas');
            }
        } catch (error) {
            console.error('Erro:', error);
            alert('Erro ao conectar com o servidor');
        }
    });
});
