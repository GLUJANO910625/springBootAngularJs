angular.module("modEscolaridadEdicion", ["ngRoute", "ngSanitize",
    "ngTable", "ui.bootstrap", "ngAnimate", "modUtils","modBuscadorService"])
    .controller("EscolaridadEdicionCtrl", function ($scope,$location,EscolaridadRest) {
        $('#dlgEscolaridadEdicion').on('hidden.bs.modal', function () {
            //Redirigir a la url raiz.
            $scope.$apply(
                $location.path("/")
            );
        });

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
