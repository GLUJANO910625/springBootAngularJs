angular.module("modEscolaridadEdicion", ["ngRoute", "ngSanitize",
    "ngTable", "ui.bootstrap", "ngAnimate", "modUtils","modBuscadorService"])
    .controller("EscolaridadEdicionCtrl", function ($scope,$location, $routeParams, EscolaridadRest, $rootScope) {
        $('#dlgEscolaridadEdicion').on('hidden.bs.modal', function () {
            //Redirigir a la url raiz.
            $scope.$apply(
                $location.path("/")
            );
        });

        if($routeParams.id){
            $scope.escolaridad = EscolaridadRest.id({id:$routeParams.id});
        }else {
            $scope.escolaridad = {activo: true};
        }

        $scope.submitForm = function () {
            //if($scope.frmEscolaridad.validate()){
                EscolaridadRest.put($scope.escolaridad,function(){
                    if ($scope.escolaridad.id) {
                        console.log('Se Actualizo');
                        //$alert.success("Actualizaci&oacute;n","La escolaridad se actualiz\u00f3 correctamente.");
                    } else {
                        console.log('Se Guardo');
                        //$alert.success("Guardado","La nueva escolaridad se ha guardado correctamente.");
                    }
                    $scope.escolaridad = {};
                    $('#dlgEscolaridadEdicion').modal('hide');
                    $rootScope.$broadcast("reloadEscolaridad");
                },function(error){
                    //$alert.danger("ERROR: " + error.data.message + " ESTATUS: " + error.statusText);
                });
            //}

        };
    });
