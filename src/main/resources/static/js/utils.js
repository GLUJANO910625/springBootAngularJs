/**
 * Created by SIAVHSA0022 on 14/08/2017.
 */

angular.module("modUtils", ["ngSanitize"])
    .run(function ($rootScope, $location) {
        $rootScope.$openModalDialog = function (openModal) {
            var path = $location.path();
            if (path !== "/") {
                var token = path.split("/")[1];
                var selector = "#mdl".concat(token[0].toUpperCase().concat(token.substr(1)));

                if (openModal == undefined || openModal == null) {
                    openModal = true;
                }

                if (selector && openModal) {
                    $(selector).modal('show');
                }
            }
        };
    });
