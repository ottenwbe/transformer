angular.module('transformer', [])
    .controller('home', function ($scope) {

        $scope.convertedText = {content: 'convertedText'}

        $scope.sendMessage = function(){
            $http({
                url: "....",
                method: "POST",
            }).success(function(data) {
                $scope.convertedText = {content: 'convertedText'}
            }).error(function(data) {
                $scope.convertedText = {content: 'convertedText'}
            });
        }

    })