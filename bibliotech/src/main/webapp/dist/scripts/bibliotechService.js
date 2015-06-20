app.service("livroService", [ '$http', function($http) {
	this.inserir = function(livro) {
		return $http.post('/livros', livro);
	};
	this.getLivros = function() {
		return $http.get('/livros');
	};
	this.atualizaLivros = function(livro) {
		return $http.put('/livros', livro);
	};
} ]);

app.service("alunoService", [ '$http', function($http) {
	this.inserirAluno = function(aluno) {
		return $http.post('/cadastroAluno', aluno);
	};
	this.buscaTodosAlunos = function() {
		return $http.get('/pesquisaTodosAlunos');
	}
} ]);

app.service("editoraService", [ '$http', function($http) {
	this.inserirEditora = function(editora) {
		return $http.post('/editora', editora);
	};
	this.buscaTodasEditoras = function() {
		return $http.get('/editora');
	}
} ]);

app.service("monografiaService", [ '$http', function($http) {
	this.inserirMonografia = function(monografia) {
		return $http.post('/inserirMonografia', monografia);
	};
	this.buscaTodasMonografias = function() {
		return $http.get('/monogragia');
	}
} ]);


app.service("emprestimoService", ['$http', 'livroService', function ($http){
	this.realizarEmprestimo = function (livro){
		return $http.post('/emprestimo', livro.id);
	}
}]);
