/**
 * Created by SIAVHSA0022 on 19/06/2017.
 */

angular.module("modBuscador", ["ngRoute", "ngSanitize", "modBuscadorService",
    "ngTable", "ui.bootstrap", "ngAnimate", "modUtils", "modAlert"])
    .controller("BuscadorCtrl", function ($scope, $rootScope, $filter, EscolaridadRest, ngTableParams, $alert) {
        $scope.txtBuscar = undefined;

        $scope.buscarClick = function () {
            $scope.listaEscolaridad = EscolaridadRest.list({}, function (response) {
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

        $rootScope.$on("reloadEscolaridad", function () {
            $scope.listaEscolaridad = EscolaridadRest.list({}, function () {
                $scope.tablaEscolaridadParams.reload();
            });
        });

        //Edición
        $scope.edicionEscolaridad = function (escolaridad) {
            EscolaridadRest.id({id:escolaridad.id}, function (response) {
                $scope.escolaridad = response;
                $('#escolaridadEdicion').modal('show');
            });
        };

        $scope.abrirModalAgregar = function () {
            $('#escolaridadEdicion').modal('show');
        };

        $scope.submitForm = function () {
            EscolaridadRest.put($scope.escolaridad,function(){
                if ($scope.escolaridad.id) {
                    console.log('Se Guardo');
                    $alert.success("Actualizaci&oacute;n","La escolaridad se actualiz\u00f3 correctamente.");
                } else {
                    console.log('No se Guardo');
                    $alert.success("Guardado","La nueva escolaridad se ha guardado correctamente.");
                }
                $scope.escolaridad = {};
                $('#escolaridadEdicion').modal('hide');
                $rootScope.$broadcast("reloadEscolaridad");
            },function(error){
                console.log('Error')
                $alert.danger("ERROR: " + error.data.message + " ESTATUS: " + error.statusText);
            });
        }
    });