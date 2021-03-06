<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board List</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				DataTables Advanced Tables
				<button id="regBtn" type="button" class="btn btn-xs pull-right">작성하기</button>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="board">
							<tr class="odd gradeX">
								<td>${board.bno}</td>
								<td>
									<a href="/board/get?bno=<c:out value="${board.bno}"/>">
									<c:out value="${board.title}"/>
									</a>
								</td>
								<td>${board.writer}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- /.table-responsive -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>

<div id="myModal" class="modal" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Modal title</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p>Modal body text goes here.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">Save changes</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<
<script type="text/javascript">
	$(document).ready(function() {
		var rs = '<c:out value="${result}"/>';

		checkModal(rs);
		
		// 브라우저에서 보관하고 있는 데이터 지움
		history.replaceState({}, null, null);

		function checkModal(rs) {
			if (rs == ''||history.state) {
				return;
			}
			if (parseInt(rs) > 0) {
				$(".modal-body").html(parseInt(rs) + "번 게시글이 등록되었습니다.");
			}
			$("#myModal").modal("show");
		}

		$("#regBtn").click(function() {

			self.location = "/board/register";
			// = window.location (지금 브라우저 위치를 register로 이동해라)

		});

	});
</script>

<%@include file="../includes/footer.jsp"%>
