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
				<li class="licur"><a href="toIndex" title="网站首页">网站首页</a></li>
				<li><a href="toAricleList?articleType=BL" title="公示公告">公示公告</a></li>
				<li><a href="toAricleList?articleType=NL" title="农信要闻">农信要闻</a></li>
				<li><a href="toAricleList?articleType=PL" title="产品展示">产品展示</a></li>
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
		<div class="ind_news">
			<div class="title">
				<a href="#" class="indmore"></a>
				<h2>公示公告</h2>
			</div>
			<div class="indlist borl_r">
				<ul class="ind_newsul">
				<s:iterator value="bulletinList" var="bulletin">  
					<li><a href="toAricle?articleType=BL&bulletin.id=${ bulletin.id }" title="${ bulletin.title }">${ bulletin.title }</a></li>
				</s:iterator>
				</ul>
			</div>
			<div class="indnewbot"></div>
		</div>
		<div class="new_article">
			<div class="title">
				<a href="#" class="indmore"></a>
				<h2>农信要闻</h2>
			</div>
			<div class="indlist borl_r">
				<ul class="ind_newsul">
					<s:iterator value="newsList" var="news">  
						<li><a href="toAricle?articleType=NL&news.id=${ news.id }" title="${ news.title }">${ news.title }</a></li>
					</s:iterator>
					</li>
				</ul>
			</div>
			<div class="indprobot"></div>
		</div>
		<div class="ind_contact">
			<div class="ind_contact">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="36" valign="top"
							background="images/webBlank/right.jpg">
							<table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="100%" height="31" align="center" class="font2">网上银行登陆</td>
									<td width="100%">&nbsp;</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td align="center" background="images/webBlank/right2.jpg"><a
							href="https://www.hb96369.com/pb_jump.html" target="_blank"><img
								src="images/webBlank/gr.jpg" width="187" height="44" border="0" /></a>
							<br /> <a href="https://www.hb96369.com/cb_jump.html"
							target="_blank"><img src="images/webBlank/qy.jpg" border="0" /></a>
							<br /> <a
							href="https://www.hb96369.com:476/corporbank/ebankslipValidateNosession.do"
							target="_blank"><img src="images/webBlank/dz.jpg" border="0" /></a>
						</td>
					</tr>
					<tr>
						<td><img src="images/webBlank/right3.jpg" width="100%"
							height="12" /></td>
					</tr>
				</table>
			</div>
		</div>
		<div class="clear"></div>
		<div class="blank10"></div>
		
		<div class="ind_pro">
			<div class="title">
				<a href="#" class="indmore"></a>
				<h2>产品展示</h2>
			</div>
			<div class="indpic2 borl_r">
				<a id="prev" href="javascript:void(0)"></a> <a id="next"
					href="javascript:void(0)"></a>
				<div id="gun">
					<ul id="gunul">
						<s:iterator value="productList" var="product">
						<li><a href="toAricle?articleType=PL&product.id=${ product.id }" title=" ${ product.title }">
								<img src="showPhoto?photoType=1&photo.id=${ product.photo_id }" onload="this.width=192;height=135"/>
							</a>
							<h3>
								<a href="toAricle?articleType=PL&product.id=${ product.id }" title="${ product.title }">${ product.title }</a>
							</h3>
						</li>
						</s:iterator>							
					</ul>
				</div>
			</div>
			<div class="indpic2 indprobot"></div>
		</div>
		<div class="ind_contact">
			<div class="ind_contact">
				<h2>联系我们</h2>
				<div class="catacta borl_r">
					址址：河北大厂农村商业银行股份有限公司<br /> 电话：000-00000000，000-00000000<br />
					传真:000-00000000
					<p>&nbsp;</p>
					<p>&nbsp;</p>
				</div>
				<div class="catacta_bot"></div>
			</div>
		</div>
		<div class="clear"></div>
		<div class="blank10"></div>
		<div class="alli_2">
			<div class="title">
				<a href="#" class="indmore"></a>
			</div>
			<div class="anliacon  borl_r" >
				<table width="100%">
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<s:iterator value="schemeMap" id="colunm" >
						<td width="50%">
							<table width="100%">
								<tr >
									<td colspan="2" style="border-bottom:1px solid #e0e0e0;">
											<H2><s:property value="key"/></H2>
										</a>
									</td>
								</tr>
								<tr>
									<td>
										<table>
											<s:iterator value="value" var="schemeCompany" status="index">
											<s:if test="#index.odd == true">
											<tr>
												<td>
													<td><a href="toAricle?articleType=SL&scheme.id=${ schemeCompany.id }" title="${ schemeCompany.title }">${ schemeCompany.title }</a></td>
												</td>
											</tr>
											</s:if>
											</s:iterator>			
										</table>
									</td>
									<td>
										<table>
											<s:iterator value="value" var="schemeCompany" status="index">
											<s:if test="#index.even == true">
											<tr>
												<td>
													<td><a href="toAricle?articleType=SL&scheme.id=${ schemeCompany.id }" title="${ schemeCompany.title }">${ schemeCompany.title }</a></td>
												</td>
											</tr>
											</s:if>
											</s:iterator>			
										</table>
									</td>
								</tr>
							</table>
						</td>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					</s:iterator>
				</table>
			</div>
			<div class="alli_bot2"></div>
		</div>
		<div class="clear"></div>
		<div class="blank10"></div>
		<div class="clear"></div>
		<div class="blank10"></div>
		
		<div class="clear"></div>
		<div class="blank10"></div>
		
		<div class="clear"></div>
		<div class="blank10"></div>
		
		<div class="clear"></div>
		<div class="blank10"></div>
	</div>
	<div class="bot_nav">
		<div class="bottom">
			<div class="botdiv">
				<h2>
					<a href="#">测试数据测试数据</a>
				</h2>
				<ul>
					<li><a href="#">测试数据测试数据</a></li>
					<li><a href="#">测试数据测试数据</a></li>
					<li><a href="#">测试数据测试数据</a></li>
					<li><a href="#">测试数据测试数据</a></li>
				</ul>
			</div>
			<div class="botdiv">
				<h2>
					<a href="#">测试数据测试数据</a>
				</h2>
				<ul>
					<li><a href="#">测试数据测试数据</a></li>
					<li><a href="#">测试数据测试数据</a></li>
					<li><a href="#">测试数据测试数据</a></li>
					<li><a href="#">测试数据测试数据</a></li>
				</ul>
			</div>
			<div class="botdiv">
				<h2>
					<a href="#">测试数据测试数据</a>
				</h2>
				<ul>
					<li><a href="#">测试数据测试数据</a></li>
					<li><a href="#">测试数据测试数据</a></li>
					<li><a href="#">测试数据测试数据</a></li>
					<li><a href="#">测试数据测试数据</a></li>
				</ul>
			</div>
			<div class="botdiv">
				<h2>
					<a href="#">测试数据测试数据</a>
				</h2>
				<ul>
					<li><a href="#">测试数据测试数据</a></li>
					<li><a href="#">测试数据测试数据</a></li>
					<li><a href="#">测试数据测试数据</a></li>
					<li><a href="#">测试数据测试数据</a></li>
				</ul>
			</div>
			<div class="botdiv">
				<h2>
					<a href="#">测试数据测试数据</a>
				</h2>
				<ul>
					<li><a href="#">测试数据测试数据</a></li>
					<li><a href="#">测试数据测试数据</a></li>
					<li><a href="#">测试数据测试数据</a></li>
					<li><a href="#">测试数据测试数据</a></li>
				</ul>
			</div>
			<div class="clear"></div>
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
		</div>
	</div>
</body>
</html>