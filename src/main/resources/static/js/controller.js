app
    .controller('usersController', function ($scope) {
        $scope.headingTitle = "User List:";
    })

    .controller('rolesController', function ($scope) {
        $scope.headingTitle = "Roles List:";
    })

    .controller('customersController', function ($scope, $http) {
        $scope.headingTitle = "Customers List:";
        $http
            .get("http://localhost:8080/customers")
            .then(function (response) {
                var customers = response.data._embedded.customers;
                console.log(customers);
                $scope.customers = customers;
            })
    })

;
