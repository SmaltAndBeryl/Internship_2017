var profileCreationTp = angular.module('hello');

profileCreationTp.controller('profileCreationTp' , function($scope, $http){

//    $http.get('/url')
//        .then(function(response){
//
//        });

    var trainingPartner = {};

    // Store response.data into trainingPartner

    $scope.states = ["UP", "Uttarakhand", "MP", "Bihar"];

    $scope.grantTable = {
        enableGridMenus : false,
        enableSorting: false,
        enableFiltering: false,
        enableCellEdit : true,
        enableColumnMenus : false,
        enableHorizontalScrollbar:0,

        columnDefs:[
          { name: 'SNo',           displayName: 'SNo.',              cellClass:'sno',  headerCellClass:'layer'},
          { name: 'ministry',            displayName: 'Ministry from which grant was received ',          cellClass:'fname',headerCellClass:'File-Name'},
          { name: 'natureOfWork',            displayName: 'Nature of Work',               cellClass:'type', headerCellClass:'Type'},
          { name: 'remark',    displayName: 'Remarks',               cellClass:'date', headerCellClass:'Date'},
       ]
      };

    $scope.directorTable = {
          enableGridMenus : false,
          enableSorting: false,
          enableFiltering: false,
          enableCellEdit : true,
          enableColumnMenus : false,
          enableHorizontalScrollbar:0,

          columnDefs:[
            { name: 'Name',           displayName: 'Name',              cellClass:'sno',  headerCellClass:'layer'},
            { name: 'Designation',            displayName: 'Designation',          cellClass:'fname',headerCellClass:'File-Name'},
            { name: 'EmailId',            displayName: 'Email-id',               cellClass:'type', headerCellClass:'Type'},
            { name: 'ContactNumber',    displayName: 'Contact Number',               cellClass:'date', headerCellClass:'Date'},
            { name: 'Educational Qualification',    displayName: 'Educational Qualification',               cellClass:'date', headerCellClass:'Date'},
            { name: 'Experience',    displayName: 'Experience',               cellClass:'date', headerCellClass:'Date'},
            { name: 'UploadCV',    displayName: 'Upload CV',               cellClass:'date', headerCellClass:'Date'},
         ]
        };

    $scope.trainingStaffTable = {
          enableGridMenus : false,
          enableSorting: false,
          enableFiltering: false,
          enableCellEdit : true,
          enableColumnMenus : false,
          enableHorizontalScrollbar:0,

          columnDefs:[
            { name: 'Name',           displayName: 'Name',              cellClass:'sno',  headerCellClass:'layer'},
            { name: 'Designation',            displayName: 'Designation',          cellClass:'fname',headerCellClass:'File-Name'},
            { name: 'EmailId',            displayName: 'Email-id',               cellClass:'type', headerCellClass:'Type'},
            { name: 'EducationalQualification',    displayName: 'Educational Qualification',               cellClass:'date', headerCellClass:'Date'},
            { name: 'IndustrialExperience',    displayName: 'Industrial Experience',               cellClass:'date', headerCellClass:'Date'},
            { name: 'Regular/Visiting',    displayName: 'Regular/Visiting',               cellClass:'date', headerCellClass:'Date'},
            { name: 'UploadCV',    displayName: 'Upload CV',               cellClass:'date', headerCellClass:'Date'},
            { name: 'UploadCertificate',    displayName: 'Upload Certificate',               cellClass:'date', headerCellClass:'Date'},
         ]
        };
    //response is the string that contains the nature of the button
    $scope.submit = function(response){
        alert("Application filled successfully! " + response);
        //POST function to post the data into backend

    };

    $scope.save = function(response){
        alert("Data saved successfully.. " + response);
        //POST function to post into backend
    }
});