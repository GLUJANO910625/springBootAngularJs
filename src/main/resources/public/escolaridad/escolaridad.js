/**
 * Created by SIAVHSA0022 on 19/06/2017.
 */

angular.module("modBuscador", ["ngRoute", "ngSanitize", "modBuscadorService",
    "ngTable", "ui.bootstrap", "ngAnimate", "modUtils"])
    .controller("BuscadorCtrl", function ($scope, $rootScope, $filter, EscolaridadRest, ngTableParams) {
        $scope.txtBuscar = undefined;

        $scope.buscarClick = function () {
            $scope.listaPropiedades = EscolaridadRest.list({}, function (response) {
                $scope.tablaEscolaridadParams = new ngTableParams(
                    {
                        page: 1,
                        count: 10
                    },
                    {
                        counts: [],
                        total: 0
                        , getData: function ($defer, params) {
                        var data = response;
                        params.total(data.length);
                        $defer.resolve(data.slice((params.page() - 1) * params.count(), params.page() * params.count()));
                    }
                    });
            });
        };

        $scope.eliminar = function () {

        };

        $scope.editar = function () {

        }
    });