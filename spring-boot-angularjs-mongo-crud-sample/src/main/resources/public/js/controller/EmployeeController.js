angular.module('application', []).controller('EmployeeController', function ($scope, $http) {

    this.save = function () {
        $http.post('/employee', $scope.employee).success(function (data) {
            console.log("saved!");
        });

        $scope.employee = '';
        this.listAll();
    }

    this.listAll = function () {
        this.employees = $http.get('/employee').success(function (data) {
            $scope.employees = data;
        });
    }

    this.listAll();


});