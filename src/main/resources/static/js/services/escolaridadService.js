/**
 * Created by SIAVHSA0022 on 19/06/2017.
 */

angular.module("modBuscadorService",["ngResource"])
    .factory("EscolaridadRest", ["$resource",
        function($resource){
            return $resource("../Rest/escolaridad/:methodName", {}, {
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
                searchTypeHead: {
                    method: "POST"
                    ,params:{
                        methodName: "searchTypeHead"
                        , buscar: "@buscar"
                    }
                    ,isArray: true
                },
                getId: {
                    method: "POST"
                    ,params:{
                        methodName: "getId"
                        , buscar: "@id"
                    }
                    ,isArray: true
                }
            });
        }]);