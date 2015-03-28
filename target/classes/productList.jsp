<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>河北大厂农村商业银行股份有限公司</title>
<meta name="keywords" content="河北大厂农村商业银行股份有限公司" />
<meta name="description" content="河北大厂农村商业银行股份有限公司" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/webskys.js"></script>
<script type="text/javascript" src="js/ie6png.js"></script>
<script type="text/javascript" src="js/gun.js"></script>
</head>
<body>
	<div class="top">
		<div class="topright">
			<ul>
				<li class="li01"><a href='toIndex'>首页</a></li>
				<li class="li02"><a href='javascript:void();'
					onClick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.mycodes.net');"
					rel="nofollow">设为首页</a></li>
				<li class="li03"><a
					onclick="window.external.addFavorite(location.href,document.title)"
					href="javascript:void();" rel="nofollow">加入收藏</a></li>
			</ul>
		</div>
		<div class="logo">
			<a href="toIndex" title="-河北大厂农村商业银行股份有限公司"><img
				src="images/logo.png" width="502" height="71" alt="河北大厂农村商业银行股份有限公司" /></a>
		</div>
		<div class="righttel">
			<img src="images/tel.png" width="200" height="30" alt="前端设计联系电话" />
		</div>
		<div class="webnav">
			<ul>
				<li><a href="toIndex" title="网站首页">网站首页</a></li>
				<li><a href="toAricleList?articleType=BL" title="公示公告">公示公告</a></li>
				<li><a href="toAricleList?articleType=NL" title="农信要闻">农信要闻</a></li>
				<li class="licur"><a href="toAricleList?articleType=PL" title="产品展示">产品展示</a></li>
				<li><a href="toAricleList?articleType=SL" title="业务介绍">业务介绍</a></li>
				<!-- 
				<li><a href="#" title="其他模块">其他模块</a></li>
				<li><a href="#" title="其他模块">其他模块</a></li>
				<li><a href="#" title="其他模块">其他模块</a></li>
				<li><a href="#" title="其他模块">其他模块</a></li>
				 -->
			</ul>
		</div>
	</div>
	<div class="banner">
		<div id="banlbar"></div>
		<div id="banrbar"></div>
		<div id="banh">
			<ul>
				<s:iterator value="photoList" var="photos">
					<li><img src="showPhoto?photoType=0&photo.id=${ photos.id }" /></li>
				</s:iterator>
			</ul>
		</div>
	</div>
	<div class="index_con">
		<div class="page_left">
			<h2 class="left_title">产品展示</h2>
			<div class="leftbg borl_r">
				<ul class="classul">
					<li><a href="#">产品展示</a></li>
				</ul>
			</div>
			<div class="left_bot"></div>
		</div>
		<div class="page_right">
			<div class="pagetop">
				<span class="web_navi">当前位置：<a href="#">首页</a> &gt;&gt; 产品展示
				</span>
				<h2>产品展示</h2>
			</div>
			<div class="borl_r">
				<ul class="picul">
					<s:iterator value="productList" var="op">
					<li>
						<a href="toAricle?articleType=PL&product.id=${ op.id }" title="${ op.title }">
						<img src="showPhoto?photoType=1&photo.id=${ op.photo_id }" onload="this.width=192;height=135"/></a>
						<p>
							<a href="toAricle?articleType=PL&product.id=${ op.id }" title="${ op.title }">${ op.title }</a>
						</p>
						</s:iterator>
					</li>
				</ul>
				<div class="epages">
					<b class="totle">共12条记录 5页</b><a href="#">上一页</a><a href="#">1</a><a
						href="#">2</a><b>3</b><a href="#">4</a><a href="#">下一页</a><a
						href="#">尾页</a>
				</div>
			</div>
			<div class="page_bot"></div>
		</div>
		<div class="clear"></div>
		<div class="blank10"></div>
	</div>
	<div class="bottom">
		<div class="patecopy">
			<p>
				Powered by <strong>河北大厂农村商业银行股份有限公司</strong> &copy; 2011-2015 All Right
				Reserved.
			</p>
			<p>
				<a href="#" target="_blank">浙ICP备11005891号</a>
			</p>
		</div>
	</div>
</body>
</html>