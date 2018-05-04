/**
 * Created by SIAVHSA0022 on 19/06/2017.
 */

angular.module("modBuscador", ["ngRoute", "ngSanitize", "modBuscadorService",
    "ngTable", "ui.bootstrap", "ngAnimate", "modUtils","modEscolaridadEdicion"])
    .controller("BuscadorCtrl", function ($scope, $rootScope, $filter, EscolaridadRest, ngTableParams) {
        $scope.txtBuscar = undefined;

        $scope.buscarClick = function () {
            EscolaridadRest.list({}, function (response) {
                $scope.listaEscolaridad = response;
                    $scope.tablaEscolaridadParams = new ngTableParams(
                    {
                        page: 1,
                        count: 10
                    },
                    {
                        counts: [],
                        total: 0
                        , getData: function ($defer, params) {
                        var data = $scope.listaEscolaridad;
                        params.total(data.length);
                        $defer.resolve(data.slice((params.page() - 1) * params.count(), params.page() * params.count()));
                    }
                    });
            });
        };

        $rootScope.$on("reloadEscolaridad", function () {
            EscolaridadRest.list({}, function (response) {
                $scope.listaEscolaridad = response;
                $scope.tablaEscolaridadParams.reload();
            });
        });

    })
    .config(["$routeProvider", function ($routeProvider) {
        $routeProvider.when("/escolaridadEdicion", {
            controller: "EscolaridadEdicionCtrl"
            , templateUrl: "escolaridadEdicion.html"
        });
        $routeProvider.when("/escolaridadEdicion/:id", {
            controller: "EscolaridadEdicionCtrl"
            , templateUrl: "escolaridadEdicion.html"
        });
    $routeProvider.otherwise({redirectTo: "/"});

}]);

