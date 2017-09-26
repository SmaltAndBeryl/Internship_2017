//profileCreationTp.directive('fileModel', ['$parse', function($parse){
//    return{
//        restrict : 'A',
//        link : function($scope, ele, attrs){
//            var model = $parse(attrs.fileModel);
//            var modeSetter = model.assign;
//
//            ele.bind('change', function(){
//                $scope.$apply(function(){
//                    modelSetter(scope, ele[0].files[0])
//                });
//            });
//        }
//    }
//}]);