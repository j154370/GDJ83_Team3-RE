<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>RANKING</title>
<c:import url="../template/header.jsp"></c:import>
</head>
<body id="reportsPage" class="font">
		<c:import url="../template/topbar.jsp"></c:import>

		<div class="container">
			<div class="row">
				<div class="col">
					<h1 class="text-white mt-5 mb-5">랭킹 게시판</h1>

					<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
						<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
							<div class="row justify-content-center">

							<c:forEach items="${list}" var="list">
								<!-- 브라우저 사이즈에 따라 column 길이 변화 -->
								<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4 tm-block-col">
									<!-- 카드형 태그 -->
									<div class="card h-10">
										<!-- 디테일가기위한 a태그 -->
										<a href="/rank/rankDetail?pet_num=${list.pet_num }">
											<!-- 카드형 상부 이미지 -->
											<img src="/resources/img/character/4.gif" class="card-img-top" alt="...">
										</a>
										<div class="card-body">
											<!-- 카드 이미지 하단 아이템명, 가격 -->
											<c:choose>
												<c:when test="${list.pet_selected == 1 }">
											<h5 class="card-title">닉네임: ${list.usersDTO.user_nickname}</h5>
											<h5 class="card-title">펫 이름: ${list.pet_name }</h5>
											<h5 class="card-title">레벨: ${list.pet_level }</h5>
											<h5 class="card-title">인기도: ${list.pet_pop }</h5>
												</c:when>
											</c:choose>
													<a id="arankboard" href="../ingame/fight?item_num=${list.item_num}"><img style="width:40%" src="/resources/img/rankboard/playimg.png"></a> 
													<a id="arankboard2" href="#"><img style="width:40%;" src="/resources/img/rankboard/likeimg.png"></a> 
																							
												
										</div>
									</div>
								</div>							
							</c:forEach>
							</div>
						</div>
					</div>



					<!-- row -->
				</div>
			</div>
		</div>

	<c:import url="../template/footer.jsp"></c:import>
	<c:import url="../template/boot-footer.jsp"></c:import>
	<script src="/resources/js/users/myPetList.js"></script>
</body>
</html>
	

</body>
</html>