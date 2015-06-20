var app = angular.module("app.bibliotech.ctrls", [])
.config(function($routeProvider, $locationProvider, $httpProvider) {
    
    
    $locationProvider.html5Mode(false);
    
    var interceptor = ['$location', '$q', function($location, $q){
            
        function success(response) {
            return response;
        }

        function error(response) {

            if(response.status === 401) {
                $location.path('/login');
                return $q.reject(response);
            }
            else {
                return $q.reject(response);
            }
        }

        return function(promise) {
            return promise.then(success, error);
        }
    }];

    $httpProvider.responseInterceptors.push(interceptor);
    
}).run(['$rootScope', '$location', function ($rootScope, $location) {

//    $rootScope.$on("$routeChangeStart", function (event, next, current) {
//    	event.preventDefault();
//        $location.path('/login');
//    });
	
	
    
    $rootScope.appInitialized = true;
}]);

app.controller("cadastroLivroController", [ '$scope', 'livroService', 'editoraService', 'logger',
		function($scope, livroService, editoraService, logger) {
			
	$scope.inserirLivro = function(livro) {
				livroService.inserir(livro).success(function(data){
					$scope.livro = {};
					$scope.form_constraints.$setPristine();
					logger.logSuccess("Operação realizada com sucesso.");
				}).error(function (data){
					logger.logError("Falha ao realizar operação.");
				});
			}
			var buscaTodasEditoras = function(){
				editoraService.buscaTodasEditoras().success(function(editoras){
					$scope.editoras = editoras;
				})
			}
			buscaTodasEditoras();
		} ]);


app.controller("cadastroAlunoController", [ '$scope', 'alunoService',
		function($scope, alunoService) {
			$scope.inserirAluno = function(aluno) {
				alunoService.inserirAluno(aluno).success(function(data) {
					$scope.aluno = {};
					logger.logSuccess("Operação realizada com sucesso.");
				}).error(function (data){
					logger.logError("Falha ao realizar operação.");
				});
			}
		}]);
		
app.controller('ModalDemoCtrl', function ($scope, $modal, $log) {

  $scope.animationsEnabled = true;
 
  $scope.open = function (livro) {
    var modalInstance = $modal.open({
      animation: $scope.animationsEnabled,
      templateUrl: 'myModalContent.html',
      controller: 'ModalInstanceCtrl',
      resolve: {
        livro: function () {
          return livro;
        }
      }
    });

    modalInstance.result.then(function (livro) {
    	$scope.livro = livro.id;
	   }, function () {
	      $log.info('Modal dismissed at: ' + new Date());
	    });
	  };
	  	$scope.toggleAnimation = function () {
	    $scope.animationsEnabled = !$scope.animationsEnabled;
	  };
});

app.controller('ModalInstanceCtrl', function ($scope, $modalInstance, emprestimoService, logger) {

  $scope.nome = "Raphael sua solicitação foi efetuada." + "\n"+
  		"Você tem 24hrs para retirar o seu livro na biblioteca";
 
  $scope.realizaEmprestimo = function (id) {
		emprestimoService.realizarEmprestimo(id).success(function(data){
			$scope.livro = {};
			logger.logSuccess("Operação realizada com sucesso.");
		}).error(function (data){
			logger.logError("Falha ao realizar operação.");
		});
	    $modalInstance.close($scope.nome);
};

  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
});


angular.module("tableSettings", ['app.tables']).controller("tableController", ["$scope", "$filter", "livroService", "emprestimoService",
        function($scope, $filter, livroService, emprestimoService) {
        
        
        var getLivros = function(){
			return	livroService.getLivros().success(function(livros){
				$scope.livros = livros;
				console.log(livros[9].situacao);
				
				var situation = function (){
					if (livros[9].situacao == "DISPONIVEL"){
//						alert("esta disponivel"	);
						angular.element("#situacao").addClass("label-warning");
					}
				}
				$scope.search(), $scope.select($scope.currentPage);
				situation();
			});
        }
        getLivros();
        
        return $scope.livros = $scope.searchKeywords = "", $scope.filteredStores = [], $scope.row = "", $scope.select = function(page) {
            var end, start;
            return start = (page - 1) * $scope.numPerPage, end = start + $scope.numPerPage, $scope.currentPageStores = $scope.filteredStores.slice(start, end)
        }, $scope.onFilterChange = function() {
            return $scope.select(1), $scope.currentPage = 1, $scope.row = ""
        }, $scope.onNumPerPageChange = function() {
            return $scope.select(1), $scope.currentPage = 1
        }, $scope.onOrderChange = function() {
            return $scope.select(1), $scope.currentPage = 1
        }, $scope.search = function() {
            return $scope.filteredStores = $filter("filter")($scope.livros, $scope.searchKeywords), $scope.onFilterChange()
        }, $scope.order = function(rowName) {
            return $scope.row !== rowName ? ($scope.row = rowName, $scope.filteredStores = $filter("orderBy")($scope.livros, rowName), $scope.onOrderChange()) : void 0
        }, $scope.numPerPageOpt = [3, 5, 10, 20], $scope.numPerPage = $scope.numPerPageOpt[2], $scope.currentPage = 1, $scope.currentPageStores = [], (init = function() {
            return $scope.search(), $scope.select($scope.currentPage)
        })()
    }]);

app.controller("cadastroMonografiaController", [ '$scope', 'monografiaService', 'logger', 'alunoService',
	function($scope, monografiaService, logger, alunoService) {
		$scope.inserirMonografia = function(monografia) {
			monografiaService.inserirMonografia(monografia).success(function(data) {
				$scope.monografia = {};
				logger.logSuccess("Operação realizada com sucesso.");
			}).error(function (data){
				logger.logError("Falha ao realizar operação.");
	   });
	}
		var getAllAlunos = function(){
			alunoService.buscaTodosAlunos().success(function(alunos){
				$scope.alunos = alunos;
			})
		}
		getAllAlunos();
}]);

app.controller("loginController",['$scope', function ($scope){
	angular.element("s").removeClass("btn btn-primary");
	
}]);

app.controller("emprestimoController", ['$scope', 'emprestimoService', function ($scope, emprestimoService, $log){
	
//	emprestimoService.realizarEmprestimo(livro).success(function(data){
//		$scope.livro = {};
//		logger.logSuccess("Operação realizada com sucesso.");
//	}).error(function (data){
//		logger.logError("Falha ao realizar operação.");
//	});

}]);
