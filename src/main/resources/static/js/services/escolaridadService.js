/**
 * Created by SIAVHSA0022 on 19/06/2017.
 */

angular.module("modBuscadorService",["ngResource"])
    .factory("EscolaridadRest", ["$resource",
        function($resource){
            return $resource("../Rest/escolaridad/:methodName", {}, {
                put: {
                    method:"POST"
                    ,params:{
                        methodName:"put"
                        ,escolaridad:"@especialidad"
                    }
                    ,isArray: false
                },
                list: {
                    method: "POST"
                    ,params: {
                        methodName: "list"
                    }
                    ,isArray: true
                },
                buscar: {
                    method: "POST"
                    ,params: {
                        methodName: "buscar"
                        ,busqueda: "@busqueda"
                    }
                    ,isArray: true
                },
                delete:{
                    method:"POST"
                    ,params:{
                        methodName:"delete",
                    escolaridad:"@escolaridad"
                    }
                },
                id: {
                    method:"GET"
                    ,params:{
                        methodName:"id"
                        ,id:"id"
                    }
                    ,isArray: false
                }
            });
        }]);