app.controller('brandController', function($scope,$controller, brandService) {
	//继承 
	$controller('baseController',{$scope:$scope});
	
	// 查询所有品牌结果集
	$scope.findAll = function() {
		brandService.findAll().success(function(response) {
			$scope.list = response;
		});
	}

	// 有条件查询分页对象
	$scope.searchEntity = {};
	$scope.search = function(pageNum, pageSize) {
		// 当前页 每页数 条件对象
		brandService.search(pageNum, pageSize,$scope.searchEntity).success(
						function(response) {
							$scope.list = response.rows;
							$scope.paginationConf.totalItems = response.total;
						});
	}

	// 重新加载
	$scope.findPage = function(pageNum, pageSize) {
		// 返回分页对象 基本属性:品牌结果集 总条数
		brandService.findPage(pageNum, pageSize).success(function(response) {
			$scope.list = response.rows;
			$scope.paginationConf.totalItems = response.total;
		}

		);
	}
	// 品牌添加
	$scope.add = function() {
		// 添加
		var object = brandService.add($scope.entity);
		// 判断是添加 还是修改
		if ($scope.entity.id != null) {
			// 修改
			object = brandService.update($scope.entity);
		}
		object.success(
				function(response) {
					if (response.flag) {
						// 重新加载
						$scope.reloadList();
					} else {
						// 失败
						alert(response.message);
					}

				});

	}
	// 弹出修改窗口 查询一个品牌
	$scope.findOne = function(id) {
		brandService.findOne(id).success(function(response) {
			$scope.entity = response;
		});
	}
	// 删除 批量
	$scope.dele = function() {
		if (confirm("你确定删除吗?")) {
			brandService.dele($scope.selectedIds).success(
					function(response) {
						if (response.flag) {
							// 重新加载
							$scope.reloadList();
							// 清空之前的ID
							$scope.selectedIds = [];
						} else {
							// 失败
							alert(response.message);
						}
					});
		}
	}
});