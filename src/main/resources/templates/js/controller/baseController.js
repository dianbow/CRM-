app.controller('baseController', function($scope){
	// 分页控件配置
	// currentPage:当前页
	// totalItems:总条数
	// itemsPerPage:每页数
	// perPageOptions:每页数的选项
	// onChange:改变事件
	$scope.paginationConf = {
		currentPage : 1,
		totalItems : 0,
		itemsPerPage : 5,
		perPageOptions : [ 5, 10, 20, 30, 40, 50 ],
		onChange : function() {
			$scope.reloadList();// 重新加载
		}
	};
	// 重新加载
	$scope.reloadList = function() {
		// $scope.findPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
		$scope.search($scope.paginationConf.currentPage,
				$scope.paginationConf.itemsPerPage);
	}
	// 复选框的IDS
	$scope.selectedIds = [];
	$scope.updateSelected = function($event, id) {
		if ($event.target.checked) {
			// 判断是选中
			$scope.selectedIds.push(id);
			// console.log($scope.selectedIds);
		} else {
			// 判断是取消
			var index = $scope.selectedIds.indexOf(id);
			$scope.selectedIds.splice(index, 1);
			// console.log($scope.selectedIds);
		}
	}
});